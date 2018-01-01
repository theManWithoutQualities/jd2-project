
package com.konst.webbattle.domain.dao;

import com.konst.webbattle.domain.dao.interfaces.FieldDao;
import com.konst.webbattle.domain.model.Field;
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

    @Override
    public Field findByNum(int num){

        return entityManager.find(Field.class, num);
        
    }

    @Override
    public void create(Field field){

        entityManager.persist(field);
        
    }


    @Override
    public void update(Field field){
        
        entityManager.merge(field);
        
    }
    
}
