
package com.konst.webbattle.domain.dao.interfaces;

import com.konst.webbattle.domain.model.User;
import java.util.ArrayList;

public interface UserDao {
    
    User findByLogin(String login);
    ArrayList<User> findAllUsers();
    void create(User user);
    void update(User user);
    
}
