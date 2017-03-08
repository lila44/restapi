package com.jeongchae.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeongchae.common.engine.exception.NoDataException;
import com.jeongchae.common.engine.helper.model.ModelHelper;
import com.jeongchae.sample.domain.Sample;
import com.jeongchae.sample.repository.SampleRepository;


/**
 * @author       임정채
 * @since        2017.01.01
 * @description  SERVICE
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
@Service
@Transactional
public class SampleService {

	/**
	 * 샘플 목록
	 * <br><br>
	 * 
	 * @param  pageable 샘플 목록 정보
	 * @return          샘플 목록
	 ********************************************************************************************/
	@Transactional(readOnly = true)
	public Page<Sample> findAll(Pageable pageable){
		
		return sampleRepository.findAll(pageable);
	}
	
	/**
	 * 샘플 조회
	 * <br><br>
	 * 
	 * @param  sampleNo 샘플 일련 번호
	 * @return          샘플 조회
	 ********************************************************************************************/
	@Transactional(readOnly = true)
	public Sample findOne(Long sampleNo){

		Sample sample = sampleRepository.findOne(sampleNo);
		if ( null == sample ) {
			throw new NoDataException();
        }

		return sample;
	}
	
	/**
	 * 샘플 등록
	 * <br><br>
	 * 
	 * @param  sample 샘플 요청 정보
	 * @return        샘플 등록
	 ********************************************************************************************/
	public Sample insert(Sample sample){

		return sampleRepository.save(sample);
	}
	
	/**
	 * 샘플 수정
	 * <br><br>
	 * 
	 * @param  sampleNo 샘플 일련 번호
	 * @param  sample   샘플 요청 정보
	 * @return          샘플 수정
	 ********************************************************************************************/
	public Sample update(Long sampleNo, Sample sample){

		Sample findSample = sampleRepository.findOne(sampleNo);
        if ( null == findSample ) {
			throw new NoDataException();
        }
        
        sample.setSampleNo(findSample.getSampleNo());
		return ModelHelper.map(sample, findSample); 
	}
	
	/**
	 * 샘플 삭제
	 * <br><br>
	 * 
	 * @param  sampleNo 샘플 일련 번호
	 * @return          샘플 수정
	 ********************************************************************************************/
	public Sample delete(Long sampleNo){
		
		Sample findSample = sampleRepository.findOne(sampleNo);
        if ( null == findSample ) {
			throw new NoDataException();
        }
		
		sampleRepository.delete(sampleNo);
		return findSample; 
	}
	
	/**
	 * queryDSL - 샘플 목록
	 * <br><br>
	 * 
	 * @param  sample 샘플 목록 사용자 입력 정보
	 * @return        검색 목록
	 ********************************************************************************************/
	public List<Sample> queryFindAll(Sample sample){

		return sampleRepository.queryFindAll(sample);
	}
	
	
	@Autowired private SampleRepository sampleRepository = null;
}


