
package com.konst.webbattle.domain.dao.interfaces;

import com.konst.webbattle.domain.model.User;
import com.konst.webbattle.domain.model.Game;
import java.util.ArrayList;

public interface GameDao {
    
    ArrayList<Game> findAllGames();
    ArrayList<Game> findCurrentUserGames(User user);
    ArrayList<Game> findClosedUserGames(User user);
    Game findGameByNum(int num);
    void create(Game game);
    void update(Game game);

}
