package com.jeongchae.common.engine.helper.mybatis;

import java.util.List;
import java.util.Map;

/**  
 * @author       임정채
 * @since        2014.08.20
 * @description  MYBATIS CUSTOM TAG
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2014.08.01      임정채              최초생성	
 *****************************************************************************************************/
public class MybatisHelper {

	/**
	 * 널 혹은 비었는지 여부
	 * <br><br>
	 * 
	 * @param  o1 파라미터 
	 * @return    널 이거나 비었다면 true 아니라면 false
	 ********************************************************************************************/
	public static boolean isEmpty(Object o1){
		
		if( null == o1 ){
			return true;
		}

             if( o1 instanceof String ) { return ((String)o1).isEmpty(); }
        else if( o1 instanceof List   ) { return ((List  )o1).isEmpty(); }
        else if( o1 instanceof Map    ) { return ((Map   )o1).isEmpty(); }
        else                            { return false;                  }
    }
    
	/**
	 * 비어있지 않는지 여부
	 * <br><br>
	 * 
	 * @param  o1 파라미터 
	 * @return    널 이거나 비었다면 false 아니라면 true
	 ********************************************************************************************/
    public static boolean isNotEmpty(Object o1){
    	boolean bb = !isEmpty(o1);
        return bb;
    }
	
    /**
	 * 대상과 같은지 여부
	 * <br><br>
	 * 
	 * @param  o1 비교 대상 1
	 * @param  o2 비교 대상 2
	 * @return    같다면 true 다르다면 false
	 ********************************************************************************************/
    public static boolean isEqual(Object o1, Object o2){
    	
    	if( null == o1 || null == o2){
    		return false;
    	}

        return o1.toString().equals(o2.toString());
    }
    
    /**
	 * 대상과 다른지 여부
	 * <br><br>
	 * 
	 * @param  o1 비교 대상 1
	 * @param  o2 비교 대상 2
	 * @return    같다면 false 다르다면 true
	 ********************************************************************************************/
    public static boolean isNotEqual(Object o1, Object o2){

        return !isEqual(o1, o2);
    }
}
