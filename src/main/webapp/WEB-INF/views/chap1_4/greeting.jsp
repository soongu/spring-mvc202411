<!-- greeting.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Greeting</title>
</head>
<body>
<h1>안녕하세요, ${userName}님!</h1>
<form action="/greeting" method="get">
  <label for="name">이름을 입력하세요:</label>
  <input type="text" id="name" name="name">
  <button type="submit">확인</button>
</form>
</body>
</html>
