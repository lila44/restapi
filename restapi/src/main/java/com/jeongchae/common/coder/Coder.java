package com.jeongchae.common.coder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.List;

import com.jeongchae.common.coder.domain.CoderField;
import com.jeongchae.common.coder.helper.CoderHelper;
import com.jeongchae.common.util.file.UFile;
import com.jeongchae.common.util.string.UString;
import com.jeongchae.sample.domain.Sample;
import com.jeongchae.sample.domain.SampleForm;
import com.google.common.base.CaseFormat;

/**
 * @author       임정채
 * @since        2017.01.26
 * @description  SAMPLE 기반으로 소스 생성
 * 				  1. DOMAIN
 * 					  - ENTITY
 * 					  - FORM
 * 				  2. SERVICE
 * 				  3. REPOSITORY
 * 				  4. CONTROLLER
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.01.26      임정채              최초생성	
 *****************************************************************************************************/
public class Coder {

//	public static void main(String[] args) throws Exception {
//		
//		Coder coder = new Coder();
//		coder.createFile();
//	}

	public Coder(){
		
		createFile = new File("D:/develop/coder/" + createpackage.replaceAll("\\.", "/"));
		createFile.mkdirs();
		
		new File("D:/develop/coder/" + createpackage.replaceAll("\\.", "/") + "/domain"    ).mkdirs();
		new File("D:/develop/coder/" + createpackage.replaceAll("\\.", "/") + "/controller").mkdirs();
		new File("D:/develop/coder/" + createpackage.replaceAll("\\.", "/") + "/service"   ).mkdirs();
		new File("D:/develop/coder/" + createpackage.replaceAll("\\.", "/") + "/repository").mkdirs();
		new File("D:/develop/coder/" + createpackage.replaceAll("\\.", "/") + "/predicate" ).mkdirs();
	}
	
	private void createFile() throws Exception {
		
		List<File> fileList = UFile.getFileList(new File(samplePath), sampleExtension);
		
		// CONTROLLER, SERVICE, REPOSITORY, PREDICATE 생성
		for (File file : fileList) {

			String         fileName  = UString.getMatchStr("[\\w]*", file.getName());
			String         parentDir = file.getParent().substring(file.getParent().lastIndexOf("\\") + 1, file.getParent().length());
			if(    true == fileName.equals(Sample.class.getSimpleName    ())
				|| true == fileName.equals(SampleForm.class.getSimpleName())){
	    		continue;
	    	}
			
			BufferedReader reader   = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath())));  
			FileWriter     writer   = new FileWriter(createFile + "/" + parentDir + "/" + file.getName().replaceAll(sampleClassName, createClassName));
			
			StringBuffer result = new StringBuffer();
			String       line   = null;  
		    while ((line = reader.readLine()) != null) {
		    	
		    	line = line.replaceAll(sampleDateName,     createDateName    ); 
		    	line = line.replaceAll(sampleAuthorName,   createAuthorName  ); 
		    	line = line.replaceAll(sampleAppName,      createAppName     ); 
		    	line = line.replaceAll(samplePackage,      createpackage     ); 
		    	line = line.replaceAll(sampleClassName,    createClassName   ); 
		    	line = line.replaceAll(sampleUrl,          createUrl         ); 
		    	line = line.replaceAll(sampleInstanceName, createInstanceName); 
		   
		    	result.append(String.format("%s\n", line));
		    }  
			   
			reader.close();
			//System.out.println(result.toString());
			writer.write(result.toString());
			writer.flush();
			writer.close();
		}
		
		
		
		// ENTITY 생성
		BufferedReader entityReader = new BufferedReader(new InputStreamReader(new FileInputStream(coderSampleEntityPath)));  
		FileWriter     entityWriter = new FileWriter(createFile + "/domain/" + createClassName + ".java");
		StringBuffer   entityResult = new StringBuffer();
		String         entityLine   = null;  
	    while ((entityLine = entityReader.readLine()) != null) {
	    	
	    	entityLine = entityLine.replaceAll(sampleDateName,     createDateName    ); 
	    	entityLine = entityLine.replaceAll(sampleAuthorName,   createAuthorName  ); 
	    	entityLine = entityLine.replaceAll(sampleAppName,      createAppName     ); 
	    	entityLine = entityLine.replaceAll(samplePackage,      createpackage     ); 
	    	entityLine = entityLine.replaceAll(coderSamplePackage, createpackage     ); 
	    	entityLine = entityLine.replaceAll(sampleClassName,    createClassName   ); 
	    	entityLine = entityLine.replaceAll(sampleUrl,          createUrl         ); 
	    	entityLine = entityLine.replaceAll(sampleInstanceName, createInstanceName); 
	    	
	    	if( -1 < entityLine.indexOf("@Entity") ){
	    		entityLine = "@Entity";
	    	}
	    	
	    	if( -1 < entityLine.indexOf("@Table") ){
	    		entityLine = String.format("@Table(name=\"%s\")", createTableName);
	    	}
	    	
	    	if( -1 < entityLine.indexOf("{ENTITY_LIST}") ){
	    		
	    		StringBuffer     entityList     = new StringBuffer();
	    		List<CoderField> coderFieldList = CoderHelper.selectFieldList(createTableName);
	    		for (CoderField coderField : coderFieldList) {
	    			
	    			String fieldName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, coderField.getColumnName());
	    			
	    			if( true == "PRI".equals(coderField.getColumnKey() )){
	    				entityList.append("\t@Id\n");
	    				entityList.append("\t@GeneratedValue\n");
	    			}
	    			
	    			if( true == "varchar".equals(coderField.getDataType()) ){
	    				entityList.append(String.format("\tprivate String  %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "char".equals(coderField.getDataType()) ){
	    				entityList.append(String.format("\t\tprivate String  %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "bigint".equals(coderField.getDataType()) ){
	    				entityList.append(String.format("\tprivate Long    %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "tinyint".equals(coderField.getDataType()) ){
	    				entityList.append(String.format("\tprivate Short   %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "smallint".equals(coderField.getDataType()) ){
	    				entityList.append(String.format("\tprivate Short   %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "int".equals(coderField.getDataType()) ){
	    				entityList.append(String.format("\tprivate Integer %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "datetime".equals(coderField.getDataType()) ){
	    				entityList.append("\t@Temporal(TemporalType.TIMESTAMP)\n");
	    				entityList.append(String.format("\tprivate Date    %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    		}
	    		
	    		entityLine = entityList.toString();
	    	}
	    	
	    	entityResult.append(String.format("%s\n", entityLine));
	    }  
		   
		entityReader.close();
		//System.out.println(entityResult.toString());
		entityWriter.write(entityResult.toString());
		entityWriter.flush();
		entityWriter.close();
		
		
		
		// FORM 생성
		BufferedReader formReader = new BufferedReader(new InputStreamReader(new FileInputStream(coderSampleFormPath)));  
		FileWriter     formWriter = new FileWriter(createFile + "/domain/" + createClassName + "Form.java");
		StringBuffer   formResult = new StringBuffer();
		String         formLine   = null;  
	    while ((formLine = formReader.readLine()) != null) {
	    	
	    	formLine = formLine.replaceAll(sampleDateName,     createDateName     ); 
	    	formLine = formLine.replaceAll(sampleAuthorName,   createAuthorName   ); 
	    	formLine = formLine.replaceAll(sampleAppName,      createAppName      ); 
	    	formLine = formLine.replaceAll(coderSamplePackage, createpackage      ); 
	    	formLine = formLine.replaceAll(sampleClassName,    createClassName    ); 
	    	formLine = formLine.replaceAll(sampleUrl,          createUrl          ); 
	    	formLine = formLine.replaceAll(sampleInstanceName, createInstanceName ); 
	    	
	    	if( -1 < formLine.indexOf("{FORM_LIST}") ){
	    		
	    		StringBuffer     formList       = new StringBuffer();
	    		List<CoderField> coderFieldList = CoderHelper.selectFieldList(createTableName);
	    		for (CoderField coderField : coderFieldList) {
	    			
	    			String fieldName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, coderField.getColumnName());
	
	    			if(    true  == "NO".equals(coderField.getIsNullable()) 
	    				&& false == "bigint".equals(coderField.getDataType()) 
	    				&& false == "datetime".equals(coderField.getDataType()) ){
	    				formList.append("\t\t@NotNull\n");
	    			}
	    			
	    			if( true == "varchar".equals(coderField.getDataType()) ){
	    				formList.append(String.format("\t\t@Size(max=%s)\n", coderField.getCharacterMaximumLength()));
	    				formList.append(String.format("\t\tprivate String  %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "char".equals(coderField.getDataType()) ){
	    				formList.append(String.format("\t\t@Size(max=%s)\n", coderField.getCharacterMaximumLength()));
	    				formList.append(String.format("\t\tprivate String  %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "bigint".equals(coderField.getDataType()) ){
	    				formList.append(String.format("\t\tprivate Long    %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "tinyint".equals(coderField.getDataType()) ){
	    				formList.append("\t\t@Min(1)\n");
	    				formList.append(String.format("\t\t//@Max(%s)\n", coderField.getCharacterMaximumLength()));
	    				formList.append(String.format("\t\tprivate Short   %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "smallint".equals(coderField.getDataType()) ){
	    				formList.append("\t\t@Min(1)\n");
	    				formList.append(String.format("\t\t//@Max(%s)\n", coderField.getCharacterMaximumLength()));
	    				formList.append(String.format("\t\tprivate Short   %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "int".equals(coderField.getDataType()) ){
	    				formList.append("\t\t@Min(1)\n");
	    				formList.append(String.format("\t\t//@Max(%s)\n", coderField.getCharacterMaximumLength()));
	    				formList.append(String.format("\t\tprivate Integer %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "datetime".equals(coderField.getDataType()) ){
	    				//formList.append(String.format("\t\tprivate Date    %s = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    		}
	    		
	    		formLine = formList.toString();
	    	}
	    	else if( -1 < formLine.indexOf("{RESPONSE_FORM_LIST}") ){
    			
	    		StringBuffer     formList       = new StringBuffer();
	    		List<CoderField> coderFieldList = CoderHelper.selectFieldList(createTableName);
	    		for (CoderField coderField : coderFieldList) {
	    			
	    			String fieldName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, coderField.getColumnName());

	    			if( true == "varchar".equals(coderField.getDataType()) ){
	    				formList.append(String.format("\t\tprivate String  %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "char".equals(coderField.getDataType()) ){
	    				formList.append(String.format("\t\tprivate String  %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "bigint".equals(coderField.getDataType()) ){
	    				formList.append(String.format("\t\tprivate Long    %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "tinyint".equals(coderField.getDataType()) ){
	    				formList.append(String.format("\t\tprivate Short   %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "smallint".equals(coderField.getDataType()) ){
	    				formList.append(String.format("\t\tprivate Short   %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}		
	    			else if( true == "int".equals(coderField.getDataType()) ){
	    				formList.append(String.format("\t\tprivate Integer %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    			else if( true == "datetime".equals(coderField.getDataType()) ){
	    				formList.append(String.format("\t\tprivate Date    %s\t = null; // %s\n", fieldName, coderField.getColumnComment()));
	    			}
	    		}
	    		
	    		formLine = formList.toString();
    		}
	    	
	    	formResult.append(String.format("%s\n", formLine));
	    }  
		   
	    formReader.close();
		//System.out.println(formResult.toString());
	    formWriter.write(formResult.toString());
	    formWriter.flush();
	    formWriter.close();
	}
	
	
	private static File createFile = null;
	
	// 고정 항목
	private final static String samplePath            = "D:/develop/workspace/Cy_BillingAPI/src/main/java/com/cyworld/sample";
	private final static String coderSampleEntityPath = "D:/develop/workspace/Cy_BillingAPI/src/main/java/com/cyworld/common/coder/domain/Sample.java";
	private final static String coderSampleFormPath   = "D:/develop/workspace/Cy_BillingAPI/src/main/java/com/cyworld/common/coder/domain/SampleForm.java";
	private final static String sampleExtension       = "java";
	
	// 고정 항목
	private final static String sampleAppName      = "샘플";
	private final static String samplePackage      = "com.cyworld.sample";
	private final static String sampleClassName    = "Sample";
	private final static String sampleInstanceName = "sample";
	private final static String sampleDateName     = "2017.01.01";
	private final static String sampleAuthorName   = "임정채";
	private final static String sampleUrl          = "/api/samples/rests";
	
	// 고정 항목
	private final static String coderSamplePackage = "com.cyworld.common.coder";
	
	// 수정 항목
	private final static String createAppName      = "구매 테스트";						
	private final static String createpackage      = "com.cyworld.cybill.purchase"; 
	private final static String createClassName    = "Purchase";  
	private final static String createInstanceName = "purchase";  
	private final static String createDateName     = "2017.03.03";
	private final static String createAuthorName   = "임정채";  
	private final static String createUrl          = "/api/purchase";  
	private final static String createTableName    = "tb_purchase";
}





