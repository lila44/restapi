package com.jeongchae.common.engine.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
 

/**
 * @author       임정채
 * @since        2017.02.13
 * @description  CONFIG PROPERTIES
 * 				 referense site : http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html#boot-features-external-config-yaml
 * @history      TODO 20170213 임정채
 * 				      ConfigurationProperties.locations deprecated로 다른 방법으로 로드 해야 함.
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.13   임정채              최초생성
 *****************************************************************************************************/
@Data
@Component
@ConfigurationProperties(locations={"classpath:/config/properties/config-jeongchae.yml"}, prefix="cyworld")
public class ConfigProperties { 
	
	/**  
	 * @author       임정채
	 * @since        2017.02.13
	 * @description  SWAGGER CONFIG
	 * @history
	 *       
	 *  수정일                수정자              수정내용
	 *  ----------   ---------   -------------------------------
	 *  2017.02.13      임정채              최초생성	
	 *****************************************************************************************************/
	@Data
	public static class Swagger {
		
		private String name    = null;
		private String desc    = null;
		private String version = null;
	}
	
	/**  
	 * @author       임정채
	 * @since        2017.02.27
	 * @description  TEST CONFIG
	 * @history
	 *       
	 *  수정일                수정자              수정내용
	 *  ----------   ---------   -------------------------------
	 *  2017.02.27      임정채              최초생성	
	 *****************************************************************************************************/
	@Data
	public static class Test {
		
		private String path = null;
	}
	

	private Swagger  swagger  = null;
	private Test     test     = null;
}



