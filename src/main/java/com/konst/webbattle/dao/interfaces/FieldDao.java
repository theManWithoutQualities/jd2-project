
package com.konst.webbattle.dao.interfaces;

import com.konst.webbattle.logic.Field;

public interface FieldDao {
    
    Field findByNum(int num);
    void create(Field field);
    void update(Field field);
    
}
