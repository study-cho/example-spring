<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <form id="form" method="post" action="/save">
            <input type="hidden" name="boardType" value="COMMUNITY"/>
            <div class="row mb-3">
                <label for="title" class="col-sm-2 col-form-label"><spring:message code="board.title"/></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="title" name="title" value="${board.title}" placeholder="<spring:message code="placeholder.required"/>">
                </div>
            </div>
            <div class="row mb-3">
                <label for="contents" class="col-sm-2 col-form-label"><spring:message code="board.contents"/></label>
                <div class="col-sm-10">
                    <textarea class="form-control" name="contents" id="contents" placeholder="<spring:message code="placeholder.required"/>">${board.contents}</textarea>
                </div>
            </div>
            <button type="submit" class="btn btn-primary"><spring:message code="button.save"/></button>
        </form>
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