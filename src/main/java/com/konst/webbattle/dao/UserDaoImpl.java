
package com.konst.webbattle.dao;

import com.konst.webbattle.dao.interfaces.UserDao;
import com.konst.webbattle.logic.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public User findByLogin(String login){
        
        Query query = entityManager.createQuery("select u from User u where login=:login");
        query.setParameter("login", login);
        List<Object> list = query.getResultList();
        if(list.size()>0)
            return (User)list.get(0);
        else
            return null;

    }

    public ArrayList<User> findAllUsers(){

        Query query = entityManager.createQuery("select u from User u");
        return (ArrayList<User>)query.getResultList();
        
    }

    public void create(User user){

        entityManager.persist(user);
        
    }

    public void update(User user){

        entityManager.merge(user);
        
    }
    
}
