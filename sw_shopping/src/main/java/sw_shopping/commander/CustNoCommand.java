package sw_shopping.commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sw_shopping.dao.UserDao;

public class CustNoCommand implements InterfaceCommnad {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		UserDao udao = new UserDao();
		int custno = udao.custnoCheck();
		request.setAttribute("custno", custno+1);
	}

}
