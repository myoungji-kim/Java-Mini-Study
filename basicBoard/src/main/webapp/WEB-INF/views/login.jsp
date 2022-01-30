<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="false"%> 이거는 session 안 쓴다는 뜻--%>
<html>
<head>
	<title>로그인</title>
	<link href="/resources/asset/css/common.css" rel="stylesheet" />
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" />
	<script type="text/javascript" src="/resources/asset/script/jquery-3.6.0.js"></script>
</head>
<body>
<form action = "/login.action" name="login_form" method="post">
	<input type="text" name="id">
	<input type="text" name="pw">
	<div style="margin-top: 10px;">
		<a onclick="setLogin()" style="color:black; cursor:pointer;">로그인하기</a>
	</div>
	
	<script type="text/javascript">
		function setLogin(){
			if ($('[name=id]').val() == "a" && $('[name=pw]').val() == "b"){
				document.forms["login_form"].submit();
			} else {
				alert("아이디 및 비밀번호를 확인해주세요");
			}
		}
	</script>
</form>
	
</body>
</html>