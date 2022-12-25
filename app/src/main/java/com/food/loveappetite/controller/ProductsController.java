package com.food.loveappetite.controller;

import com.food.loveappetite.config.Config;
import com.food.loveappetite.model.ProductsModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;

public class ProductsController {

    private final String REFERENCE = "4";
    private ProductsModel model;
    private DatabaseReference dbReference;

    public ProductsController() {
        this.dbReference = Config.koneksi(REFERENCE);
    }

    public ProductsModel read() {
        return dbReference.get().getResult().getValue(ProductsModel.class);
    }

    public Task read(OnCompleteListener onCompleteListener) {
        return dbReference.get().addOnCompleteListener(onCompleteListener);
    }


}
