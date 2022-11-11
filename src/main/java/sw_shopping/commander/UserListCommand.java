package sw_shopping.commander;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sw_shopping.dao.UserDao;
import sw_shopping.dto.UserDto;

public class UserListCommand implements InterfaceCommnad {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		UserDao udao = new UserDao();
		ArrayList<UserDto> dtos = (ArrayList)udao.userList();
		request.setAttribute("userList", dtos);
	}

}
