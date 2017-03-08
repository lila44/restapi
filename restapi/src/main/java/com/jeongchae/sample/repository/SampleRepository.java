package com.jeongchae.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeongchae.sample.domain.Sample;
import com.jeongchae.sample.predicate.SampleRepositoryPredicate;


/**  
 * @author       임정채
 * @since        2017.01.01
 * @description  REPOSITORY
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
@Repository
public interface SampleRepository extends JpaRepository<Sample, Long>, SampleRepositoryPredicate {
    
}


