package chatt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Article繧呈桃菴懊☆繧汽ao.
 * @author hasumi.tsuchida
 *
 */
public class ArticleDao {
	static String tableName = "articles"; 
	/**
	 * 蜈ｨ莉ｶ讀懃ｴ｢
	 * @return 險倅ｺ区ュ蝣ｱ荳�隕ｧ
	 */
	public static ArrayList<Article> findAll(){
		Connection con = DBManager.createConnection();
		String sql = "select id,name,content from "+tableName+" order by id";
		try{
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Article> articleList = new ArrayList<>();
		
		while(rs.next()){
			Article article = new Article();
			article.setId(rs.getInt("id"));
			article.setName(rs.getString("name"));
			article.setContent(rs.getString("content"));
			articleList.add(article);
		}return articleList;
		
		}catch(SQLException ex){
			System.err.println("SQL ="+sql);
			throw new RuntimeException();
		}finally{
			DBManager.closeConnection(con);
		}
	}
	/**
	 * 諠�蝣ｱ繧定ｿｽ蜉�縺吶ｋ
	 * 
	 * @param article縲�險倅ｺ�
	 */
	public static void insert(Article article){
		Connection con = DBManager.createConnection();
		String sql = "Insert into "+ tableName +"(name, content) values(?,?);";
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1,article.getName());
			pstmt.setString(2,article.getContent());
			
			pstmt.executeUpdate();
		}catch(SQLException ex){
			System.err.println("SQL = "+sql);
			throw new RuntimeException("insert",ex);
		}finally{
			DBManager.closeConnection(con);
		}
	}
	
	/**
	 * 諠�蝣ｱ繧呈ｶ亥悉縺吶ｋ
	 * 
	 * @param id縲�豸亥悉縺吶ｋID
	 */
	public static void deleteById(int id){
		Connection con = DBManager.createConnection();
		String sql = "delete from "+tableName + " where id = ?";
		CommentDao.deleteByArticleId(id);
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}catch(SQLException ex){
			System.err.println("SQL = "+sql);
			throw new RuntimeException("delete蜃ｦ逅�縺ｫ螟ｱ謨励＠縺ｾ縺励◆",ex);
		}finally{
			DBManager.closeConnection(con);
		}
	}
	
	}
