package com.food.loveappetite.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.food.loveappetite.R;
import com.food.loveappetite.adapter.ProductsAdapter;
import com.food.loveappetite.controller.ProductsController;
import com.food.loveappetite.model.ProductsModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.util.List;

public class SearchFragment extends Fragment {

    private RecyclerView rvSearch;
    private EditText etSearch;
    private Button btnSearch;

    private ProductsController controller;
    private List<ProductsModel> productsResult;
    private ProductsModel product;
    private ProductsAdapter adapter;

    private int cvProductId;
    private int ivProductId;
    private int tvProductHotId;
    private int tvProductNameId;
    private int tvProductDescId;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvSearch = view.findViewById(R.id.rv_search);
        etSearch = view.findViewById(R.id.et_search);
        btnSearch = view.findViewById(R.id.btn_search);
        cvProductId = R.id.cv_products;
        ivProductId = R.id.iv_food;
        tvProductHotId = R.id.tv_hot_deal;
        tvProductNameId = R.id.tv_product_name;
        tvProductDescId = R.id.tv_product_desc;

        rvSearch.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (controller == null)
            controller = new ProductsController();

        btnSearch.setOnClickListener(rootView -> {
            String searched = etSearch.getText().toString().trim();
            product = new ProductsModel();
            product.setName(searched);
            controller.read(product, new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    Log.d(getClass().getSimpleName(), task.toString());
                    Log.d(getClass().getSimpleName(), task.getResult().toString());
                    if (task.isSuccessful()) {
                        for (DataSnapshot dataSnapshot : task.getResult().getChildren()) {
                            ProductsModel product = dataSnapshot.getValue(ProductsModel.class);
                            if (product != null) {
                                Log.d(getClass().getSimpleName(), "MID : " + product.getID());
                                Log.d(getClass().getSimpleName(), "MName : " + product.getName());
                                Log.d(getClass().getSimpleName(), "MDescription : " + product.getDescription());
                                Log.d(getClass().getSimpleName(), "MImageURL : " + product.getImageURL());
                                Log.d(getClass().getSimpleName(), "MPrice : " + product.getPrice());
                            }
                            else {
                                Log.d(getClass().getSimpleName(), "DataSnapshot : " + dataSnapshot.getValue().toString());
                            }
                        }
                    }
                }
            });
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

}