<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../css/style.css"></link>
	<title>회원목록화면</title>	
</head>

<script>

</script>

<body>
<div>
	<div> Totla : "${total}"</div>
	<table class="table1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>연락처</th>
		</tr>
		
		<c:forEach var="result" items="${resultList}">
		<colgroup>
			<col width="15%">
			<col width="20%">
			<col width="20%">
			<col width="20%">
			<col width="25%">
		</colgroup>
		<tr>
			<td><c:out value="${pageRownum}"/></td>
			<td><a href="/mbrDetail/${result.USERID}">${result.USERID}</a></td>
			<td>${result.NAME}</td>
			<td>${result.GENDER}</td>
			<td>${result.PHONE}</td>
		</tr>
		
		<c:set var="pageRownum" value="${pageRownum-1 }"></c:set> 
		
		</c:forEach>

	</table>
	
	<div class="div_button_area" style="text-align:right;">
		<button type="button" onClick="location='/mbrWrite'">등록</button>
	</div>
</div>


</body>
</html>