
package com.konst.webbattle.dao.interfaces;

import com.konst.webbattle.logic.Field;
import com.konst.webbattle.logic.Ship;
import java.util.ArrayList;

public interface ShipDao {
    
    ArrayList<Ship> findFieldShips(Field field);
    void create(Ship ship);
    
}
