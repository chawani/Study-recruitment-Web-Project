<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <style>
      p { margin:20px 0px; }
    </style>
</head>
<body>
<sec:authorize access="isAnonymous()"> 
<button type="button" class="btn btn-info" onclick="location.href='/recrustudy/members/loginform'">로그인</button>
</sec:authorize> 
<sec:authorize access="isAuthenticated()">
<button type="button" class="btn btn-info" onclick="location.href='/recrustudy/logout'">로그아웃</button>
</sec:authorize>
<button type="button" class="btn btn-outline-info" onclick="location.href='/recrustudy/members/joinform'">회원가입</button>
<sec:authorize access="isAuthenticated()"> 
<button type="button" class="btn btn-success" onclick="location.href='/recrustudy/members/mypage'">마이페이지</button>
</sec:authorize>
<hr>
<div class="container">
      <div class="row">
        <div class="col">
            <ul class="nav nav-tabs">
              <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#total">전체</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#lang">어학</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#test">고시</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#hobby">취미</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#job">취업</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#pro">프로그래밍</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#free">자율</a>
              </li>
            </ul>
            <div class="tab-content">
              <div class="tab-pane fade show active" id="total">
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
    				</tr></c:forEach>
  				</tbody>
				</table>
              </div>
              <div class="tab-pane fade" id="lang">
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
  					<c:if test="${post.category eq '어학'}">
    				<tr class="table-light">
      				<th scope="row">${post.post_id }</th>
      				<td>${post.member_id }</td>
      				<td><a href="detail?document=${post.post_id}">${post.title}</a></td>
      				</c:if>
    				</tr></c:forEach>
  				</tbody>
				</table>
              </div>
              <div class="tab-pane fade" id="test">
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
  					<c:if test="${post.category eq '고시'}">
    				<tr class="table-light">
      				<th scope="row">${post.post_id }</th>
      				<td>${post.member_id }</td>
      				<td><a href="detail?document=${post.post_id}">${post.title}</a></td>
      				</c:if>
    				</tr></c:forEach>
  				</tbody>
				</table>
              </div>
              <div class="tab-pane fade" id="hobby">
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
  					<c:if test="${post.category eq '취미'}">
    				<tr class="table-light">
      				<th scope="row">${post.post_id }</th>
      				<td>${post.member_id }</td>
      				<td><a href="detail?document=${post.post_id}">${post.title}</a></td>
      				</c:if>
    				</tr></c:forEach>
  				</tbody>
				</table>
              </div>
              <div class="tab-pane fade" id="job">
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
  					<c:if test="${post.category eq '취업'}">
    				<tr class="table-light">
      				<th scope="row">${post.post_id }</th>
      				<td>${post.member_id }</td>
      				<td><a href="detail?document=${post.post_id}">${post.title}</a></td>
      				</c:if>
    				</tr></c:forEach>
  				</tbody>
				</table>
              </div>
              <div class="tab-pane fade" id="pro">
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
  					<c:if test="${post.category eq '프로그래밍'}">
    				<tr class="table-light">
      				<th scope="row">${post.post_id }</th>
      				<td>${post.member_id }</td>
      				<td><a href="detail?document=${post.post_id}">${post.title}</a></td>
      				</tr></c:if>
    				</c:forEach>
  				</tbody>
				</table>
              </div>
              <div class="tab-pane fade" id="free">
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
  					<c:if test="${post.category eq '자율'}">
    				<tr class="table-light">
      				<th scope="row">${post.post_id }</th>
      				<td>${post.member_id }</td>
      				<td><a href="detail?document=${post.post_id}">${post.title}</a></td>
      				</tr>
      				</c:if>
    				</c:forEach>
  				</tbody>
				</table>
              </div>
            </div>
        </div>
      </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<button type="button" class="btn btn-outline-info" onclick="location.href='/recrustudy/write'">글쓰기</button>
<br>
</body>
</html>