package com.food.loveappetite.model;

public class TransactionsModel {
    private String Address;
    private String Email;
    private String ID;
    private String Name;
    private String Paid;
    private String PaymentID;
    private String PhoneNumber;
    private String ProductID;
    private String Timestamp;
    private String UserID;
    private String Harga;

    public TransactionsModel(){

    }

    public TransactionsModel(String Address, String Email, String ID, String Name, String Paid, String PaymentID,
                             String PhoneNumber, String ProductID, String Timestamp, String UserID, String Harga){
        this.Address = Address;
        this.Email = Email;
        this.ID = ID;
        this.Name = Name;
        this.Paid = Paid;
        this.PaymentID = PaymentID;
        this.PhoneNumber = PhoneNumber;
        this.ProductID = ProductID;
        this.Timestamp = Timestamp;
        this.UserID = UserID;
        this.Harga = Harga;
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
    public String getEmail(){
        return  Email;
    }
    public void setEmail(String Email){
        this.Email = Email;
    }
    public String getAddress(){
        return Address;
    }
    public void setAddress(String Address){
        this.Address = Address;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }
    public void setPhoneNumber(String PhoneNumber){
        this.PhoneNumber = PhoneNumber;
    }
    public String getPaid(){
        return Paid;
    }
    public void setPaid(String Paid){
        this.Paid = Paid;
    }
    public String getPaymentID(){
        return PaymentID;
    }
    public void setPaymentID(String PaymentID){
        this.PaymentID = PaymentID;
    }
    public String getProductID(){
        return ProductID;
    }
    public void setProductID(String ProductID){
        this.PaymentID = PaymentID;
    }
    public String getTimestamp(){
        return Timestamp;
    }
    public void setTimestamp(String Timestamp){
        this.Timestamp = Timestamp;
    }
    public String getUserID(){
        return UserID;
    }
    public void setUserID(String UserID){
        this.UserID = UserID;
    }
    public String getHarga(){
        return Harga;
    }
    public void setHarga(String Harga){
        this.Harga = Harga;
    }
}
