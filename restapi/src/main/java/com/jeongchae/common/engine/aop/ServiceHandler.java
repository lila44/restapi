package com.jeongchae.common.engine.aop;

import java.util.Date;

import javax.persistence.Entity;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.jeongchae.common.engine.domain.DefaultEntity;
import com.jeongchae.common.engine.helper.model.ModelHelper;


/**  
 * @author       임정채
 * @since        2017.03.03
 * @description  INITIALIZE HANDLER
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.03.03      임정채              최초생성	
 *****************************************************************************************************/
@Aspect
@Component
public class ServiceHandler {

	/**
	 * 공통적으로 사용되는 PARAM 정보 초기화를 담당하는 AOP 
	 * <br><br>
	 * 
	 * @param  point 포인트컷
	 ********************************************************************************************/
	@Before("execution(* com.cyworld..service.*.*(..))")
	public void before(JoinPoint point) throws Throwable {

		Object [] argList = point.getArgs();
        for( Object o : argList ){
        	
        	Entity entity = o.getClass().getAnnotation(Entity.class);
            
        	if( null != entity ){
        		
        		DefaultEntity defaultEntity = new DefaultEntity();
        		defaultEntity.setRegDate(new Date());
        		defaultEntity.setUpdDate(new Date());
        		
        		ModelHelper.map(defaultEntity, o);
        	}
        }
	}
}
