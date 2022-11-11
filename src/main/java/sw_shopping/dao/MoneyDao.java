package sw_shopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sw_shopping.dto.MoneyDto;

public class MoneyDao {
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	private ResultSet resultSet=null;
	
    public static Connection getConnection() throws Exception{
          Class.forName("oracle.jdbc.OracleDriver");
          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
          return con;
    }
    public MoneyDao() {
    }
    
    public ArrayList<MoneyDto> moneyList(){
    	ArrayList<MoneyDto> dtos = new ArrayList<MoneyDto>();
    	try {
    		connection = getConnection();
    		String query = "SELECT A.CUSTNO, A.CUSTNAME, A.GRADE, SUM(B.PRICE) AS TOTAL "
    				+ "FROM MEMBER_TBL_02 A JOIN MONEY_TBL_02 B "
    				+ "ON A.CUSTNO = B.CUSTNO "
    				+ "GROUP BY(A.CUSTNO, A.CUSTNAME, A.GRADE) "
    				+ "ORDER BY TOTAL DESC";
    		preparedStatement=connection.prepareStatement(query);
    		resultSet = preparedStatement.executeQuery();
    		while(resultSet.next()) {
    			int custno = resultSet.getInt(1);
    			String custname = resultSet.getString(2);
    			String grade = resultSet.getString(3);
    			if(grade.equals("A")) grade="VIP";
    			else if(grade.equals("B")) grade="일반";
    			else if(grade.equals("C")) grade="직원";
    			int money = resultSet.getInt(4);
    			MoneyDto dto = new MoneyDto(custno,custname,grade,money);
    			dtos.add(dto);
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		try {
    			if(resultSet!=null)resultSet.close();
    			if(preparedStatement!=null)preparedStatement.close();
    			if(connection!=null)connection.close();
    		}
    		catch(Exception e1) {
    			e1.getMessage();
    		}
    	}
    	return dtos;
    }
}
