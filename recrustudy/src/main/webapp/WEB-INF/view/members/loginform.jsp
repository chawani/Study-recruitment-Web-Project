<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
  <html>
<script src="//code.jquery.com/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <head>
      <title>로그인 </title>
    </head>
  <body>
  <div align="center">
  <form method="post" action="/recrustudy/authenticate">
  <div class="form-group">
  <h1 class="form-label mt-4">로그인</h1>
  <div class="form-floating mb-3">
  	<label for="floatingInput">Email address</label>
    <input type="email" name="userId" class="form-control" id="floatingInput" placeholder="name@example.com">
  </div>
  <div class="form-floating">
    <label for="floatingPassword">Password</label>
    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
  </div>
</div>
<input type="submit" class="btn btn-info" value="로그인">
<button type="button" class="btn btn-success" onClick="parent.location.href='/recrustudy/list'">목록으로</button>
</div>
  </body>
</html>