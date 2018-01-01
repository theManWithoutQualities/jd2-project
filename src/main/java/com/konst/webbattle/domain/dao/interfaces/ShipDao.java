
package com.konst.webbattle.domain.dao.interfaces;

import com.konst.webbattle.domain.model.Field;
import com.konst.webbattle.domain.model.Ship;
import java.util.ArrayList;

public interface ShipDao {
    
    ArrayList<Ship> findFieldShips(Field field);
    void create(Ship ship);
    
}
