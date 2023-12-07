package pkg.basicBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BasicBoardController
 */
@WebServlet("/BasicBoardController")
public class BasicBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BasicBoardController() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String sw = request.getParameter("sw");
		String path = request.getContextPath();

		BasicBoardService service = new BasicBoardServiceImpl();

		if (sw.equals("I")) {

			String id = request.getParameter("id");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			BasicBoardVO boardVO = new BasicBoardVO();

			boardVO.setId(id);
			boardVO.setTitle(title);
			boardVO.setContent(content);

			service.insert(boardVO);

			response.sendRedirect(path + "/basicBoard/basicBoard_list.jsp");

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
