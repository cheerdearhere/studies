package sw_shopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sw_shopping.dto.UserDto;

public class UserDao {	
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	private ResultSet resultSet=null;
	
    public static Connection getConnection() throws Exception{
          Class.forName("oracle.jdbc.OracleDriver");
          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
          return con;
    }
	public UserDao() {
	}
	public int custnoCheck() {
		int result = 0;
		try {
			connection = getConnection();
			String sql = "SELECT MAX(custno) + 1 custno FROM member_tbl_02 ";
			preparedStatement = connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				result = resultSet.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}
	//join
	public void userJoin(UserDto dto) {
		System.out.println("user join() method");
		try {
			connection=getConnection();
			String query = "INSERT INTO member_tbl_02 VALUES(?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, dto.getCustno());
			preparedStatement.setString(2, dto.getCustname());
			preparedStatement.setString(3, dto.getPhone());
			preparedStatement.setString(4, dto.getAddress());
			preparedStatement.setString(5, dto.getJoindate());
			preparedStatement.setString(6, dto.getGrade());
			preparedStatement.setString(7, dto.getCity());
			int result = preparedStatement.executeUpdate();
			System.out.println("result: " + result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				if(connection!=null) {
					connection.close();
				}	
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	public ArrayList<UserDto> userList(){
		ArrayList<UserDto> dtos = new ArrayList<UserDto>();
		try {
			connection=getConnection();
			String query = "SELECT * FROM member_tbl_02";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int custno = resultSet.getInt("custno");
				String custname= resultSet.getString("custname");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");
				String joindate = resultSet.getString("joindate");
				String gradeDB = resultSet.getString("grade");
				String grade="";
				if(gradeDB.equals("A"))grade="VIP";
				else if(gradeDB.equals("B"))grade="일반";
				else if(gradeDB.equals("C"))grade="직원";
				else {
					grade="비등록 회원";
				}
				
				String city = resultSet.getString("city");
				UserDto dto = new UserDto(custno, custname, phone, address, joindate, grade, city); 
				dtos.add(dto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return dtos;
	}
	public UserDto userDetails(int custno) {
		UserDto dto = null;
		try {
			connection = getConnection();
			String query = "SELECT * FROM member_tbl_02 WHERE custno=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, custno);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				if(custno==resultSet.getInt(1)) {
					String custname = resultSet.getString(2);
					String phone = resultSet.getString(3);
					String address = resultSet.getString(4);
					String joindate = resultSet.getString(5);
					String grade= resultSet.getString(6);
					String city = resultSet.getString(7);
					dto = new UserDto(custno,custname,phone,address,joindate,grade,city);
				}
				else {
					System.out.println("user data is null");
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
			}
			catch(Exception e1){
				e1.getMessage();
			}
		}
		return dto;
	}
}
