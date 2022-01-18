<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./CSS/ListCSS.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<section>
		<h3>교과목 상세보기</h3>

		<form action="" method="POST">
			<table>
				<tr>
					<th>교과목 코드</th>
					<td>${cVo.id}</td>
				</tr>
				<tr>
					<th>과목 명</th>
					<td>${cVo.name}</td>
				</tr>
				<tr>
					<th>담당 강사</th>
					<td>
							<c:set var="lec" value="${cVo.lecturer}"/>
								<c:if test="${lec==1}">김교수</c:if>
								<c:if test="${lec==2}">이교수</c:if>
								<c:if test="${lec==3}">박교수</c:if>
								<c:if test="${lec==4}">오교수</c:if>
								<c:if test="${lec==5}">최교수</c:if>
								<c:if test="${lec==6}">강교수</c:if>
								<c:if test="${lec==7}">황교수</c:if>

						</td> 
				</tr>
				<tr>

					<th>학점</th>
					<td>${cVo.credit}</td>
				</tr>
				<tr>

					<th>요일</th>
					<td><c:set var="week" value="${cVo.week}"/>
								<c:if test="${week==1}">월요일</c:if>
								<c:if test="${week==2}">화요일</c:if>
								<c:if test="${week==3}">수요일</c:if>
								<c:if test="${week==4}">목요일</c:if>
								<c:if test="${week==5}">금요일</c:if>
								<c:if test="${week==6}">토요일</c:if></td>
				</tr>
				<tr>

					<th>시작</th>
					<td>${cVo.start_hour}</td>
				</tr>
				<tr>

					<th>종료</th>
					<td>${cVo.end_hour}</td>
				</tr>



			</table>

			<input type="button" value="수정" onclick="location.href ='UCS?id=${cVo.id}'">
			<input type="button" value="삭제" onclick="deleteCourse('${cVo.id}')">
			<input type="button" value="목록" onclick="location.href='CLS'">

		</form>
		
		<script>
		function deleteCourse(id){
			alert("삭제하시겠습니까?");
			location.href="DCS?id="+id;
		}
		

		</script>



	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>