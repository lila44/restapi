package com.jeongchae.common.engine.exception.common;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
 

/**
 * @author       임정채
 * @since        2017.01.11
 * @description  ERROR RESPONSE
 * @history      
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
@Setter
@Getter
public class ExceptionResponse {
 
	private ExceptionCode             code      = null;
	private String                    message   = null;
	private List<Map<String, String>> errorList = null; 
}