<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<label>글번호</label>&nbsp; &nbsp; &nbsp; &nbsp;
<label>작성자 번호</label>&nbsp; &nbsp; &nbsp; &nbsp;
<label>제목</label>
<hr>
<c:forEach items="${list}" var="post">
${post.post_id }&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
${post.member_id }&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
<a href="detail?document=${post.post_id}">${post.title}</a>
<hr>
</c:forEach>
<a href='<c:url value='/write'/>' role="button">글쓰기</a>
<sec:authorize access="isAnonymous()"> 
<a href='<c:url value='/members/loginform'/>' role="button">로그인</a>
</sec:authorize> 
<sec:authorize access="isAuthenticated()">
<a href='<c:url value='/logout'/>' role="button">로그아웃</a>
</sec:authorize>
<a href='<c:url value='/members/joinform'/>' role="button">회원가입</a>
<sec:authorize access="isAuthenticated()"> 
<a href='<c:url value='/members/mypage'/>' role="button">마이페이지</a>
</sec:authorize>
<br>
</body>
</html>