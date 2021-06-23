<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <style>
      p { margin:20px 0px; }
    </style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<table border="1">
  				<thead>
    				<tr>
      				<th scope="col"><center>리뷰 페이지</center></th>
    				</tr>
  				</thead>
  				<tbody>
  					<c:forEach var="i" begin="1" end="${period }">
	<tr><td><center>${i}주차</center></td></tr>
	<tr>
	<td>
	    <c:forEach items="${rlist}" var="review">
	    <c:if test="${review.week eq i}">
		작성자: ${review.member_id }&nbsp; &nbsp;
		${review.review_content }&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
		</c:if>
		<br>
		</c:forEach>
		<hr>
	    <form method="post" action="/recrustudy/writeReview?document=${post_id}&week=${i}">
	리뷰 달기:
		<textarea name="review_content" cols="60" rows="6"></textarea>
		<input type="submit" value="등록">
		</form>
	</td>
	</tr>
	</c:forEach> 
	
	<tr><td>팀원평가</td></tr>
	<tr>
	<td>
	<form action="/recrustudy/reviewStar?document=${post_id}" method="post">
		<c:forEach items="${mlist}" var="member">
		<c:if test="${member.id ne me}">
		팀원: ${member.name}&nbsp; &nbsp; 점수:
		<select name="${member.id}">
    		<option value="">별점</option>
    		<option value="1">1점</option>
    		<option value="2">2점</option>
    		<option value="3">3점</option>
    		<option value="4">4점</option>
    		<option value="4">5점</option>
		</select>
		<br>
		</c:if>
		</c:forEach>
	<input type="submit" value="등록">
	</form>
	</td>
	</tr>   
	</tbody>
	</table>
	<button type="button" class="btn btn-success" onClick="parent.location.href='/recrustudy/list'">목록으로</button>
	</div>
</body>
</html>