package chatt;

import java.util.ArrayList;

/**
 * Daoから必要メソッドを呼び出す
 * 
 * @author hasumi.tsuchida
 *
 */
public class ShowArticleLogic {
	/**
	 * 
	 * ArticleDaoのfindAll（）メソッドを呼び出す
	 * @return 記事情報
	 */
	public static ArrayList<Article> execute(){
		return ArticleDao.findAll();
	}
	
	/**
	 * 
	 * CommentDaoのfindByArticleId()メソッドを呼び出す
	 * @param articleId
	 * @return コメントリスト
	 */
	public static ArrayList<Comment> findByArticleId(int articleId){
		return CommentDao.findByArticleId(articleId);
	}
}
