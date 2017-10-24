
package com.konst.webbattle.services;

import com.konst.webbattle.services.interfaces.DataServiceInterface;
import com.konst.webbattle.dao.interfaces.ShotDao;
import com.konst.webbattle.dao.interfaces.GameDao;
import com.konst.webbattle.dao.interfaces.FieldDao;
import com.konst.webbattle.dao.interfaces.UserDao;
import com.konst.webbattle.logic.Game;
import com.konst.webbattle.logic.Invitation;
import com.konst.webbattle.logic.User;
import java.util.ArrayList;
import com.konst.webbattle.logic.Field;
import com.konst.webbattle.logic.Shot;
import com.konst.webbattle.repo.InvitationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataService  implements DataServiceInterface {
    
    @Autowired
    private UserDao userDao;
    @Autowired
    private GameDao gameDao;
    @Autowired
    private FieldDao fieldDao;
    @Autowired
    private ShotDao shotDao;
    @Autowired
    private InvitationRepository invitationRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void userUpdate(User user){
        
        userDao.update(user);
        
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void userCreate(User user){
        
        userDao.create(user);
        
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ArrayList<User> findAllUsers(){
        
        return userDao.findAllUsers();
        
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public User findUser(String login){
        
        return userDao.findByLogin(login);
        
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ArrayList<Game> findClosedUserGames(User user){
        
        return gameDao.findClosedUserGames(user);
        
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ArrayList<Game> findCurrentUserGames(User user){
        
        return gameDao.findCurrentUserGames(user);
        
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ArrayList<Game> findAllGames(){
        
        return gameDao.findAllGames();
        
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void gameUpdate(List<Game> games){
        
        for(Game game : games)
            gameDao.update(game);
        
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void gameUpdate(Game game){

        gameDao.update(game);

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void invitationCreate(Invitation invitation){
        
        invitationRepository.save(invitation);
        
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void invitationDelete(Invitation invitation){
        
        invitationRepository.delete(invitation);
        
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Invitation> findUserInvitations(User user){
        
        return invitationRepository.findUserInvitations(user);
        
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void gameCreate(Game game){
        gameDao.create(game);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void fieldCreate(Field field){
        fieldDao.create(field);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void shotCreate(Shot shot){
        shotDao.create(shot);
    }
     
}
