
package com.konst.webbattle.domain;

import java.util.ArrayList;
import com.konst.webbattle.domain.model.*;
import java.util.List;

public interface DataServiceInterface {
    
    void userUpdate(User user);
    void userCreate(User user);
    ArrayList<User> findAllUsers();
    User findUser(String login);
    List<Game> findClosedUserGames(User user);
    List<Game> findCurrentUserGames(User user);
    List<Game> findAllGames();
    void gameCreate(Game game);
    void gameUpdate(List<Game> games);
    void fieldCreate(Field field);
    void shotCreate(Shot shot);
    void invitationCreate(Invitation invitation);
    void invitationDelete(Invitation invitation);
    List<Invitation> findUserInvitations(User user);
    
}
