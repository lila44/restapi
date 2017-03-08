package com.jeongchae.common.util.string;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**  
 * @author       임정채
 * @since        2014.09.19
 * @description  문자 유틸
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2014.08.20      임정채              최초생성	
 *  2014.09.22   임정채              JSON 변환 추가
 *****************************************************************************************************/
public class UString {

	/**
	 * 해당 정규식에 맞는지 여부 반환
	 * <br> - [^0-9]                : 정수 여부
	 * <br> - [^a-zA-Z]             : 영문 여부
	 * <br> - [^ㄱ-ㅎ가-힣]          : 한글 여부
	 * <br> - [^a-zA-Z0-9]          : 영문, 숫자 여부
	 * <br> - [^ㄱ-ㅎ가-힣a-zA-Z0-9] : 한글, 영문, 숫자 여부
	 * <br><br>
	 * 
	 * @param  regex 정규식
	 * @param  value 정규식 검사 값
	 * @return       정수형 이라면 true 아니라면 false
	 *********************************************************************************/
	public static boolean regex(String regex, String value){	
		
		if( null == regex || null == value ) { 
			return false; 
		}

		Pattern patt  = Pattern.compile(regex);		
		Matcher match = patt.matcher(value);

		
		return match.matches();
	}
	
	/**
	 * 해당 정규식에 맞는 부분 반환
	 * <br><br>
	 * 
	 * @param  regex 정규식
	 * @param  value 정규식 검사 값
	 * @return       매칭 된 값
	 *********************************************************************************/
	public static String getMatchStr(String regex, String value){	
		
		if( null == regex || null == value ) { 
			return null; 
		}

		Pattern patt  = Pattern.compile(regex);		
		Matcher match = patt.matcher(value);

		if( true == match.find() ){
			return match.group();
		}
		
		return null; 
	}
	
	/**
	 * 자릿수를 채워서 반환
	 * <br><br>
	 * 
	 * @param  no    정수
	 * @param  digit 자릿수
	 * @return       자릿수를 0으로 채운 정수
	 *********************************************************************************/
	public static String getPadding(int no, int digit){
		
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
		
		numberFormat.setGroupingUsed(false);
		numberFormat.setMinimumIntegerDigits(digit);
		
		return numberFormat.format(no);
	}
	
	/**
	 * 결과를 JSON 으로 변환
	 * <br><br>
	 * 
	 * @param  o 결과
	 * @return   JSON
	 *********************************************************************************/
	public static String getJson(Object o){
		
		if( null == o ){
			return null;
		}
		
		String       result = null;
		ObjectMapper mapper = new ObjectMapper();
		 
		try               { result = mapper.writeValueAsString(o); }
		catch(Exception e){ e.printStackTrace();                   }
		
		return result;
	}
	
	/**
	 * 랜덤 문자열 반환
	 * <br>ex. 7BOi4F
	 * <br><br>
	 * 
	 * @param  length 길이
	 * @return        랜덤 문자열
	 *********************************************************************************/
	public static String getRandomAlphanumeric(int length){

		return RandomStringUtils.randomAlphanumeric(length);
	}
}



