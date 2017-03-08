package com.jeongchae.common.engine.aop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.google.common.collect.Lists;
import com.jeongchae.common.engine.exception.common.ExceptionCode;
import com.jeongchae.common.engine.exception.common.ExceptionResponse;
import com.jeongchae.common.engine.helper.message.MessageHelper;


/**  
 * @author       임정채
 * @since        2017.01.04
 * @description  VALIDATOR
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *  2017.02.20   임정채              유효성 검사 시 BAD REQUEST(400) 발생 시 RestTemplate(apiserver 존재) 에서 못받아
 *                           BAD REQUEST(400) -> OK(200) 으로 변경
 *  2017.02.21   임정채              API서버에서 JSON을 받기 위해 모든 응답 코드를 400로 변경
 *                          (API 서버쪽에서 400, 405만 허용되게 변경)
 *****************************************************************************************************/
@Aspect
@Component
public class ValidHandler {

	/**
	 * 올바르지 않은 PARAM 정보에 대한 AOP 
	 * <br><br>
	 * 
	 * @param  point 포인트컷
	 * @return       응답 정보
	 ********************************************************************************************/
	@Around("execution(* com.cyworld..controller.*.*(..))")
	public Object valid(ProceedingJoinPoint point) throws Throwable {

		Object [] argList = point.getArgs();
        for( Object o : argList ){
        	
            if( o instanceof BindingResult ){
            	
                BindingResult result = (BindingResult)o;
                if( true == result.hasErrors() ){

                	List<Map<String, String>> errorList = Lists.newArrayList();
                	for(FieldError fieldError : result.getFieldErrors()){

                        Map<String, String> errorMap = new HashMap<String, String>();
                        errorMap.put("field",   fieldError.getField         ());
                        errorMap.put("message", fieldError.getDefaultMessage());
                        
                        errorList.add(errorMap);
                    }

                	ExceptionResponse exceptionResponse = new ExceptionResponse();
                	exceptionResponse.setCode     (ExceptionCode.E00010001);
                	exceptionResponse.setMessage  (MessageHelper.getMessage(ExceptionCode.E00010001));
                	exceptionResponse.setErrorList(errorList);

                    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
                }                 
            }
        }

        return new ResponseEntity<>(point.proceed(point.getArgs()), HttpStatus.OK);
	}
}
