package com.jeongchae.common.engine.exception;

import com.jeongchae.common.engine.exception.common.ExceptionResponse;

import lombok.Data;

/**
 * @author       임정채
 * @since        2017.03.03
 * @description  ADAPTER 에서 발생 된 예외 정보를 설정하기 위한 예외(AdapterHandler에서 사용)
 *               <br> - 예외 처리시에는 사용되지 않음
 * @history      
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.03.03      임정채              최초생성	
 *****************************************************************************************************/
@Data
public class AdapterException {
 
	private ExceptionResponse exceptionResponse = null;
}



