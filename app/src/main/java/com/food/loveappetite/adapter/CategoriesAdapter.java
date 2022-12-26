package com.food.loveappetite.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.food.loveappetite.R;
import com.food.loveappetite.activity.InfoActivity;
import com.food.loveappetite.controller.ProductsController;
import com.food.loveappetite.model.CategoriesModel;
import com.food.loveappetite.model.ProductsModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> implements ProductsAdapter.ProductsInterface {

    private List<CategoriesModel> data;
    private Context context;
    private int tvNameId;
    private int tvDescId;
    private int rvProductsId;
    private List<ProductsModel> products;
    private int cvProductId;
    private int ivProductId;
    private int tvProductHotId;
    private int tvProductNameId;
    private int tvProductDescId;

    public CategoriesAdapter(List<CategoriesModel> list, Context context, int tvNameId, int tvDescId,
                             int rvProductsId, List<ProductsModel> products, int cvProductId, int ivProductId,
                             int tvProductHotId, int tvProductNameId, int tvProductDescId) {
        this.data = list;
        this.context = context;
        this.tvNameId = tvNameId;
        this.tvDescId = tvDescId;
        this.rvProductsId = rvProductsId;
        this.products = products;
        this.cvProductId = cvProductId;
        this.ivProductId = ivProductId;
        this.tvProductHotId = tvProductHotId;
        this.tvProductNameId = tvProductNameId;
        this.tvProductDescId = tvProductDescId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recycler_view_home_category, parent, false);
        List<ProductsModel> newProducts = new ArrayList<>();
        return new ViewHolder(view, newProducts);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoriesModel model = data.get(position);

        for (ProductsModel product : products) {
            Log.d(getClass().getSimpleName(), "Product's CategoryID : " + product.getCategoryID());
            Log.d(getClass().getSimpleName(), "CategoryID : " + model.getID());
            if (product.getCategoryID().equals(model.getID())) {
                Log.d(getClass().getSimpleName(), "EQUALS");
                holder.data.add(product);
            }
        }
        Log.d(getClass().getSimpleName(), holder.data.toString());

        ProductsAdapter productsAdapter = new ProductsAdapter(holder.data, context, this,
                cvProductId, ivProductId, tvProductHotId, tvProductNameId, tvProductDescId);

        LinearLayoutManager llManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.rvProducts.setLayoutManager(llManager);
        holder.rvProducts.setAdapter(productsAdapter);
        productsAdapter.notifyDataSetChanged();
        holder.tvName.setText(model.getName());
        holder.tvDesc.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onSelected(ProductsModel model) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra("Product", model);
        context.startActivity(intent);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvDesc;
        private RecyclerView rvProducts;
        private List<ProductsModel> data;

        public ViewHolder(@NonNull View itemView, List<ProductsModel> data) {
            super(itemView);
            this.tvName = itemView.findViewById(tvNameId);
            this.tvDesc = itemView.findViewById(tvDescId);
            this.rvProducts = itemView.findViewById(rvProductsId);
            this.data = data;
        }
    }
}
