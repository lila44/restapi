package com.jeongchae.sample.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jeongchae.common.engine.helper.model.ModelHelper;
import com.jeongchae.sample.domain.Sample;
import com.jeongchae.sample.domain.SampleForm;
import com.jeongchae.sample.service.SampleService;


/**  
 * @author       임정채
 * @since        2017.01.01
 * @description  CONTROLLER
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
@RestController
public class SampleController {
	
	/**
	 * 샘플 등록
	 * <br><br>
	 * 
	 * @param  form 샘플 요청 정보
	 * @param  bind 유효성 검증
	 * @return      샘플 응답 정보
	 ********************************************************************************************/
	//@ApiOperation(value="샘플 등록", notes="샘플 등록")
	@PostMapping("/api/samples/rests")
	public Object insert(@Valid @RequestBody SampleForm.Insert form, BindingResult bind){

		Sample              request  = ModelHelper.map(form, Sample.class);
		SampleForm.Response response = ModelHelper.map(sampleService.insert(request), SampleForm.Response.class);
		
		return response;
	}

	/**
	 *      샘플 목록
	 * <br> ex. /api/samples/rests?page=1&size=10&sort=sampleNo,desc&sort=regDate,asc
	 * <br><br>
	 * 
	 * @param  pageable 샘플 목록 정보
	 * @return          샘플 응답 정보
	 ********************************************************************************************/
	@GetMapping("/api/samples/rests")
	public Object findAll(Pageable pageable){

		return ModelHelper.page(sampleService.findAll(pageable), SampleForm.Response.class, pageable);
	}
	
	/**
	 * 샘플 조회
	 * <br><br>
	 * 
	 * @param  sampleNo 샘플 일련 번호
	 * @return          샘플 응답 정보
	 ********************************************************************************************/
	@GetMapping("/api/samples/rests/{sampleNo}")
	public Object findOne(@PathVariable Long sampleNo){

		return ModelHelper.map(sampleService.findOne(sampleNo), SampleForm.Response.class);
	}


	/**
	 * 샘플 수정
	 * <br><br>
	 * 
	 * @param  sampleNo 샘플 일련 번호
	 * @param  form     샘플 요청 정보
	 * @param  bind     유효성 검증
	 * @return          샘플 응답 정보
	 ********************************************************************************************/
	@PutMapping("/api/samples/rests/{sampleNo}")
	public Object update(@PathVariable Long sampleNo, @Valid @RequestBody SampleForm.Update form, BindingResult bind){

		Sample              request  = ModelHelper.map(form, Sample.class);
		SampleForm.Response response = ModelHelper.map(sampleService.update(sampleNo, request), SampleForm.Response.class);
		
		return response;
	}
	
	/**
	 * 샘플 삭제
	 * <br><br>
	 * 
	 * @param  sampleNo 샘플 일련 번호
	 * @return          샘플 응답 정보
	 ********************************************************************************************/
	@DeleteMapping("/api/samples/rests/{sampleNo}")
	public Object delete(@PathVariable Long sampleNo){

		return ModelHelper.map(sampleService.delete(sampleNo), SampleForm.Response.class);
	}
	
	
	@Autowired private SampleService sampleService = null;
}

