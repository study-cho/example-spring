<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>
<%@ attribute name="items" type="com.example.examplespring.mvc.domain.BaseCodeLabelEnum[]" required="true" %>
<%@ attribute name="values" type="java.lang.Object" required="false" %>
<%-- 검색조건 부트스트랩 UI 체크박스 공통 tag --%>
<c:forEach var="boardType" items="${items}" varStatus="status">
    <div class="form-check form-check-inline">
        <input class="form-check-input" name="boardType" type="checkbox"
               value="${boardType.code()}"
               id="board-type${status.count}"/>
        <label class="form-check-label" for="board-type${status.count}">
                ${boardType.label()}
        </label>
    </div>
</c:forEach>
