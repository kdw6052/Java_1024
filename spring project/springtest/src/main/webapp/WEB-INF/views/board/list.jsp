<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
	<h1>게시글</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>추천/비추천</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="bo">
				<tr>
					<td>${bo.bo_num }
					<td>
						<a href="<c:url value='/board/detail/${bo.bo_num }'></c:url>">
							${bo.bo_title }
						</a>
					</td>
					<td>${bo.bo_me_id }
					<td>${bo.bo_register_date }
					<td>${bo.bo_up }/${bo.bo_down }
					<td>${bo.bo_views }
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
	<ul class="pagination pagination-justedfy-center">
		<li class="page-item <c:if test="${!pm.prev }"> disabled</c:if>">
			<a href="<c:url value='/board/list?page=${pm.startPage-1}'></c:url>" class="page-link">이전</a>
		</li>
		<c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
			<li class="page-item <c:if test="${i==pm.cri.page }"> active</c:if>">
				<a href="<c:url value='/board/list?page=${i}'></c:url>" class="page-link">${i}</a>
			</li>
		</c:forEach>
		
		<li class="page-item <c:if test="${!pm.next }"> disabled</c:if>">
			<a href="<c:url value='/board/list?page=${pm.endPage+1}'></c:url>" class="page-link">다음</a>
		</li>
	</ul>
	
</div>
