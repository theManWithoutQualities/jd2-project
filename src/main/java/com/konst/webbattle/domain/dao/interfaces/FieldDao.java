
package com.konst.webbattle.domain.dao.interfaces;

import com.konst.webbattle.domain.model.Field;

public interface FieldDao {
    
    Field findByNum(int num);
    void create(Field field);
    void update(Field field);
    
}
