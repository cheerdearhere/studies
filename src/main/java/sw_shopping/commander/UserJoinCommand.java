package sw_shopping.commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sw_shopping.dao.UserDao;
import sw_shopping.dto.UserDto;

public class UserJoinCommand implements InterfaceCommnad {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("UserJoinCommand");
		UserDao udao = new UserDao();
		String custnoSt = request.getParameter("custno");
		int custno = Integer.parseInt(custnoSt);
		String custname= request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		UserDto dto = new UserDto(custno,custname,phone,address,joindate,grade,city);
		udao.userJoin(dto);
	}

}
