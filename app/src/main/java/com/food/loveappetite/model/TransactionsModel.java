package com.food.loveappetite.model;

public class TransactionsModel {

    private String id;
    private UsersModel user;
    private ProductsModel product;
    private String payment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UsersModel getUser() {
        return user;
    }

    public void setUser(UsersModel user) {
        this.user = user;
    }

    public ProductsModel getProduct() {
        return product;
    }

    public void setProduct(ProductsModel product) {
        this.product = product;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
