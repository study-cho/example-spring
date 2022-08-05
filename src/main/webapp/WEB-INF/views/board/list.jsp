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
    <title>등록/수정</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <form id="form" method="get" action="/list">
            <input type="hidden" name="boardType" value="COMMUNITY"/>
            <div class="row mb-3">
                <label for="keyword" class="col-sm-2 col-form-label"><spring:message code="search.keyword"/></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="keyword" name="keyword" value="${parameter.keyword}" placeholder="<spring:message code="placeholder.keyword"/>">
                </div>
            </div>
            <button type="submit" class="btn btn-primary"><spring:message code="button.search"/></button>
        </form>
        <table class="table caption-top">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col"><spring:message code="board.title" /></th>
                <th scope="col"><spring:message code="board.viewCount" /></th>
                <th scope="col"><spring:message code="board.regDate" /></th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="board" items="${boardList}" varStatus="status">
                    <tr>
                        <th scope="row">${status.count}</th>
                        <td>${board.title}</td>
                        <td>${board.viewCount}</td>
                        <td><fmt:formatDate value="${board.regDate}" pattern="yyyy.MM.dd HH:mm"/></td>
                    </tr>
                </c:forEach>
                <c:if test="${fn:length(boardList) == 0}">
                    <tr>
                        <td colspan="4"><spring:message code="msg.board.empty"/></td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script>
        $(function() {
            var $form = $('#form');
            $form.bind('submit', function() {
                $.ajax({
                    url: '/board/save',
                    type: 'post',
                    data: $form.serialize(),
                    dataType: 'json',
                    success: function(data) {
                        if (data.code == 'SUCCESS') {
                            alert('저장되었습니다.');
                        } else {
                            alert(data.message);
                        }
                        console.log(data);
                    }
                });
                return false;
            });
        });
    </script>
</body>
</html>