package com.food.loveappetite.model;

public class PaymentsModel {
    private String ID;
    private String Name;

    public PaymentsModel(){

    }

    public PaymentsModel(String ID, String Name){
        this.ID = ID;
        this.Name = Name;
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
}
