<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${list}" var="post">
${post.post_id }<br>
${post.member_id }<br>
${post.title }<br>
</c:forEach>
<a href='<c:url value='/write'/>' role="button" class="btn btn-outline-info">글쓰기</a>
<br>
</body>
</html>