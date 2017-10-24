
package com.konst.webbattle.logic;

import com.konst.webbattle.services.Battle;
import com.konst.webbattle.logic.interfaces.Playable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="field")
public class Field implements Playable, Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="FIELD_ID", unique=true, nullable=false)
    private int num;

    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Ship> ships = new ArrayList<Ship>();

    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Shot> shots = new ArrayList<Shot>();

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="GAME_ID")
    private Game game;
    
    public Field(){

    }

    public int getNum(){
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setShips(ArrayList<Ship> ships){
        this.ships = ships;
    }
    public List<Ship> getShips(){
        return ships;
    }
    
    public void setShots(ArrayList<Shot> shots){
        this.shots = shots;
    }
    public List<Shot> getShots(){
        return shots;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean placeShip(Ship ship){
        if((ship.getOrientation()==Orientation.HORIZONTAL)&&(ship.getX()+ship.getLength()-1>=Battle.FIELD_SIZE))
            return false;
        if((ship.getOrientation()==Orientation.VERTICAL)&&(ship.getY()+ship.getLength()-1>=Battle.FIELD_SIZE))
            return false;
        for(Ship sh : ships)
            if(ship.isIntersect(sh))
                return false;
        ships.add(ship);
        return true;        
    }

    public int addShot(Shot shot){
        
        if((shot.getX()<0)||(shot.getX()>Battle.FIELD_SIZE-1)||(shot.getY()<0)||(shot.getY()>Battle.FIELD_SIZE-1))
            return -1;
        for(Shot previousShot : shots)
            if(shot.equals(previousShot))
                return -1;
        shots.add(shot);
        shot.setField(this);
        for(Ship ship : ships)
            if(ship.isWounded(shot)){
                ship.addWound();
                return 1;
            }
        return 0;
        
    }

    public int countWounds(){
        
        int result=0;
        for(Ship ship : ships)
            result+=ship.getWounds();
        return result;
        
    }
    
    @Override
    public String toString(){
        
        char[][] drawField = new char[Battle.FIELD_SIZE][Battle.FIELD_SIZE];
        
        for(int i = 0; i < Battle.FIELD_SIZE; i++)
            for(int j = 0; j < Battle.FIELD_SIZE; j++)
                drawField[i][j]='o';
        
        
        //заполняем поле кораблями 
        for(Ship ship : ships){
            if(ship.getOrientation()==Orientation.HORIZONTAL){
                for(int i = ship.getX(); i<ship.getX()+ship.getLength(); i++)
                    drawField[ship.getY()][i]='#';
            }
            else{
                for(int i = ship.getY(); i<ship.getY()+ship.getLength(); i++)
                    drawField[i][ship.getX()]='#';
            }
        }
        
        //заполняем поле выстрелами
        for(Shot shot : shots){
            if(drawField[shot.getY()][shot.getX()]=='#')
                drawField[shot.getY()][shot.getX()]='+';
            else
                drawField[shot.getY()][shot.getX()]='-';
        }
                
        StringBuilder result = new StringBuilder("__");
        for(int i = 0; i<Battle.FIELD_SIZE; i++){
            result.append((char)('a'+i));
            result.append(" ");
        }
        result.append("\n");
        
        for(int i = 0; i<Battle.FIELD_SIZE; i++){
            result.append(i+1);
            if(i<9){result.append("_");}
            for(int j = 0; j<Battle.FIELD_SIZE; j++)
                result.append(drawField[i][j]+" ");
            result.append("\n");
        }
        return result.toString();
    }
    
}
