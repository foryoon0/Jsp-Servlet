<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
<h3>총 ${fn:length(CourseLectureLists)}개의 교과목이 있습니다.</h3>
<input type="button" value="강사 보기" onclick="location.href='LLS'">

<table>
	<tr>
		<th>과목코드</th>
		<th>과목 명</th>
		<th>학점</th>
		<th>담당 강사</th>
		<th>요일</th>
	</tr>
	<c:forEach var="course" items="${CourseLectureLists}" varStatus="c">
		<tr>
			<td>${course.id}</td>
			<td><a href="RCS?id=${course.id}">${course.name}</a></td>
			<td>${course.credit}</td>
			<td>${course.lecname}</td>
			<td>${course.week}</td>
		</tr>
	</c:forEach>

	
</table>
	<input type="button" value="교과목 등록" onclick="location.href='WCS'">
</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>