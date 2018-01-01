
package com.konst.webbattle.domain.dao;

import com.konst.webbattle.domain.dao.interfaces.GameDao;
import com.konst.webbattle.domain.model.User;
import com.konst.webbattle.domain.model.Game;
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

    @Override
    public ArrayList<Game> findAllGames(){
        
        Query query = entityManager.createQuery("Select g from Game g");
        return (ArrayList<Game>)query.getResultList();

    }

    @Override
    public ArrayList<Game> findCurrentUserGames(User user){

        Query query = entityManager.createQuery("select g from User u join u.games g where u.num=:num");
        query.setParameter("num", user.getNum());
        return (ArrayList<Game>) query.getResultList();    
        
    }

    @Override
    public ArrayList<Game> findClosedUserGames(User user){

        Query query = entityManager.createQuery("select g from User u join u.games g where u.num=:num and g.active=false");
        query.setParameter("num", user.getNum());
        return (ArrayList<Game>) query.getResultList(); 

    }

    @Override
    public Game findGameByNum(int num){

        return entityManager.find(Game.class, num);
        
    }

    @Override
    public void create(Game game){

        entityManager.persist(game);
        
    }

    @Override
    public void update(Game game){
                
        entityManager.merge(game);
        
    }

}
