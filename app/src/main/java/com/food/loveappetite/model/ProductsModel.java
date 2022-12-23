package com.food.loveappetite.model;

public class ProductsModel {
    private String CategoryID;
    private String Description;
    private String Hot;
    private String ID;
    private String Name;

    public ProductsModel(){

    }

    public ProductsModel(String CategoryID, String Description, String Hot, String ID, String Name){
        this.CategoryID = CategoryID;
        this.Description = Description;
        this.Hot = Hot;
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
    public String getCategoryID(){
        return CategoryID;
    }
    public void setCategoryID(String CategoryID){
        this.CategoryID = CategoryID;
    }
    public String getHot(){
        return Hot;
    }
    public void setHot(String Hot){
        this.Hot = Hot;
    }
    public String getDescription(){
        return Description;
    }
    public void setDescription(String Description){
        this.Description = Description;
    }
}
