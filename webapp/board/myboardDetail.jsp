<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 상세화면</title>
	<link rel="stylesheet" href="../css/style.css" />
	<script src="../js/jquery-3.7.1.js"></script>
</head>

<script>

	$(function(){
	
		$("#btn_list").click(function(){
			location = "/myboardList";
		});
		$("#btn_modify").click(function(){
			location = "/myboardModify/${dto.seqid}";
		});
		$("#btn_delete").click(function(){
			location = "/passWrite/${dto.seqid}";
		});
		
		$("#btn_submit").click(function(){

			let cmmt = $("#cmmt").val();
			let pass = $("#pass").val();
			let writer = $("#writer").val();
		
			if( cmmt == "" ) {
				alert("(댓글)내용을 입력해주세요.");
				$("#cmmt").focus();
				return false;
			}
			if( pass == "" ) {
				alert("(댓글)암호를 입력해주세요.");
				$("#pass").focus();
				return false;
			}
			if( writer == "" ) {
				alert("(댓글)글쓴이를 입력해주세요.");
				$("#writer").focus();
				return false;
			}
			
			let form = $("#frm2").serialize();
			$.ajax({
				type: "post",
				data: form,
				url : "/reboardInsert",
				dataType: "text",
				success:function(data){ 
					if(data=="ok") {
						alert("저장완료");
						location.reload();
					} else {
						alert("저장실패");
					}
				},
				error:function(){ 
					alert("오류발생");
				}
			});
		});
	});

</script>

<style>
 .table1 td {
 	text-align:left;
 }
 .div_content {
 	width:98%;
 	height:150px;
 	overflow-x:auto;
 	overflow-y:auto;
 }
 .div_comment {
 	width:570px;
 	margin-top:20px;
 	margin-left:20px;
 }
 .textarea2 {
 	width:99%;
 }
 
</style>

<body>
 <div class="div_title">
    댓글 게시판 상세화면
 </div>
 
<form id="frm" >

<table class="table1">
	<colgroup>
		<col width="20%" />
		<col width="*" />
	</colgroup>
	<tr>
		<th><label for="title">제목</label></th>
		<td>${dto.title }</td>
	</tr>
	<tr>
		<th><label for="writer">글쓴이</label></th>
		<td>${dto.writer }</td>
	</tr>
	<tr>
		<th><label for="content">내용</label></th>
		<td>
			<div class="div_content">${dto.content }</div>
		</td>
	</tr>
	<tr>
		<th><label for="rdate">등록일</label></th>
		<td>${fn:substring(dto.rdate,0,10) }</td>
	</tr>
	<tr>
		<th><label for="udate">변경일</label></th>
		<td>${fn:substring(dto.udate,0,10) }</td>
	</tr>
</table>

 <div class="div_button_area">
    <button type="button" id="btn_before" >이전</button>
    <button type="button" id="btn_next" >다음</button>
 	 &nbsp;
    <button type="button" id="btn_list" >목록</button>
    <button type="button" id="btn_modify">수정</button>
    <button type="button" id="btn_delete">삭제</button>
 </div>
 
</form>
	<div class="div_comment">
		<div>
		 	<img src="/images/icon/star1.PNG" width="25" height="25">
			<img src="/images/icon/star1.PNG" width="25" height="25">
			<img src="/images/icon/star1.PNG" width="25" height="25">
			<img src="/images/icon/star2.PNG" width="25" height="25">
			<img src="/images/icon/star3.PNG" width="25" height="25">
		</div>
	
		<form id="frm2">
		
		<input type="hidden" name="pseqid" value="${dto.seqid}">
		
		<div>
			<textarea id="cmmt" name="cmmt" class="textarea2"></textarea>
		</div>
		<div>		
			<input  type="password" id="pass"   name="pass"   class="input2"
					placeholder="암호를 입력하세요." >
			<input  type="text" 	id="writer" name="writer" class="input2"
					placeholder="글쓴이를 입력하세요.">
			
			<c:set var="j" value="6" />
			<select name="star">
				<c:forEach var="i" begin="1" end="5">
				<option value="${j-i }">${j-i }점</option>
				</c:forEach>
			</select>
			<button type="button" 	id="btn_submit">등록</button>
		</div>
		</form>
	</div>

	<div style="margin-top:10px;margin-left:20px;">
		<table class="table2" style="width:580px;">
			<colgroup>
				<col width="7%" />
				<col width="*" />
			</colgroup>
			
			
			<c:forEach var="result" items="${list}">
			<tr>
				<td style="text-align:center;"></td>
				<td style="padding:5px;">
					<div>
						${result.CMMT }
					</div>
					<div style="text-align:right;padding-top:3px;">
						
						 <img src="/images/icon/star1.PNG" width="15" height="15">
						 <img src="/images/icon/star1.PNG" width="15" height="15">
						 <img src="/images/icon/star1.PNG" width="15" height="15">
						 <img src="/images/icon/star1.PNG" width="15" height="15">
						 <img src="/images/icon/star3.PNG" width="15" height="15">
						
						 ${result.WRITER } ${result.RDATE }   [수정/삭제] 
					</div>
				</td>
			</tr>
			</c:forEach>
			
		</table>

	</div>

</body>
</html>