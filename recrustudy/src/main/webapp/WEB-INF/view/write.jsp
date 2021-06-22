<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/recrustudy/postInsert" method="post">
<select name="category">
    <option value="">스터디 카테고리 선택</option>
    <option value="어학">어학</option>
    <option value="고시">고시</option>
    <option value="취미">취미</option>
    <option value="취업">취업</option>
    <option value="프로그래밍">프로그래밍</option>
    <option value="자율">자율</option>
</select>
<br>
<select name="region">
    <option value="">지역 선택</option>
    <option value="서울">서울</option>
    <option value="경기">경기</option>
    <option value="인천">인천</option>
    <option value="강원">강원</option>
    <option value="대전">대전</option>
    <option value="세종">세종</option>
    <option value="충남">충남</option>
    <option value="충북">충북</option>
    <option value="부산">부산</option>
    <option value="울산">울산</option>
    <option value="경남">경남</option>
    <option value="경북">경북</option>
    <option value="대구">대구</option>
    <option value="광주">광주</option>
    <option value="전남">전남</option>
    <option value="전북">전북</option>
    <option value="제주">제주</option>
</select>
<br>
<label>모집인원</label>
<input type="text" name="total_number" placeholder="모집인원을 설정해주세요.">
<br>
<label>스터디 기간</label>
<input type="text" name="study_period" placeholder="스터디 기간을 입력해주세요.">주
<br>
<label>제목</label>
<input type="text" name="title" placeholder="제목을 작성해주세요.">
<br>
<label>내용</label>
<textarea name="content" rows="10"></textarea>
<br>
<button type="submit">등록하기</button>
<button type="button" onClick="location.href='/recrustudy/list'">목록으로</button>
</form>
</body>
</html>