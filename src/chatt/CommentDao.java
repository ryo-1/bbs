package chatt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * commentを操作するDao.
 * 
 * @author hasumi.tsuchida
 *
 */
public class CommentDao {
	static String tableName = "comments";

	/**
	 * ArticleIdで全件検索
	 * @param articleId
	 * @return コメント情報一覧
	 */
	public static ArrayList<Comment> findByArticleId(int articleId) {
		Connection con = DBManager.createConnection();
		String sql = "select id,name,content,article_id from " + tableName + " where article_id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleId);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Comment> commentList = new ArrayList<>();

			while (rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getInt("id"));
				comment.setName(rs.getString("name"));
				comment.setContent(rs.getString("content"));
				comment.setArticleId(rs.getInt("article_id"));
				commentList.add(comment);
			}
			return commentList;
		} catch (SQLException ex) {
			System.err.println("SQL = " + sql);
			throw new RuntimeException("findByArticleId処理に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con);
		}
	}

	/**　
	 * コメントの追加
	 * 
	 * @param comment　コメント
	 */
	public static void insert(Comment comment) {
		Connection con = DBManager.createConnection();
		String sql = "insert into " + tableName
				+ " (name,content,article_id) values(?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, comment.getName());
			pstmt.setString(2, comment.getContent());
			pstmt.setInt(3, comment.getArticleId());
			pstmt.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println("SQL =" + sql);
			throw new RuntimeException();
		} finally {
			DBManager.closeConnection(con);
		}
	}
	
	/**
	 * ArticleIdで削除する処理
	 * 
	 * @param articleId　記事id
	 */
	public static void deleteByArticleId(int articleId){
		Connection con = DBManager.createConnection();
		String sql = "delete from "+tableName+" where article_id = ?";
		try{
			PreparedStatement  pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleId);
			pstmt.executeUpdate();
		}catch(SQLException ex){
			System.err.println("SQL = "+sql);
			throw new RuntimeException("delete処理に失敗しました",ex);
		}finally{
			DBManager.closeConnection(con);
		}
	}
	
	
}
