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
<h3>강사 등록</h3>

<form action="WLS" method="POST">
<table>
	<tr>
		<th>강사 번호</th>
		<td>${fn:length(LectureLists)+1}</td>
	</tr>
	<tr>
	 	<th>강사 명</th>
	 	<td><input type="text" name="name"></td>
	</tr>
	<tr>
	 	<th>전공</th>
	 	<td><input type="text" name="major"></td>
	</tr>
	<tr>
		<th>세부 전공</th>
		<td><input type="text" name="field"></td>
	</tr>
	

</table>
	<input type="button" value="목록" onclick="location.href='LLS'">
	<input type="submit" value="완료">
</form>




</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>