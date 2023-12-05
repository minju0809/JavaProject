package pkg.studyBoard;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudyBoardController
 */
@WebServlet("/StudyBoardController")
public class StudyBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudyBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String sw = request.getParameter("sw");
		
		StudyBoardService service = new StudyBoardServiceImpl();
		
		if(sw.equals("S")) {
			
			List<StudyBoardVO> li = service.StudyBoardSelect(null);
			
			request.setAttribute("li", li);
			System.out.println("controller li: " + li);
			

			RequestDispatcher rd = request.getRequestDispatcher("/studyBoard/studyBoard_list.jsp");
			rd.forward(request, response);
			
		} else if(sw.equals("E")) {
			
			String id = request.getParameter("id");
			StudyBoardVO m = service.StudyBoardDetail(id);
			
			request.setAttribute("m", m);
			
//			String id = request.getParameter("id");
			
			List<StudyCommentBoardVO> commentList = service.StudyCommentBoardSelect(null);
			
			System.out.println("controller commentList: " + commentList);
			request.setAttribute("commentList", commentList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/studyBoard/studyBoard_edit.jsp");
			rd.forward(request, response);
			
		} else if(sw.equals("CommentInsert")) {
		
			
			
		} else if(sw.equals("CommentSelect")) {
			

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

