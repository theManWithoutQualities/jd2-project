
package com.konst.webbattle.services.interfaces;

import com.konst.webbattle.logic.User;

public interface Enterable {
    
    boolean setUser(String login, String password);
    boolean setNewUser(User user);
    void unsetUser();
    
}
