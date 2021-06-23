<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script src="//code.jquery.com/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">${member.name}님의 마이페이지</h1>
<hr>
<div align="center">
  <div class="card-body">
    <h4 class="card-title">${member.name}님의 활동 별점은 </h4>
    <p class="card-text">
    <c:if test="${member.amount ne 0}">
	${member.grade/member.amount}입니다.
	</c:if>
	<c:if test="${member.amount eq 0}">
	아직 없습니다! 스터디에 참여해보세요
	</c:if>
    </p>
  </div>
</div>
<hr>
<h2 align="center">${member.name}님의 개설 스터디 리스트</h2>
<hr>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">글번호</th>
      <th scope="col">작성자 번호</th>
      <th scope="col">제목</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${list}" var="post">
    <tr class="table-light">
      <th scope="row">${post.post_id }</th>
      <td>${post.member_id }</td>
      <td><a href="/recrustudy/detail?document=${post.post_id}">${post.title}</a></td>
    <td>
    <c:choose>
    <c:when test="${empty post.studygroup_id}">
	<button onClick="location.href='/recrustudy/group?document=${post.post_id}'">관리</button>
    </c:when>
    <c:otherwise>
	<button onClick="location.href='/recrustudy/studygroup?document=${post.post_id}'">리뷰</button>
    </c:otherwise>
	</c:choose>
	</td>
    </c:forEach>
    </tr>
  </tbody>
</table>
<br>
<h2 align="center">참여 신청한 스터디 리스트</h2>
<hr>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">글번호</th>
      <th scope="col">작성자 번호</th>
      <th scope="col">제목</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${clist}" var="post2">
    <tr class="table-light">
      <th scope="row">${post2.post_id }</th>
      <td>${post2.member_id }</td>
      <td><a href="/recrustudy/detail?document=${post2.post_id}">${post2.title}</a></td>
    <td>
    <c:if test="${empty post2.studygroup_id}">
	<button>생성 대기중</button>
    </c:if>
    <c:if test="${!empty post2.studygroup_id}">
	<button onClick="location.href='/recrustudy/studygroup?document=${post2.post_id}'">리뷰</button>
    </c:if>
	</td>
    </c:forEach>
    </tr>
  </tbody>
</table>
<button type="button" class="btn btn-success" onClick="parent.location.href='/recrustudy/list'">목록으로</button>
</body>
</html>