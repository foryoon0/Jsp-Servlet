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
		<h3>강사 수정</h3>
		<form action="ULS" method="GET">
			<table>
				<tr>
					<th>강사 번호</th>
					<td><input type="text" name="idx" value="${rVo.idx}" readonly></td>
				</tr>
				<tr>
					<th>강사 명</th>
					<td><input type="text" name="name" value="${rVo.name}"></td>
				</tr>
				<tr>
					<th>전공</th>
					<td><input type="text" name="major" value="${rVo.major}"></td>
				</tr>
				<tr>
					<th>세부 전공</th>
					<td><input type="text" name="field" value="${rVo.field}"></td>
				</tr>
				<tr>
					<th>담당 과목</th>
					<td><c:forEach var="course" items="${ReadCourse}"
							varStatus="r">
							<input type="text" name="cname" value="${course.cname}" readonly>
						</c:forEach></td>
				</tr>


			</table>
			<input type="button" value="목록" onclick="location.href='LL	S'">
			<input type="submit" value="완료">
		</form>




	

	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>