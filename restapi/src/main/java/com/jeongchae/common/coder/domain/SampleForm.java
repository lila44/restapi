package com.jeongchae.common.coder.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;


/**	
 * @author       임정채
 * @since        2017.01.01
 * @description  ENTITY FORM
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.01.01      임정채              최초생성	
 *****************************************************************************************************/
public class SampleForm {

	/**  
	 * @author       임정채
	 * @since        2017.01.01
	 * @description  ENTITY INSERT FORM
	 * @history
	 *       
	 *  수정일                수정자              수정내용
	 *  ----------   ---------   -------------------------------
	 *  2017.01.01      임정채              최초생성	
	 *****************************************************************************************************/
	@Data
	@ApiModel(value="SampleForm.Insert")
	public static class Insert {

		// {FORM_LIST}
	}
	
	/**  
	 * @author       임정채
	 * @since        2017.01.01
	 * @description  ENTITY RESPONSE FORM
	 * @history
	 *       
	 *  수정일                수정자              수정내용
	 *  ----------   ---------   -------------------------------
	 *  2017.01.01      임정채              최초생성	
	 *****************************************************************************************************/
	@Data
	@ApiModel(value="SampleForm.Response")
	public static class Response {

		// {FORM_LIST}
	}
}
