<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script src="/resources/js/bootstrap.js"></script>
<head>
</head>
<body>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">글번호</th>
      <th scope="col">작성자 번호</th>
      <th scope="col">제목</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${list}" var="post">
    <tr class="table-light">
      <th scope="row">${post.post_id }</th>
      <td>${post.member_id }</td>
      <td><a href="detail?document=${post.post_id}">${post.title}</a></td>
    </c:forEach>
    </tr>
  </tbody>
</table>

<a href='<c:url value='/write'/>' role="button">글쓰기</a>

<sec:authorize access="isAnonymous()"> 
<button type="button" class="btn btn-info" onclick="location.href='recurstudy/members/loginform'">로그인</button>
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