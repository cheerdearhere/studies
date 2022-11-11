package sw_shopping.commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sw_shopping.dao.UserDao;
import sw_shopping.dto.UserDto;

public class UserDetailsCommand implements InterfaceCommnad {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		UserDao udao = new UserDao();
		int custno = Integer.parseInt(request.getParameter("custno"));
		UserDto dto = udao.userDetails(custno);
		request.setAttribute("userDto", dto);
	}

}
