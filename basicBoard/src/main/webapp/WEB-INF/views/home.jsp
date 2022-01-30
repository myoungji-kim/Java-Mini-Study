<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>게시판 만들기</title>
<link href="/resources/asset/css/common.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" />
</head>
<body>
	<div class="top_title">
		<span>전체 게시글 수 (${page.totalCount})</span>
	</div>
	<!-- 게시글 보여주는 곳 -->
	<div style="margin: auto;">
		<ul>
			<!-- DB에서 이미 limit 해줬기 때문에 여기서 begin-end 주면 데이터 안나옴-->
			<!-- 전체 레코드 수 - ( (현재 페이지 번호 - 1) * 한 페이지당 보여지는 레코드 수 + 현재 게시물 출력 순서 ) -->
			<c:forEach var="row" items="${select}" varStatus="status">
				<li class="box">
					<div>
						<!-- rownum으로 바꿔도 됨 -->
						<span>NO : ${page.totalCount - ((page.pageNow - 1) * page.contentNum + status.index)}</span>
					</div> 
					<div><span>IDX : ${row.IDX} </span></div>
					<div>
						<span>제목 : ${row.TITLE} </span>
					</div> <div><span>내용 : ${row.TEXTS} </span></div>
					<div style="width: 70px; overflow: hidden;">
						<img style="width: 100%;" src="/resources/upload/${row.FILES}">
					</div> <a href="edit?no=${row.IDX}"><span
						style="color: blue; border-bottom: 1px solid blue;">수정하기</span></a>
				</li>
			</c:forEach>
		</ul>
	</div>

	<div style="margin: auto; text-align: center; margin-bottom: 15px;">
		<!-- prev 버튼 -->
		<c:if test="${page.btnPrev}">
			<a style="color: green;" href="/?no=${page.beginPage-1}"><span
				style="border-bottom: 1px solid green;">이전</span></a>
		</c:if>

		<!-- 페이징 넘버 -->
		<c:forEach var="i" begin="${page.beginPage}" end="${page.endPage}">
			<a style="color: black;" href="/?no=${i}"><span
				style="border-bottom: 1px solid black;">${i}</span></a>
		</c:forEach>

		<!-- next 버튼 -->
		<c:if test="${page.btnNext}">
			<a style="color: green;" href="/?no=${page.endPage+1}"><span
				style="border-bottom: 1px solid green;">다음</span></a>
		</c:if>

	</div>



	<div style="text-align: center; margin-bottom: 20px;">
		<a href="edit"><span
			style="color: red; border-bottom: 1px solid red; text-align: center;">글쓰기</span></a>
	</div>
	
	
	<div>
	<a href="logout" style="color: black; border-bottom: 1px solid black; text-align: center;">로그아웃</a>
	</div>
</body>
</html>