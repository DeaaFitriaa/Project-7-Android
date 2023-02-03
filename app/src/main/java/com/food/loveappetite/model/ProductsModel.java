package com.food.loveappetite.model;

import java.io.Serializable;

public class ProductsModel implements Serializable {

    private String CategoryID;
    private String Description;
    private String HOT;
    private String ID;
    private String Name;
    private String Price;
    private String ImageURL;

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
        return HOT;
    }
    public void setHot(String HOT){
        this.HOT = HOT;
    }
    public String getDescription(){
        return Description;
    }
    public void setDescription(String Description){
        this.Description = Description;
    }
    public String getPrice() {
        return Price;
    }
    public void setPrice(String Price) {
        this.Price = Price;
    }
    public String getImageURL() {
        return ImageURL;
    }
    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}
