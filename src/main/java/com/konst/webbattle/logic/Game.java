
package com.konst.webbattle.logic;

import com.konst.webbattle.services.Battle;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="game")
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GAME_ID", unique=true, nullable=false)
    private int num;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinColumns(value= {@JoinColumn, @JoinColumn})
    @IndexColumn(name="idxu")
    private List<User> players;
    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="GAME_ID")
    @IndexColumn(name="idxf")
    private List<Field> fields;
    @Column
    private boolean active=true;
    @Column
    private int winnerNumber = -1;
    @Column
    private int turn;

    public Game() {
        players = new ArrayList<User>(2);
        fields = new ArrayList<Field>(2);
    }

    public Game(User player1, User player2){

        players = new ArrayList<User>(2);
        fields = new ArrayList<Field>(2);
        players.add(player1);
        players.add(player2);
        turn=(int)Math.round(Math.random());
                
    }
    
    public void setNum(int num){
        this.num=num;
    }
    
    public int getNum(){
        return num;
    }
    
    public void setPlayers(List<User> players){
        this.players = players;
    }
    
    public List<User> getPlayers(){
        return players;
    }
    
    public void setFields(List<Field> fields){
        this.fields = fields;
    }
    
    public List<Field> getFields(){
        return fields;
    }
    
    public void setFirstPlayer(User user){
        this.players.set(0, user);
    }
    public User getFirstPlayer(){
        return players.get(0);
    }
    
    public void setSecondPlayer(User user){
        this.players.set(1, user);
    }
    public User getSecondPlayer(){
        return players.get(1);
    }
    
    public void setFirstField(Field field){
        if(fields.size()>0)
            this.fields.set(0, field);
        else
            fields.add(field);
    }
    public Field getFirstField(){
            return fields.get(0);
    }
    
    public void setSecondField(Field field){
        if(fields.size()==0){
            fields.add(null);
            fields.add(null);
            fields.set(1, field);
        }
        else if(fields.size()==1)
            fields.add(field);
        else
            fields.set(1, field);
    }
    public Field getSecondField(){
        return fields.get(1);
    }
    
    public Field getUserField(User user){
        if(user.equals(players.get(0)))
            return fields.get(0);
        else if(user.equals(players.get(1)))
            return fields.get(1);
        else
            return null;
    }
    
    public boolean isActive(){
        return active;
    }
    public void close(){
        active = false;
    }
    public void setState(boolean state){
        active = state;
    }
    
    //очередность устанавливается самой игрой автоматически
    public int getTurn(){
        return turn;
    }
    
    public void setWinnerNumber(int winnerNumber){
        this.winnerNumber=winnerNumber;
    }
    public int getWinnerNumber(){
        return winnerNumber;
    }
    
    public boolean isInitialized(){
        if((fields.get(0)!=null)&&(fields.get(1)!=null))
            return true;
        return false;
    }
    
    public User getWinner(){
        if(winnerNumber == -1)
            return null;
        else
            return players.get(winnerNumber);
    }
    
    public User getTurnPlayer(){
        return players.get(turn);
    }
    
    public int makeShot(Shot shot){
        int result = fields.get(1-turn).addShot(shot);
        if(result > -1){
            if(fields.get(1-turn).countWounds()==Battle.MAX_DAMAGE)
                setWinnerNumber(turn);
            switchTurnPlayer();
        }
        return result;
    }
    
    private void switchTurnPlayer(){
        turn=1-turn;
    }
    
}
