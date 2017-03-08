package com.jeongchae.common.engine.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


/**	
 * @author       임정채
 * @since        2017.01.19
 * @description  DEFAULT ENTITY
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.01.19      임정채              최초생성	
 *****************************************************************************************************/
@Setter
@Getter
public class DefaultEntity {
	
	private Date regDate = null; // 등록 일시
	private Date updDate = null; // 수정 일시
}
