package com.jeongchae.sample;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jeongchae.common.engine.exception.NoDataException;
import com.jeongchae.common.engine.exception.common.ExceptionCode;
import com.jeongchae.common.engine.exception.common.ExceptionResponse;
import com.jeongchae.common.engine.helper.model.ObjectHelper;
import com.jeongchae.sample.domain.SampleForm;


/**
 * @author       임정채
 * @since        2017.03.02
 * @description  SAMPLE TEST HELPER
 * 			     - ResultActions
 * 				   http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/test/web/servlet/ResultActions.html
 * 
 *               - hamcrest 
 *                 http://edgibbs.com/junit-4-with-hamcrest
 *                 http://ddakker.tistory.com/303 
 *               
 *               - 인스턴스의 JSON 문자열 반환
 *                 String requestJson = ObjectHelper.getJsonForInstance(form);
 *                 
 *               - 파일의 JSON 문자열 반환
 *                 String requestJson = ObjectHelper.getJsonForFile(requestForm);
 *                 
 *               - JSON 문자열의 인스턴스 반환
 *                 PurchaseForm.Insert form = ObjectHelper.getInstanceForJson(requestJson, PurchaseForm.Insert.class);
 *                 
 *               - 파일의 인스턴스 반환
 *                 PurchaseForm.Insert form = ObjectHelper.getInstanceForFile("/purchase/purchase.json", PurchaseForm.Insert.class);
 *               
 *               - RESPONSE에서 JSON 반환
 *                 String responseJson = response.andReturn().getResponse().getContentAsString();
 *                 
 *               - RESPONSE에서 인스턴스 반환
 *                 String              responseJson = response.andReturn().getResponse().getContentAsString();
 *                 PurchaseForm.Insert requestJson  = ObjectHelper.getInstanceForJson(responseJson, PurchaseForm.Insert.class);
 * @history      
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.03.02      임정채              최초생성	
 *****************************************************************************************************/
@Component
public class SampleTestHelper {
 
	/**
   	 *      샘플 등록
   	 * <br> 응답코드 : 200
   	 * <br> 예외코드 : 400
   	 * <br><br>
   	 * 
   	 * @param  json 구매 정보
   	 * @return      응답 정보
   	 ********************************************************************************************/
	public static SampleForm.Response insert(String json) throws Exception {

		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post       ("/api/samples/rests"       )
															           .content    (json				       )
															           .contentType(MediaType.APPLICATION_JSON));

		response.andDo    (print());
		response.andExpect(status().isOk());
		response.andExpect(jsonPath("$.code"   ).doesNotExist());
		response.andExpect(jsonPath("$.message").doesNotExist());
		 
		return ObjectHelper.getInstanceForJson(SampleForm.Response.class, response.andReturn().getResponse().getContentAsString());
	}
	
	/**
   	 *      샘플 목록 조회
   	 * <br> 응답코드 : 200
   	 * <br><br>
   	 * 
   	 * @return 응답 정보
   	 ********************************************************************************************/
	public static Map<?,?> findAll() throws Exception {
		
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/samples/rests"));
		
		response.andDo    (print());
		response.andExpect(status().isOk());
		response.andExpect(jsonPath("$.code"   ).doesNotExist());
		response.andExpect(jsonPath("$.message").doesNotExist());
		
		return ObjectHelper.getInstanceForJson(Map.class, response.andReturn().getResponse().getContentAsString());
	}
	
	/**
   	 * <br> 샘플 조회
   	 * <br> 응답코드 : 200
   	 * <br> 예외코드 : 405
   	 * <br>  - [E00010002]NoDataException(데이터 조회를 하지 못했을 경우 발생되는 예외)
   	 * <br><br>
   	 * 
   	 * @param  sampleNo 샘플 번호
   	 * @return 		        응답 정보
   	 ********************************************************************************************/
	public static SampleForm.Response findBySampleNo(Long sampleNo) throws Exception {
		
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get(String.format("/api/samples/rests/%s", String.valueOf(sampleNo)))
															           .contentType(MediaType.APPLICATION_JSON));
		
		// 예외 발생
		String            resonposeContents = response.andReturn().getResponse().getContentAsString();
		ExceptionResponse exceptionResponse = ObjectHelper.getInstanceForJson(ExceptionResponse.class, resonposeContents);
		if( ExceptionCode.E00010002 == exceptionResponse.getCode() ) throw new NoDataException();
				
		response.andDo    (print());
		response.andExpect(status().isOk());
		response.andExpect(jsonPath("$.code"   ).doesNotExist());
		response.andExpect(jsonPath("$.message").doesNotExist());
		 
		return ObjectHelper.getInstanceForJson(SampleForm.Response.class, resonposeContents);
	}
	
	/**
   	 * <br> 샘플 수정
   	 * <br> 응답코드 : 200
   	 * <br> 예외코드 : 405
   	 * <br>  - [E00010002]NoDataException(데이터 조회를 하지 못했을 경우 발생되는 예외)
   	 * <br><br>
   	 * 
   	 * @param  sampleNo 샘플 번호
   	 * @param  json     샘플 정보
   	 * @return 		        응답 정보
   	 ********************************************************************************************/
	public static SampleForm.Response update(Long sampleNo, String json) throws Exception {
		
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.put(String.format("/api/samples/rests/%s", String.valueOf(sampleNo)))
																	   .content    (json				       )
															           .contentType(MediaType.APPLICATION_JSON));
		
		// 예외 발생
		String            resonposeContents = response.andReturn().getResponse().getContentAsString();
		ExceptionResponse exceptionResponse = ObjectHelper.getInstanceForJson(ExceptionResponse.class, resonposeContents);
		if( ExceptionCode.E00010002 == exceptionResponse.getCode() ) throw new NoDataException();
				
		response.andDo    (print());
		response.andExpect(status().isOk());
		response.andExpect(jsonPath("$.code"   ).doesNotExist());
		response.andExpect(jsonPath("$.message").doesNotExist());
		 
		return ObjectHelper.getInstanceForJson(SampleForm.Response.class, resonposeContents);
	}
	
	/**
   	 * <br> 샘플 삭제
   	 * <br> 응답코드 : 200
   	 * <br> 예외코드 : 405
   	 * <br>  - [E00010002]NoDataException(데이터 조회를 하지 못했을 경우 발생되는 예외)
   	 * <br><br>
   	 * 
   	 * @param  sampleNo 샘플 번호
   	 * @return 		        응답 정보
   	 ********************************************************************************************/
	public static SampleForm.Response delete(Long sampleNo) throws Exception {
		
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.delete(String.format("/api/samples/rests/%s", String.valueOf(sampleNo)))
															           .contentType(MediaType.APPLICATION_JSON));
		
		// 예외 발생
		String            resonposeContents = response.andReturn().getResponse().getContentAsString();
		ExceptionResponse exceptionResponse = ObjectHelper.getInstanceForJson(ExceptionResponse.class, resonposeContents);
		if( ExceptionCode.E00010002 == exceptionResponse.getCode() ) throw new NoDataException();
				
		response.andDo    (print());
		response.andExpect(status().isOk());
		response.andExpect(jsonPath("$.code"   ).doesNotExist());
		response.andExpect(jsonPath("$.message").doesNotExist());
		 
		return ObjectHelper.getInstanceForJson(SampleForm.Response.class, resonposeContents);
	}
	
	/**
   	 * 초기화
   	 * <br><br>
   	 * 
   	 * @param context 웹 어플리케이션 컨텍스트
   	 ********************************************************************************************/
	@Autowired
	public SampleTestHelper(WebApplicationContext context){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	

	public static MockMvc mockMvc 						 = null;
	public static String  PREFIX_TEST_DATA_SAMPLE_INSERT = "/jeongchae/sample/Sample.Insert";
	public static String  PREFIX_TEST_DATA_SAMPLE_UPDATE = "/jeongchae/sample/Sample.Update";
	public static String  PREFIX_TEST_DATA_NO_SAMPLE_ID  = "/jeongchae/sample/Sample.Select.NoSampleId";
}




