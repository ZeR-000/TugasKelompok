/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA_OOP;

/**
 *
 * @author DIAGY
 */
public class data_account implements account{
    String id,username,type;
    private String password;
    
    public data_account(String Id, String Username, String Type){
        this.id = Id;
        this.username = Username;
        this.type = Type;
    }
    
    public data_account(String Id){
        this.id = Id;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String setPassword(String password) {
        return this.password = password;
    }
    
    
}
