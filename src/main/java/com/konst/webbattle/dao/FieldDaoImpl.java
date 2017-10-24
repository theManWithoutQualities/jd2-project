
package com.konst.webbattle.dao;

import com.konst.webbattle.dao.interfaces.FieldDao;
import com.konst.webbattle.logic.Field;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class FieldDaoImpl implements FieldDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Field findByNum(int num){

        return entityManager.find(Field.class, num);
        
    }

    public void create(Field field){

        entityManager.persist(field);
        
    }

    public void update(Field field){
        
        entityManager.merge(field);
        
    }
    
}
