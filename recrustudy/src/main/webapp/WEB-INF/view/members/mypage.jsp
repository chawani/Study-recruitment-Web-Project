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
${member.name}님의 마이페이지 입니다.<br>
<a href='<c:url value='/members/'/>' role="button">회원정보수정</a>&nbsp;
<a href='<c:url value='/members/'/>' role="button">회원탈퇴</a>
<br><br>
${member.name}님의 활동 별점은 
<c:if test="${member.amount ne 0}">
${member.grade/member.amount}입니다.
</c:if>
<c:if test="${member.amount eq 0}">
아직 없습니다! 스터디에 참여해보세요
</c:if>
<hr>
${member.name}님의 <br>
개설 스터디 리스트
<hr>
<c:forEach items="${list}" var="post">
${post.post_id }&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
${post.member_id }&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
<a href="http://localhost:8082/recrustudy/detail?document=${post.post_id}">${post.title}</a>
&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
<c:choose>
    <c:when test="${empty post.studygroup_id}">
<button onClick="location.href='/recrustudy/group?document=${post.post_id}'">관리</button>
    </c:when>
    <c:otherwise>
<button onClick="location.href='/recrustudy/studygroup?document=${post.post_id}'">리뷰</button>
    </c:otherwise>
</c:choose>
<hr>
</c:forEach>
<br>
참여 신청한 스터디 리스트
<hr>
<c:forEach items="${clist}" var="post2">
${post2.post_id }&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
${post2.member_id }&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
<a href="http://localhost:8082/recrustudy/detail?document=${post2.post_id}">${post2.title}</a>
<hr>
</c:forEach>
</body>
</html>