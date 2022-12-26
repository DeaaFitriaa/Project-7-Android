package com.food.loveappetite.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.food.loveappetite.R;
import com.food.loveappetite.controller.TransactionsController;
import com.food.loveappetite.model.ProductsModel;
import com.food.loveappetite.model.TransactionsModel;
import com.food.loveappetite.model.UsersModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class InfoActivity extends AppCompatActivity {

    private TransactionsController controller;
    private TransactionsModel transactionsModel;
    private ProductsModel productModel;
    private UsersModel userModel;

    private ImageView ivProduct;
    private TextView tvName;
    private TextView tvDesc;
    private TextView tvPrice;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        if (productModel == null)
            productModel = (ProductsModel) getIntent().getSerializableExtra("Product");

        if (userModel == null)
            userModel = MainActivity.getUsersModel();

        if (controller == null)
            controller = new TransactionsController(userModel);

        ivProduct = findViewById(R.id.iv_product);
        tvName = findViewById(R.id.tv_product_name);
        tvDesc = findViewById(R.id.tv_product_desc);
        tvPrice = findViewById(R.id.tv_product_price);

        Glide.with(this)
                .load(productModel.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(Target.SIZE_ORIGINAL)
                .into(ivProduct);
        tvName.setText(productModel.getName());
        tvDesc.setText(productModel.getDescription());
        tvPrice.setText(productModel.getPrice());

        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(view -> {
            transactionsModel = new TransactionsModel();
            transactionsModel.setUser(userModel);
            transactionsModel.setProduct(productModel);
            controller.create(transactionsModel, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                        Toast.makeText(
                                getApplicationContext(),
                                "Pesanan Telah Dibuat",
                                Toast.LENGTH_SHORT
                        ).show();
                    else
                        Toast.makeText(
                                getApplicationContext(),
                                "Gagal Membuat Pesanan",
                                Toast.LENGTH_SHORT
                        ).show();
                }
            });
        });
    }
}