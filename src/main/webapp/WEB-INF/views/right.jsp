<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="right">
                
    <center><h3>Invitations</h3></center>
    <br>
    <c:forEach var="invit" items="${battle.currentUserInvitations}">
        <a href="${pageContext.request.contextPath}/accept-invitation/${invit.inviter.login}">${invit.inviter.name}</a>
        <br>
    </c:forEach>
                
</div>
