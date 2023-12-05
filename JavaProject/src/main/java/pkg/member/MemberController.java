package pkg.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		MemberVO vo = new MemberVO();

//		String realF = getServletContext().getRealPath("/files/");
//		int maxS = 5 * 1024 * 1024;
//		String encT = "utf-8";

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

			int memberCount = Integer.parseInt(request.getParameter("memberCount"));
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String age = request.getParameter("age");
			String phone = request.getParameter("phone");
			String region = request.getParameter("region");
			String desired_field = request.getParameter("desired_field");
			String study_period = request.getParameter("study_period");

			if (service.isIdDuplicated(id)) {
				// 이미 존재하는 ID라면 사용자에게 알림
				response.setContentType("text/html; charset=UTF-8");
				try (PrintWriter out = response.getWriter()) {
					out.println("<script>alert('이미 있는 아이디입니다.'); window.location.href='" + path
							+ "/MemberController?sw=F';</script>");
				}

			} else {
				vo = new MemberVO();
				vo.setMemberCount(memberCount);
				vo.setId(id);
				vo.setPassword(password);
				vo.setAge(age);
				vo.setPhone(phone);
				vo.setRegion(region);
				vo.setDesired_field(desired_field);
				vo.setStudy_period(study_period);

				service.insert(vo);

				response.sendRedirect(path + "/MemberController?sw=S");
			}

		} else if (sw.equals("E")) {

			String id = request.getParameter("id");
			MemberVO m = service.edit(id);

			request.setAttribute("m", m);

			RequestDispatcher rd = request.getRequestDispatcher("/member/member_edit.jsp");
			rd.forward(request, response);

		} else if (sw.equals("D")) {

			System.out.println("delete check");

			String id = request.getParameter("id");

			service.delete(id);

			response.sendRedirect("MemberController?sw=S");

		} else if (sw.equals("U")) {
			
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String age = request.getParameter("age");
			String phone = request.getParameter("phone");
			String region = request.getParameter("region");
			String desired_field = request.getParameter("desired_field");
			String study_period = request.getParameter("study_period");

			vo.setId(id);
			vo.setPassword(password);
			vo.setAge(age);
			vo.setPhone(phone);
			vo.setRegion(region);
			vo.setDesired_field(desired_field);
			vo.setStudy_period(study_period);

			service.update(vo);

			response.sendRedirect(path + "/MemberController?sw=S");
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
