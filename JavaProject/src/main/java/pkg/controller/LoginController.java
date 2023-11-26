package pkg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.login.*;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String path = request.getContextPath();
		String sw = request.getParameter("sw");
		
		HttpSession session = request.getSession();
		
		LoginService service = new LoginServiceImpl();
		
		if(sw.equals("login")) {
			response.sendRedirect(path + "/login/login.jsp");
		} else if (sw.equals("loginOK")) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			LoginVO vo = new LoginVO();
			vo.setId(id);
			vo.setPassword(password);
			
			String grade = service.login(vo);
			
			if(grade.equals("F")) {
				session.setAttribute("id", null);
				response.sendRedirect(path+"/login/login.jsp");
			} else {
				session.setAttribute("id", id);
				session.setAttribute("grade", grade);
				response.sendRedirect(path+"/index.jsp");
			}
		} else if (sw.equals("logout")) {
			session.invalidate();
			response.sendRedirect(path+"/index.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
