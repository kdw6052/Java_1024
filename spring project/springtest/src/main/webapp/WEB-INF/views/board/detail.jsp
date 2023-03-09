<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>게시글 상세</h1>
<div class="form-group">
	<label>제목</label>
	<div class="form-control">${board.bo_title }</div>
</div>
<div class="form-group">
	<label>게시판</label>
	<div class="form-control">${board.bt_name }</div>
</div>
<div class="form-group">
	<label>작성자</label>
	<div class="form-control">${board.bo_me_id }</div>
</div>
<div class="form-group">
	<label>작성일</label>
	<div class="form-control">${board.bo_register_date_str }</div>
</div>
<div class="form-group">
	<c:if test="${board.bo_update_date != null }">
		<label>수정일</label>
		<div class="form-control">${board.bo_update_date_str }</div>
	</c:if>
</div>
<div class="form-group">
	<label>조회수</label>
	<div class="form-control">${board.bo_views }</div>
</div>
<div>
	<button class="btn btn-outline-success">추천(${board.bo_up })</button>
	<button class="btn btn-outline-danger">비추천(${board.bo_down })</button>
</div>
<div class="form-group">
	<label>내용</label>
	<div class="form-control" style="min-heigth:400px">${board.bo_content }</div>
</div>
<c:if test="${fList != null && fList.size() != 0 }">
	<div class="form-group">
		<label>첨부파일</label>
		<c:forEach items="${fList }" var="file">
			<a class="form-control" href="<c:url value='/file${file.fi_name }'></c:url>" download="${file.fi_ori_name}">${file.fi_ori_name }</a>
		</c:forEach>
	</div>
</c:if>
<a class="btn btn-success" href="<c:url value='/board/list'></c:url>">목록</a>