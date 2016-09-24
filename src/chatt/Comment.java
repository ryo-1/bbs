package chatt;

/**
 * コメントを表すDTO.
 * @author hasumi.tsuchida
 *
 */
public class Comment {
	/**
	 * コメントid
	 */
	private Integer id;
	/**
	 * 名前
	 */
	private String name;
	/**
	 * コンテント
	 * 
	 */
	private String content;
	/**
	 * 記事id
	 */
	private Integer articleId;
	
	
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
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	
}
