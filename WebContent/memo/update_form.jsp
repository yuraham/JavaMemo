<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
    <jsp:attribute name="head">
        <title>${requestScope.memo.name}</title>
        </jsp:attribute>
    <jsp:body>
    <div class="container">
        <h1>수정</h1>
        <form action="${pageContext.request.contextPath}/memo/update.do?idx=${requestScope.memo.idx}" method="post">
        	<table>
        		<tr>
        			<td>작성자</td>
        			<td>${requestScope.memo.name}</td>
        		</tr>
        		<tr>
        			<td>내용</td>
        			<td><input type="text" name="content"/></td>
        		</tr>
        		<tr>
        			<td><input type="submit" value="저장" /></td>
        			<td><a href="${pageContext.request.contextPath}/memo/detail.do?idx=${requestScope.memo.idx}">취소</a></td>
        		</tr>	
        	</table>
        </form>
	</div>
    </jsp:body>
</t:genericpage>
