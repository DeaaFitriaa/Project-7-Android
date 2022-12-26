package com.food.loveappetite.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.food.loveappetite.R;
import com.food.loveappetite.activity.InfoActivity;
import com.food.loveappetite.adapter.ProductsAdapter;
import com.food.loveappetite.controller.ProductsController;
import com.food.loveappetite.model.ProductsModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

public class HotFragment extends Fragment implements ProductsAdapter.ProductsInterface {

    private RecyclerView rvHot;

    private ProductsController controller;
    private List<ProductsModel> products;
    private ProductsAdapter adapter;

    private int cvProductId;
    private int ivProductId;
    private int tvProductHotId;
    private int tvProductNameId;
    private int tvProductDescId;

    public HotFragment() {
        // Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hot, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvHot = view.findViewById(R.id.rv_hot);
        cvProductId = R.id.cv_products;
        ivProductId = R.id.iv_food;
        tvProductHotId = R.id.tv_hot_deal;
        tvProductNameId = R.id.tv_product_name;
        tvProductDescId = R.id.tv_product_desc;

        rvHot.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (controller == null)
            controller = new ProductsController();

        if (products == null)
            controller.readAll(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        products = new ArrayList<>();
                        for (DataSnapshot dataSnapshot : task.getResult().getChildren()) {
                            ProductsModel product = dataSnapshot.getValue(ProductsModel.class);
                            if (product.getHot().equals("1"))
                                products.add(product);
                        }
                        adapter = new ProductsAdapter(products, getActivity(), HotFragment.this,
                                cvProductId, ivProductId, tvProductHotId, tvProductNameId, tvProductDescId);
                        rvHot.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                }
            });
    }

    @Override
    public void onSelected(ProductsModel model) {
        Intent intent = new Intent(getActivity(), InfoActivity.class);
        intent.putExtra("Product", model);
        startActivity(intent);
    }
}