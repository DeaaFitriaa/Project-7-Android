package com.food.loveappetite.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.food.loveappetite.R;
import com.food.loveappetite.activity.MainActivity;
import com.food.loveappetite.adapter.TransactionsAdapter;
import com.food.loveappetite.controller.ProductsController;
import com.food.loveappetite.controller.TransactionsController;
import com.food.loveappetite.model.TransactionsModel;
import com.food.loveappetite.model.UsersModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.util.List;

public class BasketFragment extends Fragment {

    private TransactionsController controller;
    private List<TransactionsModel> transactionsList;
    private TransactionsAdapter adapter;
    private UsersModel userModel;

    private TextView tvUserName;
    private RecyclerView rvBasket;
    private Button btnPay;

    private int cvBasketId;
    private int tvProductNameId;
    private int tvProductPriceId;

    public BasketFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basket, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvUserName = view.findViewById(R.id.tv_user_name);
        rvBasket = view.findViewById(R.id.rv_basket);
        btnPay = view.findViewById(R.id.btn_pay);

        cvBasketId = R.id.cv_basket;
        tvProductNameId = R.id.tv_product_name;
        tvProductPriceId = R.id.tv_product_price;

        rvBasket.setLayoutManager(new LinearLayoutManager(getActivity()));

        userModel = MainActivity.getUsersModel();
        tvUserName.setText(userModel.getName());

        if (controller == null)
            controller = new TransactionsController(userModel);

        controller.readAll(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    for (DataSnapshot dataSnapshot : task.getResult().getChildren()) {
                        TransactionsModel transaction = dataSnapshot.getValue(TransactionsModel.class);
                        transactionsList.add(transaction);
                    }
                    adapter = new TransactionsAdapter(transactionsList, getActivity(), cvBasketId, tvProductNameId, tvProductPriceId);
                    rvBasket.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    btnPay.setOnClickListener(view -> {
                        Toast.makeText(
                                getActivity(),
                                "INI HANYA PROJECT, BUKAN APLIKASI BENERAN YANG BISA BAYAR TERUS DAPAT MAKANAN",
                                Toast.LENGTH_LONG
                        ).show();
                    });
                }
            }
        });
    }
}