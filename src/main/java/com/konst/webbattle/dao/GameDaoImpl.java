
package com.konst.webbattle.dao;

import com.konst.webbattle.dao.interfaces.GameDao;
import com.konst.webbattle.logic.User;
import com.konst.webbattle.logic.Game;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class GameDaoImpl implements GameDao{

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public ArrayList<Game> findAllGames(){
        
        Query query = entityManager.createQuery("Select g from Game g");
        return (ArrayList<Game>)query.getResultList();

    }

    public ArrayList<Game> findCurrentUserGames(User user){

        Query query = entityManager.createQuery("select g from User u join u.games g where u.num=:num");
        query.setParameter("num", user.getNum());
        return (ArrayList<Game>) query.getResultList();    
        
    }

    public ArrayList<Game> findClosedUserGames(User user){

        Query query = entityManager.createQuery("select g from User u join u.games g where u.num=:num and g.active=false");
        query.setParameter("num", user.getNum());
        return (ArrayList<Game>) query.getResultList(); 

    }

    public Game findGameByNum(int num){

        return entityManager.find(Game.class, num);
        
    }

    public void create(Game game){

        entityManager.persist(game);
        
    }

    public void update(Game game){
                
        entityManager.merge(game);
        
    }

}
