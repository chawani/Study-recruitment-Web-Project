<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
팀원 목록
<table border="1">
	<th>id</th>
	<th>별점 입력</th>
	<tr><!-- 첫번째 줄 시작 -->
	    <td>팀원1</td>
	    <td><input type='radio' name='star' value='one' />1점
  <input type='radio' name='star' value='two' />2점
  <input type='radio' name='star' value='three' />3점
  <input type='radio' name='star' value='four' />4점
  <input type='radio' name='star' value='five' />5점
	</td></tr><!-- 첫번째 줄 끝 -->
	<tr><!-- 두번째 줄 시작 -->
	    <td>팀원2</td>
	    <td><td><input type='radio' name='star' value='one' />1점
  <input type='radio' name='star' value='two' />2점
  <input type='radio' name='star' value='three' />3점
  <input type='radio' name='star' value='four' />4점
  <input type='radio' name='star' value='five' />5점
	</td></td>
	</tr><!-- 두번째 줄 끝 -->
    </table>
</body>
</html>