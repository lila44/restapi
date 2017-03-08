package com.jeongchae.common.coder.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.google.common.collect.Lists;
import com.jeongchae.common.coder.domain.CoderField;
import com.jeongchae.common.coder.domain.CoderTable;

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
public class CoderHelper {
	
	public static List<CoderField> selectFieldList(String tableName) {
		
		StringBuffer query = new StringBuffer();  
		query.append(" SELECT   T1.TABLE_NAME                                                            ");  // 테이블명        
		query.append("         ,T1.TABLE_COMMENT                                                         ");  // 테이블 설명      
		query.append("         ,ORDINAL_POSITION                                                         ");  // 필드순번        
		query.append("         ,COLUMN_NAME                                                              ");  // 컬럼명         
		query.append("         ,DATA_TYPE                                                                ");  // DATA TYPE   
		query.append("         ,CHARACTER_MAXIMUM_LENGTH                                                 ");  // DATA LENG   
		query.append("         ,COLUMN_KEY                                                               ");  // KEY         
		query.append("         ,EXTRA                                                                    ");  // 자동여부        
		query.append("         ,IS_NULLABLE                                                              ");  // NULL값 여부    
		query.append("         ,COLUMN_DEFAULT                                                           ");  // 디폴트값        
		query.append("         ,COLUMN_COMMENT                                                           ");  // 컬럼 설명       
		query.append("   FROM ( SELECT TABLE_NAME, TABLE_COMMENT                                         ");
		query.append("             FROM INFORMATION_SCHEMA.TABLES                                        ");
		query.append("            WHERE TABLE_SCHEMA = ?                                                 ");
		query.append("   ) T1,                                                                           ");
		query.append("         ( SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE, CHARACTER_MAXIMUM_LENGTH,    ");
		query.append("                  COLUMN_KEY, EXTRA, IS_NULLABLE, COLUMN_DEFAULT, COLUMN_COMMENT,  ");
		query.append("                  ORDINAL_POSITION                                                 ");
		query.append("             FROM INFORMATION_SCHEMA.COLUMNS                                       ");
		query.append("            WHERE TABLE_SCHEMA = ?                                                 ");
		query.append("   ) T2                                                                            ");
		query.append("  WHERE T1.TABLE_NAME = T2.TABLE_NAME                                              ");
		query.append("    AND T1.TABLE_NAME = ?                                                          ");
		query.append("  ORDER BY T1.TABLE_NAME ASC, ORDINAL_POSITION ASC                                 ");
		
		Connection        connection     = null;
		PreparedStatement statement      = null;
		ResultSet         resultSet      = null;
		List<CoderField>  coderFieldList = Lists.newArrayList();
		
		try {
			
			Class.forName(dbDriver);
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			statement  = connection.prepareStatement(query.toString());
			
			statement.setString(1, dbName   );
			statement.setString(2, dbName   );
			statement.setString(3, tableName);
			
			resultSet  = statement.executeQuery();
		    while( true == resultSet.next() ) {
		    	
		    	CoderField coderField = new CoderField();
		    	coderField.setTableName             (resultSet.getString("TABLE_NAME"              ));
		    	coderField.setTableComment          (resultSet.getString("TABLE_COMMENT"           ));
		    	coderField.setOrdinalPosition       (resultSet.getInt   ("ORDINAL_POSITION"        ));
		    	coderField.setColumnName            (resultSet.getString("COLUMN_NAME"             ));
		    	coderField.setDataType              (resultSet.getString("DATA_TYPE"               ));
		    	coderField.setCharacterMaximumLength(resultSet.getInt   ("CHARACTER_MAXIMUM_LENGTH"));
		    	coderField.setColumnKey             (resultSet.getString("COLUMN_KEY"              ));
		    	coderField.setExtra                 (resultSet.getString("EXTRA"                   ));
		    	coderField.setIsNullable            (resultSet.getString("IS_NULLABLE"             ));
		    	coderField.setColumnDefault         (resultSet.getString("COLUMN_DEFAULT"          ));
		    	coderField.setColumnComment         (resultSet.getString("COLUMN_COMMENT"          ));
		    	
		    	coderFieldList.add(coderField);
		    }
		}
		catch(Exception e){ e.printStackTrace(); }
		finally {
			try{ if( null != resultSet  ){ resultSet.close (); } } catch(Exception e1){ e1.printStackTrace(); }
			try{ if( null != statement  ){ statement.close (); } } catch(Exception e1){ e1.printStackTrace(); }
			try{ if( null != connection ){ connection.close(); } } catch(Exception e1){ e1.printStackTrace(); }
		}
		
		return coderFieldList;
	}
	
	public static List<CoderTable> selectTableList() {
		
		StringBuffer query = new StringBuffer();  
		query.append(" SELECT   T1.TABLE_NAME                    "); // 테이블명   
		query.append("         ,T1.TABLE_COMMENT                 "); // 테이블 설명
		query.append("   FROM ( SELECT TABLE_NAME, TABLE_COMMENT ");  
		query.append("            FROM INFORMATION_SCHEMA.TABLES "); 
		query.append("           WHERE TABLE_SCHEMA = ?          ");  
		query.append("   ) T1                                    ");  
		query.append("  ORDER BY T1.TABLE_NAME ASC               ");     
		
		Connection        connection     = null;
		PreparedStatement statement      = null;
		ResultSet         resultSet      = null;
		List<CoderTable>  coderTableList = Lists.newArrayList();
		
		try {
			
			Class.forName(dbDriver);
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			statement  = connection.prepareStatement(query.toString());
			
			statement.setString(1, dbName);
			resultSet  = statement.executeQuery();
			
		    while( true == resultSet.next() ) {
		    	
		    	CoderTable coderTable = new CoderTable();
		    	coderTable.setTableName   (resultSet.getString("TABLE_NAME"   ));
		    	coderTable.setTableComment(resultSet.getString("TABLE_COMMENT"));
		    	
		    	coderTableList.add(coderTable);
		    }
		}
		catch(Exception e){ e.printStackTrace(); }
		finally {
			try{ if( null != resultSet  ){ resultSet.close (); } } catch(Exception e1){ e1.printStackTrace(); }
			try{ if( null != statement  ){ statement.close (); } } catch(Exception e1){ e1.printStackTrace(); }
			try{ if( null != connection ){ connection.close(); } } catch(Exception e1){ e1.printStackTrace(); }
		}
		
		return coderTableList;
	}
	
	private final static String dbDriver           = "com.mysql.jdbc.Driver";
	private final static String dbUrl              = "jdbc:log4jdbc:mysql://10.42.0.239:3306/cybill?characterEncoding=utf8";
	private final static String dbUser             = "cydev";
	private final static String dbPassword         = "Tkdleoqkr42$@";
	private final static String dbName             = "cybill";
}






