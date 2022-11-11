package sw_shopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sw_shopping.commander.CustNoCommand;
import sw_shopping.commander.EarnListCommand;
import sw_shopping.commander.InterfaceCommnad;
import sw_shopping.commander.UserDetailsCommand;
import sw_shopping.commander.UserJoinCommand;
import sw_shopping.commander.UserListCommand;

/**
 * Servlet implementation class shoppingContoller
 */
@WebServlet("*.do")
public class ShoppingContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InterfaceCommnad com;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post");
		request.setCharacterEncoding("UTF-8");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("action do method");
		
		String uri =request.getRequestURI();
		String contextPath= request.getContextPath();
		String command = uri.substring(contextPath.length());
		
		String viewPage="";
		if(command.equals("/")) {
			System.out.println("/ default request");
			viewPage="home.jsp";
		}
		else if(command.equals("/home.do")) {
			System.out.println("home.do request");
			viewPage="home.jsp";
		}
		else if(command.equals("/userList.do")) {
			System.out.println("userList.do request");
			com = new UserListCommand();
			com.excute(request, response);
			viewPage="userList.jsp";
		}
		else if(command.equals("/joinFrm.do")) {
			System.out.println("joinFrm.do request");
			com = new CustNoCommand();
			com.excute(request, response);
			viewPage="joinFrm.jsp";
		}
		else if(command.equals("/join.do")) {
			System.out.println("join.do request");
			com = new UserJoinCommand();
			com.excute(request, response);
			viewPage="home.jsp";
		}
		else if(command.equals("/userList.do")) {
			System.out.println("userList.do request");
			com = new UserListCommand();
			com.excute(request, response);
			viewPage="userList.jsp";
		}
		else if(command.equals("/moneyList.do")) {
			System.out.println("moneyList.do request");
			com = new EarnListCommand();
			com.excute(request, response);
			viewPage="moneyList.jsp";
		}
		else if(command.equals("/userModifyFrm.do")) {
			System.out.println("userModifyFrm.do request");
			com = new UserDetailsCommand();
			com.excute(request, response);
			viewPage="userModifyFrm.jsp";
		}
		else {
			viewPage="home.jsp";
		}
		
		if(viewPage==null||viewPage=="") {
			System.out.println("viewPage is empty");
		}
		else {
			System.out.println("working RequestDispatcher: "+ viewPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}
