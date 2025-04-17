<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 등록화면</title>
	<link rel="stylesheet" href="../css/style.css" />
	<!-- https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css -->
	<link rel="stylesheet" href="../css/jquery-ui.css">
  	<link rel="stylesheet" href="https://jqueryui.com/resources/demos/style.css">
  	<script src="../js/jquery-3.7.1.js"></script>
  	<script src="../js/jquery-ui.js"></script>
  	<script>
 	$( function() {
   		$("#rdate").datepicker();
   		$("#btn_submit").click( function(){
   			if( $("#title").val() == "" ) {
				alert("제목을 입력하세요.");
				$("#title").focus();
				return false;
   			}
   			if( $("#pass").val() == "" ) {
				alert("암호를 입력하세요.");
				$("#pass").focus();
				return false;
   			}
   		});
  	});
  	</script>
</head>

<script>

</script>

<body>
 <div class="div_title">
    게시판 등록화면
 </div>
 
<form name="frm" method="post" action="/boardInsert">

<table class="table1">
	<colgroup>
		<col width="20%" />
		<col width="*" />
	</colgroup>
	<tr>
		<th><label for="title">제목</label></th>
		<td><input type="text" id="title" name="title" class="input1" placeholder="제목입력" autofocus></td>
	</tr>
	<tr>
		<th><label for="pass">암호</label></th>
		<td><input type="password" id="pass" name="pass" class="input1" placeholder="암호입력"></td>
	</tr>
	<tr>
		<th><label for="writer">글쓴이</label></th>
		<td><input type="text" id="writer" name="writer" class="input1"></td>
	</tr>
	
	<tr>
		<th><label for="rdate">날짜</label></th>
		<td><input type="text" id="rdate" name="rdate" class="input1"></td>
	</tr>
	
	<tr>
		<th><label for="content">내용</label></th>
		<td><textarea id="content" name="content" class="textarea1"></textarea></td>
	</tr>
</table>

 <div class="div_button_area">
    <button type="submit" id="btn_submit">저장</button>
    <button type="reset">취소</button>
    <button type="button" id="btn_list">목록</button>
 </div>
 
</form>

</body>
</html>