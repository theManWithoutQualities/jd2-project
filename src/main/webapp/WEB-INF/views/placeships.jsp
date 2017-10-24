<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="top.jsp" />
<center><h4>Click "Start" to start place ships. Left-click for Horisontal ship; Right-click for Vertical ship</h4></center>
        <button class="start_place">Start</button>
        
        <c:set var="alphabet" value="${['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j']}" scope="page"></c:set>
        <div class="field">
            <div class="field_digits">
                <div class="dig_cell"></div>
                <c:forEach var="dig" begin="1" end="10">
                    <div class="dig_cell">
                        <center>${dig}</center>
                    </div>
                </c:forEach>    
            </div>
            <div class="field_letters">
                <c:forEach var="letter" begin="0" end="9">
                    <div class="leter_cell">
                        <center>${alphabet[letter]}</center>
                    </div>
                </c:forEach>
            </div>
            <div class="cells">
                <c:forEach var="i" begin="0" end="9">
                    <c:forEach var="j" begin="0" end="9">
                        <div class="cell" id="${j}_${i}"></div>
                    </c:forEach>
                </c:forEach>
            </div>
        </div>
        <form method="POST" action="${pageContext.request.contextPath}/place-ships">
            <c:forEach var="i" begin="0" end="9">
                <input type="hidden" name="${i}" />
            </c:forEach>
                <input type="hidden" name="rival_login" value="${rivalLogin}" />
            <button>Finish</button>
        </form>
    </body>
</html>
