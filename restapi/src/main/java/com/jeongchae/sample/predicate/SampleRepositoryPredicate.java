package com.jeongchae.sample.predicate;

import java.util.List;

import com.jeongchae.sample.domain.Sample;


/**
 * @author       임정채
 * @since        2017.01.01
 * @description  PREDICATE
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
public interface SampleRepositoryPredicate {

	/**
	 * 샘플 목록
	 * <br><br>
	 * 
	 * @param  sample 샘플 목록 사용자 입력 정보
	 * @return        검색 목록
	 ********************************************************************************************/
	public List<Sample> queryFindAll(Sample sample);
}





