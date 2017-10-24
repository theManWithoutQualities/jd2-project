
package com.konst.webbattle.logic;

import javax.persistence.*;

@Entity
@Table(name="shot")
public class Shot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SHOT_ID", unique=true, nullable=false)
    private int num;

    @ManyToOne()
    @JoinColumn(name="FIELD_ID")
    private Field field;

    @Column
    private int x;

    @Column
    private int y;

    public Shot() {
    }

    public Shot(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public void setNum(int num){
        this.num=num;
    }
    
    public int getNum(){
        return num;
    }
    
    public void setField(Field field){
        this.field=field;
    }
    public Field getField(){
        return field;
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
    
    @Override
    public boolean equals(Object o){
        if((o instanceof Shot )&&(((Shot)o).getX()==x)&&(((Shot)o).getY()==y))
            return true;
        return false;
    }
    
}
