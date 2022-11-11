package sw_shopping.commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface InterfaceCommnad {
	public void excute(HttpServletRequest request, HttpServletResponse response); 
}
