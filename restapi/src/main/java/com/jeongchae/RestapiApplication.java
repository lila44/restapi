package com.jeongchae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author       임정채
 * @since        2017.01.04
 * @description  SPRING BOOT STARTER
 * @history
 *       
 *  수정일         수정자        수정내용
 *  ----------   ---------   -------------------------------
 *  2017.01.04   임정채         최초생성	
 *****************************************************************************************************/
@SpringBootApplication
public class RestapiApplication {

	/**
	 * 실행
	 * <br><br>
	 * 
	 * @param args 필요 파라미터
	 ********************************************************************************************/
	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}
}
