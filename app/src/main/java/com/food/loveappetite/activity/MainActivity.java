package com.food.loveappetite.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.food.loveappetite.R;
import com.food.loveappetite.controller.UsersController;
import com.food.loveappetite.fragment.BasketFragment;
import com.food.loveappetite.fragment.HomeFragment;
import com.food.loveappetite.fragment.HotFragment;
import com.food.loveappetite.fragment.SearchFragment;
import com.food.loveappetite.fragment.SettingFragment;
import com.food.loveappetite.model.UsersModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment;
    private BottomNavigationView navigation;
    private static UsersController controller;
    private static UsersModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnItemSelectedListener(itemSelectedListener);

        if (controller == null)
            controller = new UsersController();

        model = (UsersModel) getIntent().getSerializableExtra("UsersModel");

        if (savedInstanceState == null)
            navigation.setSelectedItemId(R.id.nav_menu_home);
    }

    private final NavigationBarView.OnItemSelectedListener itemSelectedListener
            = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_menu_home:
                    fragment = new HomeFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_layout_main_activity, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;

                case R.id.nav_menu_best_seller:
                    fragment = new HotFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_layout_main_activity, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;

                case R.id.nav_menu_search:
                    fragment = new SearchFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_layout_main_activity, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;

                case R.id.nav_menu_cart:
                    fragment = new BasketFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_layout_main_activity, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;

                case R.id.nav_menu_setting:
                    fragment = new SettingFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_layout_main_activity, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;
            }
            return false;
        }
    };

    public static UsersController getUsersController() {
        return controller;
    }

    public static UsersModel getUsersModel(){
        return model;
    }
}