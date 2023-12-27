package pkg.basicBoard;

import java.io.IOException;
import java.util.List;

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

			response.sendRedirect(path + "/BasicBoardController?sw=S");

		} else if (sw.equals("S")) {  
			
			List<BasicBoardVO> li = service.getBoardList();
			
			request.setAttribute("li", li);
			
			RequestDispatcher rd = request.getRequestDispatcher("/basicBoard/basicBoard_list.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("D")) {
		
			int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));

			service.delete(boardNumber);

			response.sendRedirect(path + "/BasicBoardController?sw=S");

		} else if (sw.equals("Detail")) {  
			
			int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
			
			BasicBoardVO vo = service.getBoard(boardNumber);
			
			request.setAttribute("vo", vo);
			
			RequestDispatcher rd = request.getRequestDispatcher("/basicBoard/basicBoard_detail.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("U")) {
			
			int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			BasicBoardVO boardVO = new BasicBoardVO();

			boardVO.setBoardNumber(boardNumber);
			boardVO.setTitle(title);
			boardVO.setContent(content);

			service.update(boardVO);

			response.sendRedirect(path + "/BasicBoardController?sw=S");
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
