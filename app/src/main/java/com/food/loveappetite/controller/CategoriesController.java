package com.food.loveappetite.controller;

import com.food.loveappetite.config.Config;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

public class CategoriesController {

    private final String REFERENCE = "2";
    private DatabaseReference dbReference;

    public CategoriesController() {
        this.dbReference = Config.koneksi(REFERENCE);
    }

    public Task<DataSnapshot> readAll(OnCompleteListener<DataSnapshot> onCompleteListener) {
        return dbReference.get().addOnCompleteListener(onCompleteListener);
    }

}
