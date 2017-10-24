
package com.konst.webbattle.logic.interfaces;

import com.konst.webbattle.logic.Ship;
import com.konst.webbattle.logic.Shot;

public interface Playable {
    
    boolean placeShip(Ship ship);
    int addShot(Shot shot);
    int countWounds();
    
}
