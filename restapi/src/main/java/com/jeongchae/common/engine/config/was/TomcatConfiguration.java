package com.jeongchae.common.engine.config.was;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

import com.jeongchae.RestapiApplication;
 

/**
 * @author       임정채
 * @since        2017.02.10
 * @description  TOMCAT CONFIG
 * @history      http://jinhokwon.tistory.com/47
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.10      임정채              최초생성	
 *****************************************************************************************************/
@Configuration 
public class TomcatConfiguration extends SpringBootServletInitializer { 
	
	/**
	 * WAR
	 * <br><br>
	 * 
	 * @param builder SPRING APPLICATION BUILDER
	 ********************************************************************************************/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(RestapiApplication.class);
	}
}