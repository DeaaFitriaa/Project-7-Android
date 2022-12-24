package com.food.loveappetite.model;

import java.io.Serializable;

public class UsersModel implements Serializable {

    private String Address;
    private String Email;
    private String ID;
    private String Name;
    private String Password;
    private String PhoneNumber;

    public UsersModel(){

    }
    public UsersModel(String Address, String Email, String ID, String Name, String Password, String PhoneNumber){
        this.Address = Address;
        this.Email = Email;
        this.ID = ID;
        this.Name = Name;
        this.Password = Password;
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress(){
        return Address;
    }
    public void setAddress(String Address){
        this.Address = Address;
    }
    public String getEmail(){
        return Email;
    }
    public void setEmail(String Email){
        this.Email = Email;
    }
    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getPassword(){
        return Password;
    }
    public void setPassword(String Password){
        this.Password = Password;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }
    public void setPhoneNumber(String PhoneNumber){
        this.PhoneNumber = PhoneNumber;
    }
}
