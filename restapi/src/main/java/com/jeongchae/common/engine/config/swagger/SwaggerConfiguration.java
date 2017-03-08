package com.jeongchae.common.engine.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jeongchae.common.engine.helper.properties.PropertiesHelper;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 

/**
 * @author       임정채
 * @since        2017.01.11
 * @description  SWAGGER CONFIG
 * @history      http://jojoldu.tistory.com/31
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
@Configuration 
@EnableSwagger2 
public class SwaggerConfiguration { 
	
	/**
	 * SWAGGER
	 * <br><br>
	 * 
	 * @return SWAGGER INSTANCE
	 ********************************************************************************************/
	@Bean 
	public Docket swagger() { 

		return new Docket(DocumentationType.SWAGGER_2) 
				                           .select() 
				                           .apis(RequestHandlerSelectors.any()) // RequestMapping으로 할당 된 모든 URL 목록 
				                           .paths(PathSelectors.ant("/api/**")) // /api/** 필터링 
				                           .build()
				                           .apiInfo(apiInfo());
	}

	/**
	 * SWAGGER API INFO
	 * <br><br>
	 * 
	 * @return SWAGGER API INFO INSTANCE
	 ********************************************************************************************/
	private ApiInfo apiInfo() {
		
	    return new ApiInfo( 
	    			 PropertiesHelper.getSwagger().getName()
	    			,PropertiesHelper.getSwagger().getDesc()
	    			,PropertiesHelper.getSwagger().getVersion()
	    			,null
	    			,ApiInfo.DEFAULT_CONTACT
	    			,null
	    			,null
	    );
	}
}

