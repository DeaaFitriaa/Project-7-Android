package com.food.loveappetite.config;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Config {
    private static final String DB_URL = "https://ccit-project-c68fc-default-rtdb.asia-southeast1.firebasedatabase.app/";
    private static final String DB_REFERENCE = "loveappetite";
    private static DatabaseReference dbReference;

    public static void koneksi() {
        dbReference = FirebaseDatabase.getInstance(DB_URL).getReference(DB_REFERENCE);
    }


}
