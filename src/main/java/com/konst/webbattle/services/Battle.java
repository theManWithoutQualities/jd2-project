
package com.konst.webbattle.services;

import com.konst.webbattle.services.interfaces.Enterable;
import java.util.ArrayList;
import com.konst.webbattle.logic.Field;
import com.konst.webbattle.logic.Game;
import com.konst.webbattle.logic.Invitation;
import com.konst.webbattle.logic.Shot;
import com.konst.webbattle.logic.User;
import java.util.List;

public class Battle implements Enterable{
    
    public static final int FIELD_SIZE = 10;
    public static final int SHIP_COUNT = 10;
    public static final int MAX_DAMAGE = 20;
    
    private DataService dataService;
    
    private User currentUser;
    private List<Game> currentUserGames;
    private List<Invitation> currentUserInvitations;
    
    public Battle(DataService dataService){
        
        this.dataService = dataService;
        
    }

    public boolean setUser(String login, String password){
        User user = null;
            user = findUser(login);
        if(user==null)
            return false;
        if(user.getPassword().equals(password)){
            currentUser = user;
            setCurrentUserGames();
            setCurrentUserInvitations();
            
            return true;
        }
        else
            return false;
    }

    public boolean setNewUser(User user){
        if(findUser(user.getLogin())==null){
            currentUser = addUser(user);
            setCurrentUserGames();
            setCurrentUserInvitations();
            return true;
        }
        else{
            return false;
        }
    }

    public void unsetUser(){
        dataService.userUpdate(currentUser);
        dataService.gameUpdate(currentUserGames);
        currentUser = null;
        currentUserGames = null;
        currentUserInvitations = null;
    }
    
    public void createGame(String rivalLogin){
        Invitation invitation = null;
        for(Invitation inv : currentUserInvitations)
            if(rivalLogin.equals(inv.getInviter().getLogin()))
                invitation=inv;
        //с отдельным игроком можно играть одну партию в одно время
        if((findCurrentGame(rivalLogin)==null)&&(invitation!=null)){
            Game newGame = new Game(currentUser, invitation.getInviter());
            currentUserGames.add(newGame);
            dataService.gameCreate(newGame);
            currentUserInvitations.remove(invitation);
            dataService.invitationDelete(invitation);
        }
    }
    
    public void invite(String rivalLogin){
        User rival = findUser(rivalLogin);
        if((rival!=null)&&(!rival.equals(currentUser)))
            dataService.invitationCreate(new Invitation(currentUser, rival));
    }
    
    public User getCurrentUser(){
        return currentUser;
    }
    
    public List<Game> getCurrentUserGames(){
        return currentUserGames;
    }
    
    public List<Invitation> getCurrentUserInvitations(){
        return currentUserInvitations;
    }
    
    public ArrayList<User> getUsers(){
        return dataService.findAllUsers();
    }
    
    public ArrayList<Game> getHistory(){
        return dataService.findClosedUserGames(currentUser);
    }
    
    public ArrayList<Game> getAllGames(){
        return dataService.findAllGames();
    }
    
    public void makeShot(String rivalLogin, Shot shot){
        
        Game game = findCurrentGame(rivalLogin);
        
        if(!game.isInitialized()){
            //consoleInterface.sendMessage("в этой игре еще не расставлены корабли!");
            return;
        }
        if(!(game.getTurnPlayer().equals(currentUser))){
            //consoleInterface.sendMessage("не ваша очередь стрелять!");
            return;
        }
        
        int result = game.makeShot(shot);
        dataService.shotCreate(shot);

        switch(result){
            case -1:
                //consoleInterface.sendMessage("выстрел должен быть в рамках поля и по новому месту!");
                break;
            case 0:
                //consoleInterface.sendMessage("промах!");
                break;
            case 1:
                //consoleInterface.sendMessage("попадание!");
                break;
        }
        
        if(game.getWinner()!=null){
            //consoleInterface.sendMessage("победа!");
            currentUserGames.remove(game);
        }
        
        dataService.gameUpdate(currentUserGames);
        
    }
    
    public boolean initializeGameWithField(Game game, Field userField){

        if(game.getFirstPlayer().equals(currentUser)){

            game.setFirstField(userField);
            userField.setGame(game);
            dataService.gameUpdate(game);
            return true;
        }
        if(game.getSecondPlayer().equals(currentUser)){
            game.setSecondField(userField);
            userField.setGame(game);
            dataService.gameUpdate(game);
            return true;
        }
        return false;
    }
    
    public void refresh(){
        if(currentUser!=null){
            setCurrentUserGames();
            setCurrentUserInvitations();
        }
    }
    
    private void setCurrentUserGames(){
        currentUserGames = dataService.findCurrentUserGames(currentUser);
    }
    
    private void setCurrentUserInvitations(){
        currentUserInvitations = dataService.findUserInvitations(currentUser);
    }
    
    private User addUser(User user){
        dataService.userCreate(user);
        return user;
    }
    
    private User findUser(String login){
        User user = dataService.findUser(login);
        return user;
    }
    
    public Game findCurrentGame(String rivalLogin){
        Game game = null;
        for(Game g: currentUserGames)
            if((g.getFirstPlayer().getLogin().equals(rivalLogin))||(g.getSecondPlayer().getLogin().equals(rivalLogin)))
                game=g;
        return game;
    }
    
}
