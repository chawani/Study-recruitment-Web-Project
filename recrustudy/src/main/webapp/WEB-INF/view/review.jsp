<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<th>리뷰 페이지</th>
	<c:forEach var="i" begin="1" end="${period }">
	<tr><td>${i}주차</td></tr>
	<tr>
	<td>
	    <c:forEach items="${rlist}" var="review">
	    <c:if test="${review.week eq i}">
		작성자: ${review.member_id }&nbsp; &nbsp;
		${review.review_content }&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
		</c:if>
		</c:forEach>
		<hr>
	    <form method="post" action="/recrustudy/writeReview?document=${post_id}&week=${i}">
	리뷰 달기:
		<textarea name="review_content" cols="60" rows="6"></textarea>
		<br> <input type="submit" value="등록">
		</form>
	</td>
	</tr>
	</c:forEach> 
	<tr><td>팀원평가</td></tr>
	<tr>
	<td>
	<form action="/recrustudy/reviewStar?document=${post_id}" method="post">
		<c:forEach items="${mlist}" var="member">
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
		</c:forEach>
	<input type="submit" value="등록">
	</form>
	</td>
	</tr>   
    </table>
</body>
</html>