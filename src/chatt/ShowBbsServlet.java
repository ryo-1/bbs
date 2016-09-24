package chatt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * チャット画面の呼び出しをする
 * 
 * @author hasumi.tsuchida
 *
 */
@WebServlet("/ShowBbsServlet")
public class ShowBbsServlet extends HttpServlet {
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

		ArrayList<Article> articleList = ShowArticleLogic.execute();
		for (Article article : articleList) {

			ArrayList<Comment> commentList = ShowArticleLogic.findByArticleId(article.getId());
			article.setCommentList(commentList);
			System.out.println(commentList);
		}

		HttpSession session = req.getSession();
		session.setAttribute("articleList", articleList);

		RequestDispatcher rd = req.getRequestDispatcher("/bbs.jsp");
		rd.forward(req, resp);

	}
}
