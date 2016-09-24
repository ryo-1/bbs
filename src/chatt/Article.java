package chatt;

import java.util.ArrayList;

/**
 * 記事を表現するDTO.
 * 
 * @author hasumi.tsuchida
 *
 */
public class Article {
	/**
	 * 投稿id
	 */
	private Integer id;
	/**
	 * 名前
	 */
	private String name;
	/**
	 *　コンテント
	 */
	private String content;
	/**
	 * コメントリスト
	 */
	private ArrayList<Comment> commentList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ArrayList<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(ArrayList<Comment> commentList) {
		this.commentList = commentList;
	}
	
}
