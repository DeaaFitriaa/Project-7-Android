package com.food.loveappetite.adapter;

import android.content.Context;
import android.content.Intent;
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
    private TextView tvName;
    private TextView tvDesc;
    private RecyclerView rvProducts;
    private List<ProductsModel> products;

    public CategoriesAdapter(List<CategoriesModel> list, Context context, TextView tvName, TextView tvDesc,
                             RecyclerView rvProducts, List<ProductsModel> products) {
        this.data = list;
        this.context = context;
        this.tvName = tvName;
        this.tvDesc = tvDesc;
        this.rvProducts = rvProducts;
        this.products = products;
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
            if (product.getID().equals(model.getID()))
                holder.products.add(product);
        }
        ProductsAdapter productsAdapter = new ProductsAdapter(holder.products, context, this,
                R.layout.layout_card_view_product, R.id.iv_food, R.id.tv_hot_deal, R.id.tv_product_name,
                R.id.tv_product_desc);

        LinearLayoutManager llManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.rvProducts.setLayoutManager(llManager);
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
        private List<ProductsModel> products;

        public ViewHolder(@NonNull View itemView, List<ProductsModel> products) {
            super(itemView);
            this.tvName = CategoriesAdapter.this.tvName;
            this.tvDesc = CategoriesAdapter.this.tvDesc;
            this.rvProducts = CategoriesAdapter.this.rvProducts;
            this.products = products;
        }
    }
}
