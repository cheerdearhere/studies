package ch13.domain.userInfo.web.userInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import ch13.domain.userInfo.UserInfo;
import ch13.domain.userInfo.dao.UserInfoDao;
import ch13.domain.userInfo.dao.mysql.UserInfoMySqlDao;
import ch13.domain.userInfo.dao.oracle.UserInfoOracleDao;

public class UserInfoClient {

	public static void main(String[] args) throws IOException {
		
		//인터페이스를 참고하여 parameter와 return을 본다. 
		FileInputStream fis = new FileInputStream("db.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		String dbType = prop.getProperty("DBTYPE");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("12345");
		
		UserInfoDao udao = null;
		
		if(dbType.equals("ORACLE")) {
			udao = new UserInfoOracleDao();
		}
		else if(dbType.equals("MYSQL")) {
			udao = new UserInfoMySqlDao();
		}
		else {
			System.out.println("DB error");
			return;
		}
		udao.insertUserInfo(userInfo);
		udao.updateUserInfo(userInfo);
		udao.deleteUserInfo(userInfo);
	}
}
