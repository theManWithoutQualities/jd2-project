
package com.konst.webbattle.logic;

import javax.persistence.*;

@Entity
@Table(name="invitation")
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="INVITATION_ID", unique=true, nullable=false)
    private int num;

    @ManyToOne
    @JoinColumn
    private User inviter;

    @ManyToOne
    @JoinColumn
    private User target;

    public Invitation() {
    }

    public Invitation(User inviter, User target){
        this.inviter=inviter;
        this.target=target;
    }
    
    public void setNum(int num){
        this.num = num;
    }
    
    public int getNum(){
        return num;
    }
    
    public void setInviter(User inviter){
        this.inviter = inviter;
    }
    public User getInviter(){
        return inviter;
    }
    
    public void setTarget(User target){
        this.target = target;
    }
    public User getTarget(){
        return target;
    }
    
    @Override
    public String toString(){
        String inviterLogin = inviter.getLogin();
        String targetLogin = target.getLogin();
        return inviterLogin + " " + targetLogin;
    }
    
}
