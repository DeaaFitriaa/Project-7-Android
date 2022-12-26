package com.food.loveappetite.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.food.loveappetite.R;
import com.food.loveappetite.model.TransactionsModel;

import java.util.List;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.ViewHolder> {

    private List<TransactionsModel> data;
    private Context context;
    private int cardViewId;
    private int tvNameId;
    private int tvPriceId;

    public TransactionsAdapter(List<TransactionsModel> list, Context context, int cardViewId, int tvNameId, int tvPriceId) {
        this.data = list;
        this.context = context;
        this.cardViewId = cardViewId;
        this.tvNameId = tvNameId;
        this.tvPriceId = tvPriceId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_card_view_basket, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TransactionsModel model = data.get(position);

        holder.tvName.setText(model.getProduct().getName());
        holder.tvPrice.setText(model.getProduct().getPrice());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface ProductsInterface {
        void onSelected(TransactionsModel model);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(tvNameId);
            tvPrice = itemView.findViewById(tvPriceId);
        }
    }
}
