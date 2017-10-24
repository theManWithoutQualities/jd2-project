<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="left">
    <center><h3>Players</h3></center>
    <br>
    <c:forEach var="user" items="${battle.getUsers()}">
        <a href="${pageContext.request.contextPath}/send-invitation/${user.login}">${user.name}</a>
        <br>
    </c:forEach>
</div>
