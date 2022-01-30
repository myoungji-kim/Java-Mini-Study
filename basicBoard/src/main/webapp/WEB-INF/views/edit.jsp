<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<link href="/resources/asset/css/common.css" rel="stylesheet"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" />
	<script type = "text/javascript" src="/resources/asset/script/jquery-3.6.0.js"></script>
</head>
<body>
<ul>
<form action="/edit.action" name="edit_form" method="post" enctype="multipart/form-data">
	<c:choose>
		<c:when test="${not empty selectOne}">
			<c:set var="mode" value="수정"/>
			<c:set var="idx" value="${selectOne.IDX}"/>
			<c:set var="title" value="${selectOne.TITLE}"/>
			<c:set var="text" value="${selectOne.TEXTS}"/>
			<c:set var="file1" value="${selectOne.FILES}"/>
		</c:when>
		<c:when test="${empty selectOne}">
			<c:set var="mode" value="등록"/>
			<c:set var="idx" value=""/>
			<c:set var="title" value=""/>
			<c:set var="text" value=""/>
			<c:set var="file1" value=""/>
		</c:when>
	</c:choose>
<%-- 	// 세션은 바로 써도 됨
	${sessionTest } --%>
	<li class="box" style="padding: 10px;">
		<input type="hidden" name="mode" id="mode" value="">
		<input type="hidden" name="no" value="${idx}">
		
		<div><span style="font-size: 20px; font-weight:700;"> ${mode} 페이지</span></div>	
		
		<div><input type = "file" name = "file1" id = "file1"></div>
		<div><img style="width: 150px; height: 100px;" src="/resources/upload/${file1}"></div>
		<div><input type="text" name="title" value="${title}" autocomplete="off"></div>
		<div><input type="text" name="text" value="${text}" autocomplete="off"></div>
		
		<div style="margin-top: 20px;">
			<!-- 등록페이지 -->
			<c:if test="${empty idx}">
			<a onclick="insert_form()" style="border: 0.5px solid green; color: green; padding: 2px; cursor: pointer;">등록</a>
			</c:if>
			
			<!-- 수정페이지 옵션 -->
			<c:if test="${not empty idx}">
			<a onclick="update_form()" style="border: 0.5px solid blue; color: blue; padding: 2px; cursor: pointer;">저장</a>
			<a onclick="delete_form()" style="border: 0.5px solid red; color: red; padding: 2px; cursor: pointer;">삭제</a>
			</c:if>
		</div>
	
	</li>
	
	<script type = "text/javascript">
		function insert_form(){
			$('#mode').attr('value', "insert");
			/* document.getElementById("mode").setAttribute('value',"insert"); */
			if ($('[name=title]').val() == "") {
				alert("제목을 입력해주세요.");
			} else {
				document.forms["edit_form"].submit();
			}
		}
	
		function update_form(){
			document.getElementById("mode").setAttribute('value',"update");
			document.forms["edit_form"].submit();
		}
		
		function delete_form(){
			document.getElementById("mode").setAttribute('value',"delete");
			document.forms["edit_form"].submit();
		}
	</script>
</form>
</ul>

</body>
</html>