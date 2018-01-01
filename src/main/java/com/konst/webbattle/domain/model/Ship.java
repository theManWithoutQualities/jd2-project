
package com.konst.webbattle.domain.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="ship")
public class Ship implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SHIP_ID", unique=true, nullable=false)
    private int num;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="FIELD_ID")
    private Field field;

    @Column
    private int x;

    @Column
    private int y;

    @Column
    private int length;

    @Column
    private Orientation orientation;

    @Column
    private int wounds=0;

    public Ship() {
    }

    public Ship(int length, int x, int y, Orientation orientation){
        this.length=length;
        this.x=x;
        this.y=y;
        this.orientation=orientation;
    }

    public void setNum(int num){
        this.num=num;
    }
    
    public int getNum(){
        return num;
    }
    
    public void setField(Field field){
        this.field = field;
    }
    public Field getField(){
        return field;
    }
    
    public void setLength(int length){
        this.length = length;
    }
    public int getLength(){
        return length;
    }
    
    public void setX(int x){
        this.x=x;
    }
    public int getX(){
        return x;
    }
    
    public void setY(int y){
        this.y=y;
    }
    public int getY(){
        return y;
    }
    
    public void setWounds(int wounds){
        this.wounds = wounds;
    }
    public int getWounds(){
        return wounds;
    }
    
    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }
    public Orientation getOrientation(){
        return orientation;
    }
    
    public void addWound(){
        wounds++;
    }
    
    public boolean isWounded(Shot shot){
        if((orientation==Orientation.HORIZONTAL)&&(shot.getY()==y)&&(shot.getX()>=x)&&(shot.getX()<=x+length))
            return true;
        if((orientation==Orientation.VERTICAL)&&(shot.getX()==x)&&(shot.getY()>=y)&&(shot.getY()<=y+length))
            return true;
        return false;
    }
    
    public boolean isIntersect(Ship otherShip){
        
        //корабли не должны ни пересекаться, ни соприкасаться сторонами и углами
        
        /*расширяем один из прямоугольников на 1 во все стороны и смотрим,
        есть ли пересечения прямоугольника А с прямоугольником В*/
        int Ax1=this.getX()-1;
        int Ay1=this.getY()-1;
        int Ax2;
        int Ay2;
        if(this.getOrientation()==Orientation.HORIZONTAL){
            Ax2=this.getX()+this.getLength();
            Ay2=this.getY()+1;
        }
        else{
            Ax2=this.getX()+1;
            Ay2=this.getY()+this.getLength();
        }
        
        int Bx1=otherShip.getX();
        int By1=otherShip.getY();
        int Bx2;
        int By2;
        if(otherShip.getOrientation()==Orientation.HORIZONTAL){
            Bx2=otherShip.getX()+otherShip.getLength()-1;
            By2=otherShip.getY();
        }
        else{
            Bx2=otherShip.getX();
            By2=otherShip.getY()+otherShip.getLength()-1;
        }
        
        if((Bx1>=Ax1)&&(Bx1<=Ax2)&&(By1>=Ay1)&&(By1<=Ay2))
            return true;
        
        if((Bx2>=Ax1)&&(Bx2<=Ax2)&&(By2>=Ay1)&&(By2<=Ay2))
            return true;
        
        if((Bx1<Ax1)&&(Bx2>Ax2)&&(By1>=Ay1)&&(By2<=Ay2))
            return true;
        
        if((Bx1>=Ax1)&&(Bx2<=Ax2)&&(By1<Ay1)&&(By2>Ay2))
            return true;
        
        return false;
        
    }
    
}
