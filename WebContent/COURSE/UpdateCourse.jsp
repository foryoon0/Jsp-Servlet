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
	<h3>교과목수정하기</h3>

		<form action="UCS" method="POST">
			<table>
				<tr>
					<th>교과목 코드</th>
					<td><input type="text" name="id" value="${cVo.id}"></td>
				</tr>
				<tr>
					<th>과목 명</th>
					<td><input type="text" name="name" value="${cVo.name}"></td>
				</tr>
				<tr>
					<th>담당 강사</th>
					<td>
					<select name="lecturer">
						<option value="1" <c:if test="${1 == cVo.lecturer}">selected</c:if>>김교수</option>
						<option value="2" <c:if test="${2 == cVo.lecturer}">selected</c:if>>이교수</option>
						<option value="3" <c:if test="${3 == cVo.lecturer}">selected</c:if>>박교수</option>
						<option value="4" <c:if test="${4 == cVo.lecturer}">selected</c:if>>오교수</option>
						<option value="5" <c:if test="${5 == cVo.lecturer}">selected</c:if>>최교수</option>
						<option value="6" <c:if test="${6 == cVo.lecturer}">selected</c:if>>강교수</option>
						<option value="7" <c:if test="${7 == cVo.lecturer}">selected</c:if>>황교수</option>
					</select>
							
					</td> 
				</tr>
				<tr>

					<th>학점</th>
					<td><input type="text" name="credit" value="${cVo.credit}"></td>
				</tr>
				<tr>

					<th>요일</th>
					<td>
						<input type="radio" name="week" value="1" <c:if test="${1 == cVo.week}">checked</c:if>>월
						<input type="radio" name="week" value="2" <c:if test="${2 == cVo.week}">checked</c:if>>화
						<input type="radio" name="week" value="3" <c:if test="${3 == cVo.week}">checked</c:if>>수
						<input type="radio" name="week" value="4" <c:if test="${4 == cVo.week}">checked</c:if>>목
						<input type="radio" name="week" value="5" <c:if test="${5 == cVo.week}">checked</c:if>>금
						<input type="radio" name="week" value="6" <c:if test="${6 == cVo.week}">checked</c:if>>토

					
					
					
					</td>
				</tr>
				<tr>

					<th>시작</th>
					<td><input type="text" name="start_hour" value="${cVo.start_hour}"></td>
				</tr>
				<tr>

					<th>종료</th>
					<td><input type="text" name="end_hour" value="${cVo.end_hour}"></td>
				</tr>



			</table>

			
			<input type="button" value="목록" onclick="location.href='CLS'">
			<input type="reset" value="취소">
			<input type="submit" value="완료">

		</form>

	




</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>