
package com.konst.webbattle.services;

import com.konst.webbattle.domain.model.User;

public interface Enterable {
    
    boolean setUser(String login, String password);
    boolean setNewUser(User user);
    void unsetUser();
    
}
