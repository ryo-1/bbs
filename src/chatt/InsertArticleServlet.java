package chatt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 記事を追加するServlet
 * 
 * @author hasumi.tsuchida
 *
 */
@WebServlet("/InsertArticleServlet")
public class InsertArticleServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		
		Article article = new Article();
		article.setName(name);
		article.setContent(content);
		
		ArticleDao.insert(article);
		
		RequestDispatcher rd = req.getRequestDispatcher("/ShowBbsServlet");
		rd.forward(req, resp);
		
	
	}
}
