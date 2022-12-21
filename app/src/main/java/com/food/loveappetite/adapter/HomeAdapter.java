package com.food.loveappetite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.food.loveappetite.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_card_view_product, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

//    public interface OnItemSelected {
//        void onItemSelected(ProductModel model);
//    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvHotDeal;
        private ImageView ivProductImg;
        private TextView tvProductName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHotDeal = itemView.findViewById(R.id.tv_hot_deal);
            ivProductImg = itemView.findViewById(R.id.iv_food);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
        }
    }
}
