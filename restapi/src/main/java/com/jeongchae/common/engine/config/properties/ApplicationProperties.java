package com.jeongchae.common.engine.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
 

/**
 * @author       임정채
 * @since        2017.02.15
 * @description  CONFIG PROPERTIES
 * 				 referense site : http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html#boot-features-external-config-yaml
 * @history      TODO 20170213 임정채
 * 				      ConfigurationProperties.locations deprecated로 다른 방법으로 로드 해야 함.
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.15   임정채              최초생성
 *****************************************************************************************************/
@Data
@Component
@ConfigurationProperties(locations={"classpath:/application.yml"})
public class ApplicationProperties { 
	
	/**  
	 * @author       임정채
	 * @since        2017.02.15
	 * @description  server.xxx
	 * @history
	 *       
	 *  수정일                수정자              수정내용
	 *  ----------   ---------   -------------------------------
	 *  2017.02.15      임정채              최초생성	
	 *****************************************************************************************************/
	@Data
	public static class Server {
		
		private String port = null;
	}
	
	/**  
	 * @author       임정채
	 * @since        2017.02.15
	 * @description  spring.xxx
	 * @history
	 *       
	 *  수정일                수정자              수정내용
	 *  ----------   ---------   -------------------------------
	 *  2017.02.15      임정채              최초생성	
	 *****************************************************************************************************/
	@Data
	public static class Spring {
		
		private String profiles = null;
	}
	

	private Server server = null;
	private Spring spring = null;
}



