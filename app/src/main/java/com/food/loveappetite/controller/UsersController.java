package com.food.loveappetite.controller;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.food.loveappetite.R;
import com.food.loveappetite.activity.LoginActivity;
import com.food.loveappetite.activity.MainActivity;
import com.food.loveappetite.config.Config;
import com.food.loveappetite.model.UsersModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

public class UsersController {
    private UsersModel model;
    private boolean status;
    private Task<DataSnapshot> task;
    private Activity activity;
    private DatabaseReference dbReference;

    public UsersController(){
        Config.koneksi();
        this.status = false;
    }

    public UsersController(Activity activity){
        Config.koneksi();
        this.activity = activity;
        this.status = false;
    }

    public UsersController(UsersModel model){
        Config.koneksi();
        this.model = model;
        this.status = false;
    }

    public UsersController(FirebaseUser user){
        Config.koneksi();
        this.task = read(user, new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                model = task.getResult().getValue(UsersModel.class);
            }
        });
        this.status = false;
    }

    public Task<DataSnapshot> getTask(){
        return task;
    }

    public boolean isLoggedIn(){
        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }

    public void create(UsersModel model) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(model.getEmail(), model.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String id = auth.getCurrentUser().getUid();
                    model.setID(id);
                    dbReference.child(id).setValue(model);
                    UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                            .setDisplayName(model.getName())
                            .build();
                    auth.getCurrentUser().updateProfile(profileUpdate);
                    activity.startActivity(new Intent(activity, LoginActivity.class));
                }
                else {
                    Toast.makeText(activity,"Register Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void delete(){
        dbReference.child(model.getID()).removeValue();
    }

    public Task<DataSnapshot> read(FirebaseUser user, OnCompleteListener<DataSnapshot> onCompleteListener) {
        return dbReference.child(user.getUid()).get().addOnCompleteListener(onCompleteListener);
    }

    public void update(UsersModel model) {
        dbReference.child(model.getID()).setValue(model)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            makeToast(R.integer.UPDATE_USER_SUCCESSFUL);
                            UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(model.getName())
                                    .build();
                            FirebaseAuth.getInstance().getCurrentUser().updateProfile(profileUpdate);
                        }
                        else
                            makeToast(R.integer.UPDATE_USER_FAILED);
                    }
                });
    }

    public void loginWithEmailAndPassword(String email, String password) {
        try{
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            activity.startActivity(new Intent(activity, MainActivity.class));
                            makeToast(R.integer.LOGIN_SUCCESSFUL);
                            activity.finish();
                        }
                        else {
                            makeToast(R.integer.LOGIN_FAILED);
                        }
                    });
        } catch(Exception e){
            System.out.println(e);
        }

    }

    public void makeToast(int statusCode) {
        String text = null;
        switch (statusCode) {
            case R.integer.LOGIN_SUCCESSFUL:
                text = activity.getString(R.string.LOGIN_SUCCESSFUL);
                break;

            case R.integer.LOGIN_CANCELED:
                text = activity.getString(R.string.LOGIN_CANCELED);
                break;

            case R.integer.LOGOUT_SUCCESSFUL:
                text = activity.getString(R.string.LOGOUT_SUCCESSFUL);
                break;

            case R.integer.NETWORK_ERROR:
                text = activity.getString(R.string.NETWORK_ERROR);
                break;

            case R.integer.LOGIN_FAILED:
                text = activity.getString(R.string.LOGIN_FAILED);
                break;

            case R.integer.UPDATE_USER_SUCCESSFUL:
                text = activity.getString(R.string.UPDATE_USER_SUCCESSFUL);
                break;

            case R.integer.UPDATE_USER_FAILED:
                text = activity.getString(R.string.UPDATE_USER_FAILED);
                break;
        }
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
    }

}
