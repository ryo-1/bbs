package chatt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * コメントの挿入
 * 
 * @author hasumi.tsuchida
 *
 */

@WebServlet("/InsertCommentServlet")
public class InsertCommentServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String commentName = req.getParameter("commentName");
		String content = req.getParameter("comment");
		String strId = req.getParameter("articleId");
		System.out.println(strId);
		int articleId = Integer.parseInt(strId);
		
		Comment comment = new Comment();
		comment.setName(commentName);
		comment.setContent(content);
		comment.setArticleId(articleId);
		
		CommentDao.insert(comment);

		RequestDispatcher rd = req.getRequestDispatcher("/ShowBbsServlet");
		rd.forward(req, resp);

	}
}
