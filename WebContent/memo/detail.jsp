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
        <h1>디테일</h1>
        <p>${requestScope.text}</p>
		<p>${requestScope.memo.idx}번 글</p>
		<p>작성자 :${requestScope.memo.name}</p>
		<p>작성일 :${requestScope.memo.regdate}</p>
		<p>내용 : ${requestScope.memo.content}</p> 
	</div>
	<a href="${pageContext.request.contextPath}/memo/update_form.do?idx=${requestScope.memo.idx}">수정하기</a>
	<a href="${pageContext.request.contextPath}/memo/delete.do?idx=${requestScope.memo.idx}">삭제하기</a>
	<a href="${pageContext.request.contextPath}/memo/home.do">돌아가기</a>
    </jsp:body>
</t:genericpage>
