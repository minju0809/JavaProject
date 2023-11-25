package pkg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.member.MemberService;
import pkg.member.MemberServiceImpl;
import pkg.member.MemberVO;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("컨트롤러 확인");
		
		MemberService service = new MemberServiceImpl();
		
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		String age = request.getParameter("age");
//		String phone = request.getParameter("phone");
//		String area = request.getParameter("area");
//		String desired_field = request.getParameter("desired_field");
//		String study_period = request.getParameter("study_period");
//		String photo = request.getParameter("photo");
//		String grade = request.getParameter("grade");
//		String join_date = request.getParameter("join_date");
//		
//		
//		MemberVO memberVO = new MemberVO();
//		memberVO.setId(id);
//		memberVO.setPassword(password);
//		memberVO.setAge(age);
//		memberVO.setPhone(phone);
//		memberVO.setArea(area);
//		memberVO.setDesired_field(desired_field);
//		memberVO.setStudy_period(study_period);
//		memberVO.setPhoto(photo);
//		memberVO.setGrade(grade);
//		memberVO.setJoin_date(join_date);
		
		List<MemberVO> li = service.select(null);
		request.setAttribute("li", li);
		
		RequestDispatcher rd = request.getRequestDispatcher("./member/member_list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
