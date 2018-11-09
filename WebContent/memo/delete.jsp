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
	<h1>정말 삭제하시겠습니까?</h1>
	<p>${requestScope.memo.name}</p>
	<p>${requestScope.memo.content}</p>
	<p>${requestScope.memo.regdate}</p>
	<a href="${pageContext.request.contextPath}/memo/delete_end.do?idx=${requestScope.memo.idx}">네</a>
	<a href="${pageContext.request.contextPath}/memo/detail.do?idx=${requestScope.memo.idx}">아니오</a>
    </jsp:body>
</t:genericpage>
