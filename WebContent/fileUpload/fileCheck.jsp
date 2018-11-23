<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String fileName1 = request.getParameter("fileName1");
	String fileName2 = request.getParameter("fileName2");
	String originalName1 = request.getParameter("originalName1");
	String originalName2 = request.getParameter("originalName2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>제목없음</title>
</head>
<body>
파일1 : <a href="fileDown.jsp?file_name=<%=fileName1%>"><%=originalName1 %></a><br />
파일2 : <a href="fileDown.jsp?file_name=<%=fileName2%>"><%=originalName2 %></a><br />
</body>
</html>