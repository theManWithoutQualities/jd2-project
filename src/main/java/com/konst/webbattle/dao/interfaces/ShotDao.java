
package com.konst.webbattle.dao.interfaces;

import com.konst.webbattle.logic.Field;
import com.konst.webbattle.logic.Shot;
import java.util.ArrayList;

public interface ShotDao {
    
    ArrayList<Shot> findFieldShots(Field field);
    void create(Shot shot);
    void update(Shot shot);
    
}
