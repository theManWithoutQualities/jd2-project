
package com.konst.webbattle.domain.model.interfaces;

import com.konst.webbattle.domain.model.Ship;
import com.konst.webbattle.domain.model.Shot;

public interface Playable {
    
    boolean placeShip(Ship ship);
    int addShot(Shot shot);
    int countWounds();
    
}
