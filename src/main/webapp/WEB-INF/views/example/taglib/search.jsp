<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Example Search</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"/>
</head>
<body>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <div class="container">
        <h2>게시물 목록</h2>
        <form action="" method="get">
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">종류</label>
                <div class="col-sm-10">
                    <tag:bootstrap-checkbox items="${boardTypes}" values="${parameter.boardTypes}" />
                </div>
            </div>
            <div class="mb-3 text-center">
                <button type="submit" class="btn btn-primary">검색하기</button>
            </div>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>