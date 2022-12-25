package com.food.loveappetite.controller;

import com.food.loveappetite.config.Config;
import com.food.loveappetite.model.CategoriesModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

public class ProductsController {

    private final String REFERENCE = "4";
    private DatabaseReference dbReference;

    public ProductsController() {
        this.dbReference = Config.koneksi(REFERENCE);
    }

    public Task<DataSnapshot> readAll(OnCompleteListener<DataSnapshot> onCompleteListener) {
        return dbReference.get().addOnCompleteListener(onCompleteListener);
    }

}
