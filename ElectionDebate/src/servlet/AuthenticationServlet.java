package servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import usertype.UserType;
import entity.User;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		Enumeration<String> str = request.getParameterNames();
		
		while(str.hasMoreElements()) {
			System.out.println(str.nextElement());
		}
		
		
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");

		User user = validateUser(login, pwd);

		if (user != null) {
			System.out.println("[Login] Login: " + user.getLogin());
			System.out.println("[Password] Password: " + user.getPwd());
			System.out.println("[Type] Type: " + user.getType());
			
			HttpSession session = request.getSession(true);
			session.setAttribute("login", login);
			
			response.sendRedirect("home.html");
		} else {
			System.out.println("[ERROR] Usuario ou senha incorreto .");
			response.sendRedirect("index.html");
		}
	}

	private HashMap<String, User> listUser() {
		HashMap<String, User> list = new HashMap<String, User>();

		User userOne = new User("admin", "admin", UserType.ADMIN);
		User userTwo = new User("teste", "teste", UserType.JOURNALIST);
		User userThree = new User("elector1", "elector1", UserType.ELECTOR);
		User userFour = new User("elector2", "elector2", UserType.ADMIN);

		list.put(userOne.getLogin(), userOne);
		list.put(userTwo.getLogin(), userTwo);
		list.put(userThree.getLogin(), userThree);
		list.put(userFour.getLogin(), userFour);

		return list;
	}

	private User validateUser(String login, String pwd) {

		HashMap<String, User> list = listUser();

		User user = list.get(login);
		if (user != null) {
			return user.getPwd().equals(pwd) ? user : null;
		} else {
			return null;
		}
	}

}
