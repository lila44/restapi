package com.jeongchae.common.engine.exception;

import com.jeongchae.common.engine.exception.common.ExceptionCode;
import com.jeongchae.common.engine.exception.common.ExceptionResponse;
import com.jeongchae.common.engine.helper.message.MessageHelper;

import lombok.Getter;
import lombok.Setter;

/**
 * @author       임정채
 * @since        2017.02.06
 * @description  데이터 조회를 하지 못했을 경우 발생되는 예외
 * @history      
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.06      임정채              최초생성	
 *****************************************************************************************************/
@Setter
@Getter
@SuppressWarnings("serial")
public class NoDataException extends RuntimeException {
 
	/**
	 *      기본 예외 코드 설정(E00010002)
	 * <br> 데이터 조회를 하지 못했을 경우 발생되는 예외
	 * <br><br>
	 ********************************************************************************************/
	public NoDataException(){

		exceptionResponse.setCode   (ExceptionCode.E00010002);
		exceptionResponse.setMessage(MessageHelper.getMessage(ExceptionCode.E00010002)); 
	}
	
	/**
	 *      지정 예외 코드 설정
	 * <br> 데이터 조회를 하지 못했을 경우 발생되는 예외
	 * <br><br>
	 * 
	 * @param exceptionCode 예외 코드
	 ********************************************************************************************/
	public NoDataException(ExceptionCode exceptionCode){

		exceptionResponse.setCode   (exceptionCode);
		exceptionResponse.setMessage(MessageHelper.getMessage(exceptionCode)); 
	}
	
	
	private ExceptionResponse exceptionResponse = new ExceptionResponse();
}



