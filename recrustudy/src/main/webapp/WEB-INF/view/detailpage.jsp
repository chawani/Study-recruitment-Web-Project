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
  <table  border="0"  align="center">
  <tr>
   <td width="150" align="center">
      글번호
   </td>
   <td >
    <input type="text"  value="${post.post_id }"  disabled />
   </td>
  </tr>
  <tr>
   <td width="150" align="center">
      작성자 아이디
   </td>
   <td >
    <input type=text value="${post.member_id }" name="writer"  disabled />
   </td>
  </tr>
  <tr>
   <td width="150" align="center">
      제목 
   </td>
   <td>
    <input type=text value="${post.title }"  name="title"  id="i_title" disabled />
   </td>   
  </tr>
  <tr>
   <td width="150" align="center">
      내용
   </td>
   <td>
    <textarea rows="20" cols="60"  name="content"  id="i_content"  disabled />${post.content }</textarea>
   </td>  
  </tr>
  <tr>
       <td width=20% align=center>
          등록일자
       </td>
       <td>
        <input type=text value="${post.post_date}" disabled />
       </td>   
  </tr>
 </table>
 <button type="button" onClick="location.href='/recrustudy/list'">목록으로</button>
 <br>
<br>
<hr>
<c:forEach items="${comment}" var="reply">
작성자: ${reply.member_id }<br>
${reply.comment_content }&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
${reply.comment_date}
<hr>
</c:forEach>
	<br>
	<br>
	<form method="post" action="/recrustudy/writeComment?document=${post.post_id}">
	댓글 달기:
		<textarea name="comment_content" cols="60" rows="6"></textarea>
		<br> <input type="submit" value="등록">
	</form>
</body>
</html>