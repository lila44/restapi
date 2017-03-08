package com.jeongchae.common.coder.domain;

import lombok.Data;

/**
 * @author       임정채
 * @since        2017.01.26
 * @description  SAMPLE 기반으로 소스 생성
 * 				  1. DOMAIN
 * 					  - ENTITY
 * 					  - FORM
 * 				  2. SERVICE
 * 				  3. REPOSITORY
 * 				  4. CONTROLLER
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.01.26      임정채              최초생성	
 *****************************************************************************************************/
@Data
public class CoderTable {

	private String  tableName    = null; 
	private String  tableComment = null;
}






