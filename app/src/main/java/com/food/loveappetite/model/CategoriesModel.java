package com.food.loveappetite.model;

public class CategoriesModel {
    private String Description;
    private String ID;
    private String Name;

    public CategoriesModel(){

    }
    public CategoriesModel(String Description, String ID, String Name){
        this.Description = Description;
        this.ID = ID;
        this.Name = Name;
    }
    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public String getDescription(){
        return Description;
    }
    public void setDescription(String Description){
        this.Description = Description;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
}
