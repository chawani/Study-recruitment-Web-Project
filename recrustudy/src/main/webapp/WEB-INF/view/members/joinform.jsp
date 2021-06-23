<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="//code.jquery.com/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<div align="center">
<form method="post" action="/recrustudy/members/join">
  <div class="form-group">
  <h1>회원가입</h1>
  <div class="form-floating mb-3">
  	<label for="floatingInput">Email address</label>
    <input type="email" name="email" class="form-control" id="floatingInput" placeholder="name@example.com">
  </div>
  <div class="form-floating mb-3">
  	<label for="floatingInput">닉네임</label>
    <input type="text" name="name" class="form-control" id="floatingnick" placeholder="nickname">
  </div>
  <div class="form-floating">
    <label for="floatingPassword">Password</label>
    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
  </div>
</div>
<input type="submit" class="btn btn-info" value="회원가입">
<button type="button" class="btn btn-success" onClick="parent.location.href='/recrustudy/list'">목록으로</button>
</form></div>
</body>
</html>