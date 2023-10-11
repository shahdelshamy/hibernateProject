/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package loginwithhn;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class employees {
     private int id;
     private String userNameDB;
     private String passwordDB;

     private DataDetails d;

     @OneToOne(cascade=CascadeType.ALL)
    public DataDetails getD() {
        return d;
    }

    public void setD(DataDetails d) {
        this.d = d;
    }
     
     
    public String getUserNameDB() {
        return userNameDB;
    }

    public void setUserNameDB(String userName1) {
        this.userNameDB = userName1;
    }

    public String getPasswordDB() {
        return passwordDB;
    }

    public void setPasswordDB(String password1) {
        this.passwordDB = password1;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

}
