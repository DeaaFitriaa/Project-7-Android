package com.food.loveappetite.config;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Config {
    private static final String DB_URL = "https://project-ccit-default-rtdb.asia-southeast1.firebasedatabase.app/";
//    private static final String DB_REFERENCE = "loveappetite";
    private static DatabaseReference dbReference;

    public static DatabaseReference koneksi(String reference) {
        return FirebaseDatabase.getInstance(DB_URL).getReference(reference).child("data");
    }


}
