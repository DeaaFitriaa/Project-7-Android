package com.food.loveappetite.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.food.loveappetite.R;
import com.food.loveappetite.adapter.CategoriesAdapter;
import com.food.loveappetite.controller.CategoriesController;
import com.food.loveappetite.controller.ProductsController;
import com.food.loveappetite.model.CategoriesModel;
import com.food.loveappetite.model.ProductsModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private CategoriesController categoriesController;
    private List<CategoriesModel> categoriesModelList;
    private CategoriesAdapter adapter;

    private ProductsController productsController;
    private List<ProductsModel> productsModelList;

    private RecyclerView rvCategories;

    private int tvCategoryNameId;
    private int tvCategoryDescId;
    private int rvProductsId;

    private int cvProductId;
    private int ivProductId;
    private int tvProductHotId;
    private int tvProductNameId;
    private int tvProductDescId;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvCategories = view.findViewById(R.id.rv_category);
        tvCategoryNameId = R.id.tv_category;
        tvCategoryDescId = R.id.tv_category_desc;
        rvProductsId = R.id.rv_product;

        cvProductId = R.id.cv_products;
        ivProductId = R.id.iv_food;
        tvProductHotId = R.id.tv_hot_deal;
        tvProductNameId = R.id.tv_product_name;
        tvProductDescId = R.id.tv_product_desc;

        rvCategories.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (categoriesController == null)
            categoriesController = new CategoriesController();

        if (categoriesModelList == null) {
            categoriesModelList = new ArrayList<>();
            categoriesController.readAll(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        for (DataSnapshot dataSnapshot : task.getResult().getChildren()) {
                            categoriesModelList.add(dataSnapshot.getValue(CategoriesModel.class));
                        }
                        for (CategoriesModel test : categoriesModelList) {
                            Log.d(getClass().getSimpleName(), "Name : " + test.getName());
                            Log.d(getClass().getSimpleName(), "Desc : " + test.getDescription());
                        }
                        productsModelList = new ArrayList<>();
                        productsController = new ProductsController();
                        productsController.readAll(new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (DataSnapshot dataSnapshot : task.getResult().getChildren()) {
                                        productsModelList.add(dataSnapshot.getValue(ProductsModel.class));
                                    }
                                    for (ProductsModel test2 : productsModelList) {
                                        Log.d(getClass().getSimpleName(), "Name : " + test2.getName());
                                        Log.d(getClass().getSimpleName(), "Desc : " + test2.getDescription());
                                    }
                                    adapter = new CategoriesAdapter(categoriesModelList, getActivity(),
                                            tvCategoryNameId, tvCategoryDescId, rvProductsId, productsModelList,
                                            cvProductId, ivProductId, tvProductHotId, tvProductNameId, tvProductDescId);
                                    rvCategories.setAdapter(adapter);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                }
            });

        }
    }
}