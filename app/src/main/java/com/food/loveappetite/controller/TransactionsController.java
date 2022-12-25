package com.food.loveappetite.controller;

import com.food.loveappetite.config.Config;
import com.food.loveappetite.model.TransactionsModel;
import com.food.loveappetite.model.UsersModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

public class TransactionsController {

    private final String REFERENCE = "5";
    private DatabaseReference dbReference;

    public TransactionsController(UsersModel user) {
        dbReference = Config.koneksi(REFERENCE).child(user.getID());
    }

    public Task<DataSnapshot> readAll(OnCompleteListener<DataSnapshot> onCompleteListener) {
        return dbReference.get().addOnCompleteListener(onCompleteListener);
    }

    public void create(TransactionsModel model, OnCompleteListener<Void> onCompleteListener) {
        String modelId = dbReference.getKey();
        model.setId(modelId);

        assert modelId != null;
        dbReference.child(modelId).setValue(model).addOnCompleteListener(onCompleteListener);
    }

    public void delete(TransactionsModel model, OnCompleteListener<Void> onCompleteListener) {
        dbReference.child(model.getId()).removeValue().addOnCompleteListener(onCompleteListener);
    }

}
