
package com.konst.webbattle.domain.dao.interfaces;

import com.konst.webbattle.domain.model.Field;
import com.konst.webbattle.domain.model.Shot;
import java.util.ArrayList;

public interface ShotDao {
    
    ArrayList<Shot> findFieldShots(Field field);
    void create(Shot shot);
    void update(Shot shot);
    
}
