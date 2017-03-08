package com.jeongchae.sample.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;


/**	
 * @author       임정채 
 * @since        2017.01.01
 * @description  ENTITY
 * @history  
 *         
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
@Setter
@Getter
@Entity 
public class Sample {  
 
	@Id
	@GeneratedValue    
	private Long   sampleNo = null;  
	private String userId   = null;     
	private String title    = null;   
	private String contents = null;    
	
	@Column(updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date   regDate  = null;
	
	
	public Sample(){  }
	
	/**
	 * PK 설정
	 * <br><br>
	 * 
	 * @papam sampleNo 샘플 일련번호
	 ********************************************************************************************/
	public Sample(Long sampleNo){
		this.sampleNo = sampleNo;
	}
}




