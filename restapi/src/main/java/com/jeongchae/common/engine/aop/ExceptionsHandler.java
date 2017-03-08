package com.jeongchae.common.engine.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.jeongchae.common.engine.exception.NoDataException;
import com.jeongchae.common.engine.exception.SystemException;


/**  
 * @author       임정채
 * @since        2017.01.16
 * @description  EXCEPTION HANDLER
 *               reference site : http://onecellboy.tistory.com/346
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *  2017.02.03   임정채              BizException -> SystemException 클래스명 변경
 *  2017.02.06   임정채              NoDataException 추가
 *  2017.02.06   임정채              UsedTransactionIdException 추가
 *  2017.02.06   임정채              NoTransactionIdException 추가
 *  2017.02.07   임정채              EmptyCashException 추가
 *  2017.02.07   임정채              ExceptHandler -> ExceptionsHandler 클래스명 변경
 *  2017.02.08   정범훈              UserPayableException, UserValidException 추가
 *  2017.02.09   정범훈              ChargeException 추가
 *  2017.02.20   임정채              NoPurchaseException 추가
 *  2017.02.20   임정채              NoCancelPurchaseException 추가
 *  2017.02.20   임정채              NoPurchaseTraceException 추가
 *  2017.02.21   임정채              API서버에서 JSON을 받기 위해 모든 응답 코드를 405로 변경
 *                                (API 서버쪽에서 400, 405만 허용되게 변경)
 *  2017.02.24   임정채              ExpireTimeTransactionIdException 추가
 *  2017.02.28   임정채              LackCashException 추가
 *****************************************************************************************************/
@ControllerAdvice
public class ExceptionsHandler {
	
	/**
	 * 일반적인 어플리케이션 예외(어플리케이션 예외 최상위)
	 * <br><br>
	 * 
	 * @param  exception 예외
	 * @return           응답 정보(response status code : 405)
	 ********************************************************************************************/
	@ExceptionHandler(SystemException.class)
	public ResponseEntity<?> handleSystemException(SystemException exception){

		return new ResponseEntity<>(exception.getExceptionResponse(), HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	/**
	 * 데이터 조회를 하지 못했을 경우 발생되는 예외
	 * <br><br>
	 * 
	 * @param  exception 예외
	 * @return           응답 정보(response status code : 405)
	 ********************************************************************************************/
	@ExceptionHandler(NoDataException.class)
	public ResponseEntity<?> handleNoDataException(NoDataException exception){

		return new ResponseEntity<>(exception.getExceptionResponse(), HttpStatus.METHOD_NOT_ALLOWED);
	}
}



