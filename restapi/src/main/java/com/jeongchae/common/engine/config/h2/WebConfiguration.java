package com.jeongchae.common.engine.config.h2;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 

/**
 * @author       임정채
 * @since        2017.01.09
 * @description  WEB CONFIGURER
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
 
	/**
	 * WEB H2 DATABASE
	 * <br><br>
	 * 
	 * @return WEB H2 DATABASE INSTANCE
	 ********************************************************************************************/
	@Bean
	public ServletRegistrationBean h2Servet(){
		
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/h2console/*");
		
		return registrationBean;
	}
}