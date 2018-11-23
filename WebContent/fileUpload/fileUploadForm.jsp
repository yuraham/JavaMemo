<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>제목없음</title>
</head>
<body>
<h3>파일 업로드 양식</h3>
<form action="fileUpload.jsp" method="post" enctype="Multipart/form-data">
<table>
	<tr>
		<td>파일명1 : </td>
		<td><input type="file" name="fileName1"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="전송"/></td>
	</tr>
</table>
</form>
</body>
</html>