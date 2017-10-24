package com.konst.webbattle.dao;

import com.konst.webbattle.dao.interfaces.UserDao;
import com.konst.webbattle.logic.User;
import junit.framework.TestCase;

/**
 * Created by x on 05.10.2017.
 */
public class UserDaoImplTest extends TestCase {
    public void testCreate() throws Exception {

        User user = new User("33", "33", "33");
        UserDao userDao = new UserDaoImpl();
        userDao.create(user);

    }

}