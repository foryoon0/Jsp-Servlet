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
<h3>총 ${fn:length(LectureLists)}명의 강사가 있습니다.</h3>
<input type="button" value="교과목 보기" onclick="location.href='CLS'">


<table>
	<tr>
		<th>번호</th>
		<th>강사명</th>
		<th>전공</th>

	</tr>
	<c:forEach var="lecture" items="${LectureLists}" varStatus="l">
		<tr>
			<td>${lecture.idx}</td>
			<td><a href="RLS?idx=${lecture.idx}">${lecture.name}</a></td>
			<td>${lecture.major}</td>

		</tr>
	</c:forEach>

	
</table>



<input type="button" value="강사 등록" onclick="location.href='WLS'">
</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>