package com.jeongchae.common.engine.helper.path;

import java.io.File;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

/**  
 * @author       임정채
 * @since        2017.02.27
 * @description  PATH HELPER
 * @history
 *       
 *  수정일                수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.27   임정채               최초생성
 *****************************************************************************************************/
@Component
public class PathHelper {

	/**
   	 * 해당 클래스 패스의 파일을 반환
   	 * <br><br>
   	 * 
   	 * @param  path 파일 경로
   	 * @return      파일 절대 경로
   	 *************************************************************************************************/
	public static String getPath(String path) {

		try {
			return new ClassPathResource(path).getFile().getPath();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	    return null;
	}
	
	/**
   	 * 프로젝트 최상위 경로 반환
   	 * <br><br>
   	 * 
   	 * @return 프로젝트 최상위 경로 반환
   	 *************************************************************************************************/
	public static String getRootPath(){

		try {
			return new FileSystemResource(File.separator).getFile().getAbsolutePath();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	    return null;
	}
}




