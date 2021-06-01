<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
참여 목록
<hr>
<c:forEach items="${list}" var="list">
${list.member_id }&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
<button onClick="location.href='/recrustudy/delete_accept?comment=${list.comment_id}&document=${list.post_id}'">취소하기</button>
<br>
</c:forEach>
<br>
<button onClick="location.href='/recrustudy/start?document=${list[0].post_id}'">스터디 시작하기</button>
</body>
</html>