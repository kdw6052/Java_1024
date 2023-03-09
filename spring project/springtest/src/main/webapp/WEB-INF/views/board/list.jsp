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
					<td>${bo.bo_register_date_str }
					<td>${bo.bo_up }/${bo.bo_down }
					<td>${bo.bo_views }
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="pagination justedfy-content-center">
		<li class="page-item <c:if test="${!pm.prev }"> disabled</c:if>">
			<a href="<c:url value='/board/list?page=${pm.startPage-1}&search=${pm.cri.search }&type=${pm.cri.type }'></c:url>" class="page-link">이전</a>
		</li>
		<c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
			<li class="page-item <c:if test="${i==pm.cri.page }"> active</c:if>">
				<a href="<c:url value='/board/list?page=${i}&search=${pm.cri.search }&type=${pm.cri.type }'></c:url>" class="page-link">${i}</a>
			</li>
		</c:forEach>
		
		<li class="page-item <c:if test="${!pm.next }"> disabled</c:if>">
			<a href="<c:url value='/board/list?page=${pm.endPage+1}&search=${pm.cri.search }&type=${pm.cri.type }'></c:url>" class="page-link">다음</a>
		</li>
	</ul>
	<form class="input-group mb-3" action="<c:url value='/board/list'></c:url>">
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<select class="form-control" name="type">
					<option value="0">전체</option>
					<c:forEach items="${typeList }" var="bt">
						<option value="${bt.bt_num}" <c:if test="${bt.bt_num==pm.cri.type}">selected</c:if>>${bt.bt_name}</option>
					</c:forEach>
				</select>
			</div>
			<input type="text" class="form-control" palceholder="검색어를 입력하세요." name="search" value="${pm.cri.search}">
			<div class="input-group-append">
				<button class="btn btn-success" type="submit">검색</button>
			</div> 
		</div>
	</form>
</div>
