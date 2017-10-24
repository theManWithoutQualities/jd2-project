<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="top.jsp" />
    
        <center>
            <form:form action="${pageContext.request.contextPath}/register" method="POST" modelAttribute="user">
            
            <h1>Registration</h1>
            ${message}<br>
            <form:errors path="name" /><br>
            <form:input path="name" type="text" placeholder="Your name" />                
            <br>
            <form:errors path="login" /><br>
            <form:input path="login" type="text" placeholder="Login" />
            <br>
            <form:errors path="password" /><br>
            <form:input path="password" type="password" placeholder="Password" />
            <br>
            <input name="action" type="submit" value="REGISTER" />

            </form:form>
        </center>
        
    </body>
</html>
