package com.jeongchae.sample.predicate;

import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.jeongchae.sample.domain.QSample;
import com.jeongchae.sample.domain.Sample;


/**
 * @author       임정채
 * @since        2017.01.01
 * @description  PREDICATE IMPL
 * 			     reference site : http://www.querydsl.com/static/querydsl/4.1.4/reference/html_single
 * 								  http://youreme.blog.me/110180837747
 * 								  http://adrenal.tistory.com/25
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
public class SampleRepositoryImpl extends QueryDslRepositorySupport implements SampleRepositoryPredicate {

	/**
	 * 샘플 목록
	 * <br><br>
	 * 
	 * @param  sample 샘플 목록 사용자 입력 정보
	 * @return        검색 목록
	 ********************************************************************************************/
	public List<Sample> queryFindAll(Sample sample){

		List<Sample> result =  from(qSample)
//	 			              .where(qSample.userId.eq(sample.getUserId())
//			                  .and(qSample.title.eq (sample.getTitle ())))
			                  .fetch();
		
		return 0 < result.size() ? result : null;
	}

	public SampleRepositoryImpl() {
		super(Sample.class);
	}

	
	private QSample qSample = QSample.sample;
}




