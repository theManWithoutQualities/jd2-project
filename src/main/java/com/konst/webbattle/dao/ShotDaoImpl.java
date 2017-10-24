
package com.konst.webbattle.dao;

import com.konst.webbattle.dao.interfaces.ShotDao;
import com.konst.webbattle.logic.Field;
import com.konst.webbattle.logic.Shot;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ShotDaoImpl implements ShotDao{

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public ArrayList<Shot> findFieldShots(Field field){

        Query query = entityManager.createQuery("select s from Field f join f.ships s where f.num=:num");
        query.setParameter("num", field.getNum());
        return (ArrayList<Shot>)query.getResultList();

    }

    public void create(Shot shot){

        entityManager.persist(shot);
        
    }
    
    public void update(Shot shot){

        entityManager.merge(shot);
        
    }
    
}
