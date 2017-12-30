package com.konst.webbattle.domain.model;

import com.konst.webbattle.domain.model.interfaces.Registerable;
import java.io.Serializable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "User_Type")
@DiscriminatorValue("User")
@Table(name="user")
public class User implements Registerable, Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID", unique=true, nullable=false)
    protected int num;

    @Column
    @Size(min=3, max=20)
    protected String name;

    @Column(unique = true)
    @Size(min=3, max=10)
    protected String login;

    @Column
    @Size(min=3, max=30)
    protected String password;

    @ManyToMany(mappedBy="players")
    protected List<Game> games = new ArrayList<Game>();

    @OneToMany(mappedBy="inviter")
    protected List<Invitation> invitationsFrom = new ArrayList<Invitation>();

    @OneToMany(mappedBy="target")
    protected List<Invitation> invitationsTo = new ArrayList<Invitation>();

    public User() {
    }

    public User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }
    
    public void setNum(int num){
        this.num = num;
    }
    
    public int getNum(){
        return num;
    }
    
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }
    
    public void setLogin(String login){
        this.login = login;
    }

    @Override
    public String getLogin(){
        return login;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String getPassword(){
        return password;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Invitation> getInvitationsFrom() {
        return invitationsFrom;
    }

    public List<Invitation> getInvitationsTo() {
        return invitationsTo;
    }

    public void setInvitationsFrom(List<Invitation> invitationsFrom) {
        this.invitationsFrom = invitationsFrom;
    }

    public void setInvitationsTo(List<Invitation> invitationsTo) {
        this.invitationsTo = invitationsTo;
    }

    @Override
    public String toString(){
        return login;
    }
    
    @Override
    public boolean equals(Object o){
        if((o instanceof User )&&(((User)o).getLogin().equals(login))
                &&(((User)o).getPassword().equals(password)))
            return true;
        return false;
    }
    
}
