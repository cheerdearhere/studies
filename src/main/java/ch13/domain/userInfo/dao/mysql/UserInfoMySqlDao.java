package ch13.domain.userInfo.dao.mysql;

import ch13.domain.userInfo.UserInfo;
import ch13.domain.userInfo.dao.UserInfoDao;

public class UserInfoMySqlDao implements UserInfoDao{

	@Override
	public void insertUserInfo(UserInfo userInfo) {
		System.out.println("Insert into MySQL DB: userID = "+userInfo.getUserId());
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		System.out.println("Update into MySQL DB: userID = "+userInfo.getUserId());
	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		System.out.println("Delete from MySQL DB: userID = "+userInfo.getUserId());
	}

}
