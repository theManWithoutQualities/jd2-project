
package com.konst.webbattle.domain.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends User implements Serializable{

    public Admin() {
    }
    
    public Admin(String name, String login, String password){
        super(name, login, password);
    }
    
}
