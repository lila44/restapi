package com.jeongchae.sample.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import lombok.Data;


/**	
 * @author       임정채
 * @since        2017.01.01
 * @description  FORM
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
public class SampleForm {

	/**  
	 * @author       임정채
	 * @since        2017.01.01
	 * @description  ENTITY LIST FORM
	 * @history
	 *       
	 *  수정일                수정자              수정내용
	 *  ----------   ---------   -------------------------------
	 *  2017.01.01      임정채              최초생성	
	 *****************************************************************************************************/
	@Data
	@ApiModel(value="SampleForm.List")
	public static class List {

		@Size(min=5)
		private String userId   = null;
		
		@Size(min=5)
		private String title    = null;
	}
	
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

		@Size(min=5)
		private String userId   = null;
		
		@Size(min=5)
		private String title    = null;
		private String contents = null;
	}

	/**  
	 * @author       임정채
	 * @since        2017.01.01
	 * @description  ENTITY UPDATE FORM
	 * @history
	 *       
	 *  수정일                수정자              수정내용
	 *  ----------   ---------   -------------------------------
	 *  2017.01.01      임정채              최초생성	
	 *****************************************************************************************************/
	@Data
	@ApiModel(value="SampleForm.Update")
	public static class Update {

		@NotBlank
		@Size(min=5)
		private String userId   = null;
		
		@NotBlank
		@Size(min=5)
		private String title    = null;
		
		@NotBlank
		@Size(min=5)
		private String contents = null;
	}
	
	/**  
	 * @author       임정채
	 * @since        2017.02.15
	 * @description  ENTITY RESPONSE FORM
	 * @history
	 *       
	 *  수정일                수정자              수정내용
	 *  ----------   ---------   -------------------------------
	 *  2017.02.15      임정채              최초생성	
	 *****************************************************************************************************/
	@Data
	@ApiModel(value="SampleForm.Response")
	public static class Response {

		private Long   sampleNo = null;  
		private String userId   = null;     
		private String title    = null;   
		private String contents = null;    
		private Date   regDate  = null;
	}

}
