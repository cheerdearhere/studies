package sw_shopping.commander;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sw_shopping.dao.MoneyDao;
import sw_shopping.dto.MoneyDto;

public class EarnListCommand implements InterfaceCommnad {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		MoneyDao mdao = new MoneyDao();
		ArrayList<MoneyDto> dtos = mdao.moneyList();
		request.setAttribute("moneyList", dtos);
	}
}
