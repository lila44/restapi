package com.jeongchae.common.engine.helper.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeongchae.common.engine.config.properties.ApplicationProperties;
import com.jeongchae.common.engine.config.properties.ApplicationProperties.Server;
import com.jeongchae.common.engine.config.properties.ApplicationProperties.Spring;
import com.jeongchae.common.engine.config.properties.ConfigProperties;
import com.jeongchae.common.engine.config.properties.ConfigProperties.Swagger;
import com.jeongchae.common.engine.config.properties.ConfigProperties.Test;


/**
 * @author       임정채
 * @since        2017.02.13
 * @description  PROPERTIES HELPER
 * @history      
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.13      임정채              최초생성	
 *****************************************************************************************************/
@Component
public class PropertiesHelper {
 
	
	/**
	 * STATIC 으로 접근 하기 위한 인스턴스 설정
	 * <br><br>
	 * 
	 * @param configProperties      인스턴스
	 * @param applicationProperties 인스턴스
	 ********************************************************************************************/
	@Autowired 
	private PropertiesHelper(ConfigProperties configProperties, ApplicationProperties applicationProperties) { 
		
		PropertiesHelper.configProperties      = configProperties; 
		PropertiesHelper.applicationProperties = applicationProperties; 
	}

	/**
	 * config-cyworld.yml - cyworld.swagger.xxx
	 * <br><br>
	 * 
	 * @return SWAGGER
	 ********************************************************************************************/
	public static Swagger getSwagger(){
		
		return configProperties.getSwagger();
	}
	
	/**
	 * config-cyworld.yml - cyworld.test.xxx
	 * <br><br>
	 * 	
	 * @return TEST DATA
	 ********************************************************************************************/
	public static Test getTest(){
		
		return configProperties.getTest();
	}
	
	/**
	 * application.yml - spring.xxx
	 * <br><br>
	 * 
	 * @return SPRING
	 ********************************************************************************************/
	public static Spring getSpring(){
		
		return applicationProperties.getSpring();
	}
	
	/**
	 * application.yml - server.xxx
	 * <br><br>
	 * 
	 * @return SPRING
	 ********************************************************************************************/
	public static Server getServer(){
		
		return applicationProperties.getServer();
	}
	
	
	private static ConfigProperties      configProperties      = null;
	private static ApplicationProperties applicationProperties = null;
}




