
package com.konst.webbattle.domain.dao;

import com.konst.webbattle.domain.dao.interfaces.ShipDao;
import com.konst.webbattle.domain.model.Field;
import com.konst.webbattle.domain.model.Ship;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ShipDaoImpl implements ShipDao{

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ArrayList<Ship> findFieldShips(Field field){

        Query query = entityManager.createQuery("select s from Field f join f.ships s where f.num=:num");
        query.setParameter("num", field.getNum());
        return (ArrayList<Ship>)query.getResultList();        

    }

    @Override
    public void create(Ship ship){

        entityManager.persist(ship);
        
    }
    
    private void update(Ship ship){

        entityManager.merge(ship);
        
    }
    
}
