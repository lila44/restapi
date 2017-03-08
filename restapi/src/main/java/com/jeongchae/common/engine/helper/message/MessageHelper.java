package com.jeongchae.common.engine.helper.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import com.jeongchae.common.engine.exception.common.ExceptionCode;

/**
 * @author       임정채
 * @since        2017.01.19
 * @description  MESSAGE HELPER
 * @history      
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
@Component
public class MessageHelper {
 
	
	/**
	 * STATIC 으로 접근 하기 위한 메세지 인스턴스 설정
	 * <br><br>
	 * 
	 * @param messageSourceAccessor 메세지 인스턴스
	 ********************************************************************************************/
	@Autowired 
	private MessageHelper(MessageSourceAccessor messageSourceAccessor) { 
		
		MessageHelper.accessor = messageSourceAccessor; 
	}
	
	/**
	 * 메세지 반환
	 * <br><br>
	 * 
	 * @param code message_xx.properties 코드 메세지
	 ********************************************************************************************/
	public static String getMessage(String code){
		
		return accessor.getMessage(code);
	}
	
	/**
	 * 메세지 반환
	 * <br><br>
	 * 
	 * @param code 예외 코드
	 ********************************************************************************************/
	public static String getMessage(ExceptionCode code){
		
		return accessor.getMessage(code.name());
	}
	
	
	private static MessageSourceAccessor accessor = null;
}




