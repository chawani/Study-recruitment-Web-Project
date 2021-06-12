<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<th>Week</th>
	<th>리뷰 모아보기</th>
	<th>나의 리뷰 작성</th>
	<tr><!-- 첫번째 줄 시작 -->
	    <td>1주차</td>
	    <td><a href="review?document=${post.post_id}&week=1">팀원들의 리뷰 확인</a></td>
	    <td><button onClick="write_review?document=${post.post_id}&week=1">작성</button></td>
	</tr><!-- 첫번째 줄 끝 -->
	<tr><!-- 두번째 줄 시작 -->
	    <td>2주차</td>
	    <td><a href="review?document=${post.post_id}&week=2">팀원들의 리뷰 확인</a></td>
	    <td><button onClick="write_review?document=${post.post_id}&week=2">작성</button></td>
	</tr><!-- 두번째 줄 끝 -->
    </table>
</body>
</html>