<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="top.jsp" />
<c:import url="menu.jsp" />
	<div class="center">
            
            <c:import url="left.jsp" />
            
            <div class="content">

                <center><h3>Games</h3></center>
                <c:set var="alphabet" value="${['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j']}" scope="page"></c:set>
                <c:forEach var="game" items="${battle.getAllGames()}">
                    <div class="game">
                        <div class="game_title">
                            game#${game.num}<br>
                            ${game.firstPlayer.name}-${game.secondPlayer.name}<br>
                            Move: ${game.players[game.turn].name}<br>
                        </div>
                        <c:choose>
                            <c:when test="${(game.fields[0]!=null)&&(game.fields[1]!=null)}">
                                <c:forEach var="field_num" begin="0" end="1">
                                    <div class="field${game.players[field_num].login==battle.currentUser.login?'_my':'_rival'}" id="${game.num}_${field_num}">
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
                                        <form>
                                            <c:forEach var="ind" begin="0" end="${game.fields[field_num].ships.size()-1}">
                                                <input type="hidden" id="ship_x_${game.num}_${field_num}_${ind}" value="${game.fields[field_num].ships[ind].x}" />
                                                <input type="hidden" id="ship_y_${game.num}_${field_num}_${ind}" value="${game.fields[field_num].ships[ind].y}" />
                                                <input type="hidden" id="ship_length_${game.num}_${field_num}_${ind}" value="${game.fields[field_num].ships[ind].length}" />
                                                <input type="hidden" id="ship_orient_${game.num}_${field_num}_${ind}" value="${game.fields[field_num].ships[ind].orientation}" />
                                            </c:forEach>
                                               
                                            <input type="hidden" id="count_shots_${game.num}_${field_num}" value="${game.fields[field_num].shots.size()}" />
                                            <c:if test="${game.fields[field_num].shots.size()>0}">
                                                <c:forEach var="ind" begin="0" end="${game.fields[field_num].shots.size()-1}">
                                                    <input type="hidden" id="shot_x_${game.num}_${field_num}_${ind}" value="${game.fields[field_num].shots[ind].x}" />
                                                    <input type="hidden" id="shot_y_${game.num}_${field_num}_${ind}" value="${game.fields[field_num].shots[ind].y}" />
                                                </c:forEach>
                                            </c:if>
                                        </form>
                                        <div class="cells">
                                            <c:forEach var="i" begin="0" end="9">
                                                <c:forEach var="j" begin="0" end="9">
                                                    <div class="cell ${game.players[field_num].login}" id="${game.num}_${field_num}_${j}_${i}"></div>
                                                </c:forEach>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <h5>Game is not initialized</h5>
                                <c:if test="${((battle.currentUser.login.equals(game.players[0].login))&&(game.fields[0]==null))||
                                      ((battle.currentUser.login.equals(game.players[1].login))&&(game.fields[1]==null))}">
                                      <div class="place_button">
                                          <input type="hidden" name="rival_login" value="${battle.currentUser.login.equals(game.players[0].login)?game.players[1].login:game.players[0].login}"/>
                                          <center>Place ships</center>
                                      </div>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </c:forEach>
                <div style="clear:both;"></div>

            </div>
                
            <c:import url="right.jsp" />  
	</div>
	
	<div class="footer"></div>
</body>
</html>


