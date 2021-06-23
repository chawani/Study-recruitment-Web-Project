<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
  <table  border="0"  align="center">
  <tr>
   <td width="150" align="center">글번호</td>
   <td >${post.post_id }</td>
  </tr>
  <tr>
   <td width="150" align="center">작성자 아이디</td>
   <td >${post.member_id }</td>
  </tr>
  <tr>
   <td width="150" align="center">지역</td>
   <td >${post.region }</td>
  </tr>
  <tr>
   <td width="150" align="center">카테고리</td>
   <td >${post.category }</td>
  </tr>
  <tr>
   <td width="150" align="center">스터디 기간</td>
   <td >${post.study_period }주</td>
  </tr>
  <tr>
   <td width="150" align="center">예상 인원</td>
   <td >${post.total_number }명</td>
  </tr>
  <tr>
   <td width="150" align="center">제목</td>
   <td>${post.title }</td>   
  </tr>
  <tr>
   <td width="150" align="center">내용</td>
   <td><textarea rows="20" cols="60"  name="content"  id="i_content"  disabled />${post.content }</textarea></td>  
  </tr>
  <tr>
  <td width=20% align=center>등록일자</td>
  <td><input type=text value="${post.post_date}" disabled /></td>   
  </tr>
 </table>
<button type="button" class="btn btn-success" onClick="parent.location.href='/recrustudy/list'">목록으로</button>
 <br>
<br>
<hr>
<div align="center">
<c:forEach items="${comment}" var="reply">
작성자: ${reply.member_id }&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
${reply.comment_content }&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
${reply.comment_date}&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
<c:if test="${writer eq true && reply.check_join eq false}">
<button onClick="location.href='/recrustudy/accept?comment=${reply.comment_id}&document=${post.post_id}'">수락하기</button>
</c:if>
<c:if test="${writer eq true && reply.check_join eq true}">
<button onClick="location.href='/recrustudy/delete_accept?comment=${reply.comment_id}&document=${post.post_id}'">취소하기</button>
</c:if>
<hr>
</c:forEach>
</div>
	<br>
	<br>
<div align="center">
	<c:if test="${writer eq false}">
	<form method="post" action="/recrustudy/writeComment?document=${post.post_id}">
	댓글 달기:
		<textarea name="comment_content" cols="60" rows="6"></textarea>
		<input type="submit" value="등록">
	</form>
	</c:if>
</div>
</body>
</html>