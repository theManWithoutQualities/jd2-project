<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="top.jsp" />
	<div class="menubar">
		<ul class="menu">
			<li><a href="battle.jsp">Start</a></li>
			<li><a href="history.jsp">History</a></li>
			<li><a href="watchgames.jsp">Look other games</a></li>
			<li><a href="sign-out">Sign out</a></li>
		</ul>
	</div>
    <center>    
        
        ${message}<br>

        <h5><a href="${pageContext.request.contextPath}">OK</a></h5>

    </center>
	
	<div class="footer"></div>
</body>
</html>
