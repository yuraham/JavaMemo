<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
    <jsp:attribute name="head">
        <title>${requestScope.text}</title>
        </jsp:attribute>
    <jsp:body>
    <div class="container">
        <h1>작성</h1>
        <form action="${pageContext.request.contextPath}/memo/register.do" method="post">
        	<table>
        		<tr>
        			<td>작성자</td>
        			<td><input type="text" name="name"/></td>
        		</tr>
        		<tr>
        			<td>비밀번호<br><small>비밀번호는 글 수정시 사용됩니다.</small></td>
        			<td><input type="password" name="pass"/></td>
        		</tr>
        		<tr>
        			<td>내용</td>
        			<td><input type="text" name="content"/></td>
        		</tr>
        		<tr>
        			<td><input type="submit" value="저장" /></td>
        			<td><a href="${pageContext.request.contextPath}/memo/home.do">취소</a></td>
        		</tr>	
        	</table>
        </form>
	</div>
    </jsp:body>
</t:genericpage>
