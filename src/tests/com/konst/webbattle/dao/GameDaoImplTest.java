package com.konst.webbattle.domain.dao;

import com.konst.webbattle.domain.dao.interfaces.FieldDao;
import com.konst.webbattle.domain.dao.interfaces.GameDao;
import com.konst.webbattle.domain.dao.interfaces.UserDao;
import com.konst.webbattle.domain.model.Field;
import com.konst.webbattle.domain.model.Game;
import com.konst.webbattle.domain.model.User;
import junit.framework.TestCase;

public class GameDaoImplTest extends TestCase {
    public void testCreate() throws Exception {

        /*User user1 = new User("e", "e11","e");
        User user2 = new User("r", "r11","r");
        UserDao userDao = new UserDaoImpl();
        userDao.create(user1);
        userDao.create(user2);
        Game game = new Game(user1, user2);
        GameDao gameDao = new GameDaoImpl();
        gameDao.create(game);*/
        GameDao gameDao = new GameDaoImpl();
        Game game=gameDao.findGameByNum(2);
        Field field = new Field();
        field.setGame(game);
        game.setSecondField(field);
        gameDao.update(game);
    }

}