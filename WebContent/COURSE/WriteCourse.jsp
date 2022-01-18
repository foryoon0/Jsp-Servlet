<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
<h3>교과목 등록</h3>
<form action ="WCS" method="POST">
<table>
	<tr>
		<th>교과목 코드</th>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<th>과목 명	</th>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
        <th>담당 강사</th>
        <td>
		<select name="lecture" id="lecture">
        <c:forEach var="list" items="${LectureLists}" varStatus="l">
            <option value="${list.idx}">${list.name}</option>
         </c:forEach>
        </select>

        </td>
    </tr>
    <tr>
    <th>학점</th>
    <td><input type="text" name="credit">
   	</tr>
   	<tr>
   		<th>요일</th>
   		<td>
   		
   		<input type="radio" name="week" value="1">월
   		<input type="radio" name="week" value="2">화
   		<input type="radio" name="week" value="3">수
   		<input type="radio" name="week" value="4">목
   		<input type="radio" name="week" value="5">금
   		<input type="radio" name="week" value="6">토
	
   		</td>
   	</tr>
   	<tr>
   		<th>시작</th>
   		<td><input type="text" name="start_hour"></td>
   	</tr>
   	<tr>
   		<th>종료</th>
   		<td><input type="text" name="end_hour"></td>
	</tr>
	

</table>
	<input type="button" value="목록" onclick="location.href='CLS'">
	<input type="submit" value="완료">
	</form>

</section>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>