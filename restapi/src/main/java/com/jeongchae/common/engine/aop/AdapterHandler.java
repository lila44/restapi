package com.jeongchae.common.engine.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.jeongchae.common.engine.exception.AdapterException;
import com.jeongchae.common.engine.helper.context.RequestHelper;
import com.jeongchae.common.engine.helper.model.ModelHelper;


/**  
 * @author       임정채
 * @since        2017.03.03
 * @description  ADAPTER HANDLER 
 *               - ADAPTER에서 예외가 발생되었을 때 실행
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.03.03      임정채              최초생성	
 *****************************************************************************************************/
@Aspect
@Component
public class AdapterHandler {

	/**
	 * 충전 등록 예외 발생 시
	 * <br><br>
	 * 
	 * @param  point     포인트컷
	 * @param  exception 예외
	 ********************************************************************************************/
	@AfterThrowing(pointcut="execution(* com.cyworld..adapter.ChargeAdapter.insert(..)))", throwing="exception")
	public void throwingCharge(JoinPoint point, Throwable exception) {

		insertExceptionBillingLog(point, exception);
	}
	
	/**
	 * 충전 등록 정상 시
	 * <br><br>
	 * 
	 * @param point 포인트컷
	 ********************************************************************************************/
	@AfterReturning(pointcut="execution(* com.cyworld..adapter.ChargeAdapter.insert(..)))")
	public void successCharge(JoinPoint point) {
		
		insertSuccessBillingLog(point);
	}
	
	/**
	 * 구매 등록 예외 발생 시
	 * <br><br>
	 * 
	 * @param  point     포인트컷
	 * @param  exception 예외
	 ********************************************************************************************/
	@AfterThrowing(pointcut="execution(* com.cyworld..adapter.PurchaseAdapter.insert(..)))", throwing="exception")
	public void throwingPurchase(JoinPoint point, Throwable exception) {
		
		insertExceptionBillingLog(point, exception);
	}
	
	/**
	 * 구매 등록 정상 시
	 * <br><br>
	 * 
	 * @param point 포인트컷
	 ********************************************************************************************/
	@AfterReturning(pointcut="execution(* com.cyworld..adapter.PurchaseAdapter.insert(..)))")
	public void successPurchase(JoinPoint point) {
		
		insertSuccessBillingLog(point);
	}

	/**
	 * 예외 로그 등록
	 * <br><br>
	 * 
	 * @param  point     포인트컷
	 * @param  exception 예외
	 ********************************************************************************************/
	private void insertExceptionBillingLog(JoinPoint point, Throwable exception) {
		
		HttpServletRequest request          = RequestHelper.getRequest();
		AdapterException   adapterException = ModelHelper.map(exception, AdapterException.class);
		
		/** TODO 로그 기록 */
	}
	
	/**
	 * 성공 로그 등록
	 * <br><br>
	 * 
	 * @param  point     포인트컷
	 * @param  exception 예외
	 ********************************************************************************************/
	private void insertSuccessBillingLog(JoinPoint point) {
		
		HttpServletRequest request = RequestHelper.getRequest();

		/** TODO 로그 기록 */
	}

}


