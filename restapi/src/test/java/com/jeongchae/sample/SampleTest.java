package com.jeongchae.sample;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jeongchae.common.engine.exception.NoDataException;
import com.jeongchae.common.engine.helper.model.ObjectHelper;
import com.jeongchae.sample.domain.SampleForm;


/**
 * @author       임정채
 * @since        2017.03.02
 * @description  CONTROLLER TEST
 * 				 <br> - 성공 - 샘플 등록
 * 				 <br> - 성공 - 샘플 목록
 * 				 <br> - 성공 - 샘플 조회
 * 				 <br> - 성공 - 샘플 수정
 * 				 <br> - 성공 - 샘플 삭제
 * 				 <br> - 실패 - 샘플 조회 - [E00010002]데이터 조회를 하지 못했을 경우 발생되는 예외
 * 				 <br> - 실패 - 샘플 수정 - [E00010002]데이터 조회를 하지 못했을 경우 발생되는 예외
 * 				 <br> - 실패 - 샘플 삭제 - [E00010002]데이터 조회를 하지 못했을 경우 발생되는 예외
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.03.02      임정채              최초생성	
 *****************************************************************************************************/
@SpringBootTest
@RunWith(SpringRunner.class) 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class SampleTest {

	/**
   	 * 성공 - 샘플 등록
   	 * <br><br>
   	 ********************************************************************************************/
	@Test 
	public void t1_insert() throws Exception { 
		
		// 샘플 등록
		SampleTestHelper.insert(ObjectHelper.getJsonForFile(SampleTestHelper.PREFIX_TEST_DATA_SAMPLE_INSERT));
	} 
	
	/**
   	 * 성공 - 샘플 목록
   	 * <br><br>
   	 ********************************************************************************************/
	@Test
	public void t2_findAll() throws Exception { 
		
		// 샘플 등록
		SampleTestHelper.insert(ObjectHelper.getJsonForFile(SampleTestHelper.PREFIX_TEST_DATA_SAMPLE_INSERT));
		
		// 샘플 목록 조회
		SampleTestHelper.findAll();
	} 
	
	/**
   	 * 성공 - 샘플 조회
   	 * <br><br>
   	 ********************************************************************************************/
	@Test 
	public void t3_findBySampleNo() throws Exception { 
		
		// 샘플 등록
		SampleForm.Response sampleForm = SampleTestHelper.insert(ObjectHelper.getJsonForFile(SampleTestHelper.PREFIX_TEST_DATA_SAMPLE_INSERT));
		
		// 사용자 별 샘플 목록 조회
		SampleTestHelper.findBySampleNo(sampleForm.getSampleNo());
	} 
	
	/**
   	 * 성공 - 샘플 수정
   	 * <br><br>
   	 ********************************************************************************************/
	@Test 
	public void t4_update() throws Exception { 
		
		// 샘플 등록
		SampleForm.Response sampleForm = SampleTestHelper.insert(ObjectHelper.getJsonForFile(SampleTestHelper.PREFIX_TEST_DATA_SAMPLE_INSERT));
		
		// 샘플 수정
		SampleTestHelper.update(sampleForm.getSampleNo(), ObjectHelper.getJsonForFile(SampleTestHelper.PREFIX_TEST_DATA_SAMPLE_UPDATE));
	} 
	
	/**
   	 * 성공 - 샘플 삭제
   	 * <br><br>
   	 ********************************************************************************************/
	@Test 
	public void t5_delete() throws Exception { 

		// 샘플 등록
		SampleForm.Response sampleForm = SampleTestHelper.insert(ObjectHelper.getJsonForFile(SampleTestHelper.PREFIX_TEST_DATA_SAMPLE_INSERT));
		
		// 샘플 삭제
		SampleTestHelper.delete(sampleForm.getSampleNo());
	} 
	
	/**
   	 * 실패 - 샘플 조회
   	 * <br><br>
   	 ********************************************************************************************/
	@Test(expected=NoDataException.class)
	public void t6_findBySampleNo_NoDataException() throws Exception { 
				
		// 존재하지 않는 샘플 번호
		SampleForm.Response sampleForm = ObjectHelper.getInstanceForFile(SampleForm.Response.class, SampleTestHelper.PREFIX_TEST_DATA_NO_SAMPLE_ID);
				
		// 사용자 별 샘플 목록 조회
		SampleTestHelper.findBySampleNo(sampleForm.getSampleNo());
	} 
	
	/**
   	 * 실패 - 샘플 수정
   	 * <br><br>
   	 ********************************************************************************************/
	@Test(expected=NoDataException.class)
	public void t7_update_NoDataException() throws Exception { 

		// 존재하지 않는 샘플 번호
		SampleForm.Response sampleForm = ObjectHelper.getInstanceForFile(SampleForm.Response.class, SampleTestHelper.PREFIX_TEST_DATA_NO_SAMPLE_ID);
		
		// 샘플 수정
		SampleTestHelper.update(sampleForm.getSampleNo(), ObjectHelper.getJsonForFile(SampleTestHelper.PREFIX_TEST_DATA_SAMPLE_UPDATE));
	} 
	
	/**
   	 * 실패 - 샘플 삭제
   	 * <br><br>
   	 ********************************************************************************************/
	@Test(expected=NoDataException.class)
	public void t8_delete_NoDataException() throws Exception { 

		// 존재하지 않는 샘플 번호
		SampleForm.Response sampleForm = ObjectHelper.getInstanceForFile(SampleForm.Response.class, SampleTestHelper.PREFIX_TEST_DATA_NO_SAMPLE_ID);
		
		// 샘플 삭제
		SampleTestHelper.delete(sampleForm.getSampleNo());
	} 
}

