<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="top.jsp" />
    
    <center>
        <form method="POST" action="${pageContext.request.contextPath}/">

        <h1>Welcome</h1>
        ${message}<br>
        <input name="login" type="text" placeholder="Login" />
        <input name="password" type="password" placeholder="Password" />
        <br>
        <input name="action" type="submit" value="ENTER" />

        <hr style="background-color : #bebebe;"/>
        <hr style="background-color : #FFF; "/>

        <h5><a href="">Forgot password?</a> | <a href="${pageContext.request.contextPath}/register">Register</a></h5>

    </form>
    </center>
        
    </body>
</html>
