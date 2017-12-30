package com.konst.webbattle.services;

import com.konst.webbattle.domain.dao.GameDaoImpl;
import com.konst.webbattle.domain.dao.UserDaoImpl;
import com.konst.webbattle.domain.dao.interfaces.GameDao;
import com.konst.webbattle.domain.dao.interfaces.UserDao;
import com.konst.webbattle.domain.model.Field;
import com.konst.webbattle.domain.model.Game;
import com.konst.webbattle.domain.model.User;
import junit.framework.TestCase;

/**
 * Created by x on 05.10.2017.
 */
public class BattleTest extends TestCase {
    public void testInitializeGameWithField() throws Exception {

        User user1 = new User("e", "e1","e");
        User user2 = new User("r", "r1","r");
        UserDao userDao = new UserDaoImpl();
        userDao.create(user1);
        userDao.create(user2);
        Game game = new Game(user1, user2);
        GameDao gameDao = new GameDaoImpl();
        gameDao.create(game);
        Game game1 = gameDao.findGameByNum(2);
        Field field = new Field();
        game1.setSecondField(field);

    }

}