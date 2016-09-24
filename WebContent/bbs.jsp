<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/chat/InsertArticleServlet" method="post">
		投稿者名：<input type="text" name="name" /><br> 投稿内容：
		<textarea name="content" rows="4" cols="20"></textarea>
		<br> <input type="submit" value="記事投稿" />
	</form>
	<c:forEach var="article" items="${articleList}">
投稿者ID：<c:out value="${article.id}" />
		<br>
		<br>
投稿者名：<c:out value="${article.name}" />
		<br>
		<br>
投稿内容：<c:out value="${article.content}" />
		<br>
		<br>
		<form action="/chat/DeleteArticleServlet" method="post">
			<input type="hidden" name="id" value="${article.id}"> <input
				type="submit" value="記事削除"><br> <br>
		</form>
		<c:forEach var="comment" items="${article.commentList}">
			<form action="/chat/ShowBbsServlet" method="post">
				コメントID:
				<c:out value="${comment.id}" /><br>
				コメント者名：
				<c:out value="${comment.name}" /><br>
				コメント内容：
				<c:out value="${cooment.content}" /><br>
			</form>
		</c:forEach>
		<form action="/chat/InsertCommentServlet" method="post">
			名前：<input type="text" name="commentName"><br> コメント：
			<textarea name="comment" rows="2" cols="20"></textarea>
			<input type="hidden" name="articleId" value="<c:out value="${article.id}"/>" />
			<br> <input type="submit" value="コメント投稿" /><br>
		</form>
	</c:forEach>
</body>
</html>