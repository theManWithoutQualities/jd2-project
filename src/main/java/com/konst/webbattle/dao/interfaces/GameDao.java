
package com.konst.webbattle.dao.interfaces;

import com.konst.webbattle.logic.User;
import com.konst.webbattle.logic.Game;
import java.util.ArrayList;

public interface GameDao {
    
    ArrayList<Game> findAllGames();
    ArrayList<Game> findCurrentUserGames(User user);
    ArrayList<Game> findClosedUserGames(User user);
    Game findGameByNum(int num);
    void create(Game game);
    void update(Game game);

}
