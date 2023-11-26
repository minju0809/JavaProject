package pkg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import pkg.member.*;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String path = request.getContextPath();
		String sw = request.getParameter("sw");

		MemberService service = new MemberServiceImpl();
		
		MemberVO vo = null;

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

		if (sw.equals("S")) {

			List<MemberVO> li = service.select(null);
			request.setAttribute("li", li);

			RequestDispatcher rd = request.getRequestDispatcher("./member/member_list.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("F")) {
			
			int memberCount = service.memberCount();
			request.setAttribute("memberCount", memberCount);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/member_form.jsp");
			dispatcher.forward(request, response);
			
		} else if (sw.equals("I")) {
			
			String realF = getServletContext().getRealPath("/files/");
			int maxS = 1024 * 1024 * 5;
			String encT = "UTF-8";
			
			DefaultFileRenamePolicy DefaultF = new DefaultFileRenamePolicy();

			MultipartRequest multi = new MultipartRequest(request, realF, maxS, encT, DefaultF);
			
			int memberCount = Integer.parseInt(multi.getParameter("memberCount"));
			String id = multi.getParameter("id");
			String password = multi.getParameter("password");
			String age = multi.getParameter("age");
			String phone = multi.getParameter("phone");
			String area = multi.getParameter("area");
			String desired_field = multi.getParameter("desired_field");
			String study_period = multi.getParameter("study_period");
			String photo = multi.getFilesystemName("photo");
			
			if (photo == null) {
				photo = "space.png";
			}
			
			vo = new MemberVO();
			vo.setMemberCount(memberCount);
			vo.setId(id);
			vo.setPassword(password);
			vo.setAge(age);
			vo.setPhone(phone);
			vo.setArea(area);
			vo.setDesired_field(desired_field);
			vo.setStudy_period(study_period);
			vo.setPhoto(photo);
			
			service.insert(vo);
			
			response.sendRedirect(path+"/MemberController?sw=S");
			
		}
 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
