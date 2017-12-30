
package com.konst.webbattle.domain.dao;

import com.konst.webbattle.domain.dao.interfaces.ShotDao;
import com.konst.webbattle.domain.model.Field;
import com.konst.webbattle.domain.model.Shot;
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

    @Override
    public ArrayList<Shot> findFieldShots(Field field){

        Query query = entityManager.createQuery("select s from Field f join f.ships s where f.num=:num");
        query.setParameter("num", field.getNum());
        return (ArrayList<Shot>)query.getResultList();

    }

    @Override
    public void create(Shot shot){

        entityManager.persist(shot);
        
    }

    @Override
    public void update(Shot shot){

        entityManager.merge(shot);
        
    }
    
}
