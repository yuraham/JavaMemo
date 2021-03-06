<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
    <jsp:attribute name="head">
        <title>Memo List</title>
        </jsp:attribute>
    <jsp:body>
        <div class="container">
        <h1>홈</h1>
		<table class="table">
			<thead>
				<tr>
					<th colspan="4">${requestScope.text}</th>
				</tr>
			</thead>
			<tbody>
<%-- 			<tr>
				<th>번호</th>
				<th>이름</th>
				<th width="60%">내용</th>   value="${list[num_people-i]}" /
				<th>작성일</th>
			</tr> --%>
 	 		<c:forEach var="i" items="${requestScope.list}" begin="0" end="${requestScope.num}" step="1">
 	 			<%-- <c:set var="j" value="${requestScope.list[num - i]}" scope="page" /> --%>
 	 			<tr>
					<td>${i.idx}</td>
					<td>${i.name}</td>
					<td><a href="${pageContext.request.contextPath}/memo/detail.do?idx=${i.idx}">${i.content}</a></td>
					<td>${i.regdate}</td>
				</tr>
 			</c:forEach>
 			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/memo/register_form.do">새글쓰기</a>
		</div>
    </jsp:body>
</t:genericpage>
