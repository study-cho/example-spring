<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>상세</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                ${board.title}
            </div>
            <div class="card-body">
                <blockquote class="blockquote mb-0">
                    <p>${board.contents}</p>
                    <footer class="blockquote-footer"><fmt:formatDate value="${board.regDate}" pattern="yyyy.MM.dd HH:mm"/></footer>
                </blockquote>
            </div>
        </div>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-2">
            <a href="/board/list" class="btn btn-primary me-md-2" type="button"><spring:message code="button.list"/></a>
            <a href="/board/edit/${board.boardSeq}" class="btn btn-primary" type="button"><spring:message code="button.edit"/></a>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</body>
</html>