<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <title>로그인 오류</title>
  </head>
  <body>
  <div align="center">
    <h1>로그인 오류가 발생했습니다. <br>id나 암호를 다시 입력해주세요.</h1>
    <button type="button" class="btn btn-info" onclick="location.href='/recrustudy/members/loginform'">다시 로그인 하기</button>
  </div>
  </body>
</html>