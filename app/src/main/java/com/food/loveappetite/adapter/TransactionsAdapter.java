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
    private TransactionsAdapter.ProductsInterface productInterface;
    private CardView cardView;
    private int cardViewId;
    private ImageView imageView;
    private int imageViewId;
    private TextView tvHot;
    private int tvHotId;
    private TextView tvName;
    private int tvNameId;
    private TextView tvDesc;
    private int tvDescId;

    public TransactionsAdapter(List<TransactionsModel> list, Context context, TransactionsAdapter.ProductsInterface productInterface,
                               CardView cardView, ImageView imageView, TextView tvHot, TextView tvName, TextView tvDesc) {
        this.data = list;
        this.context = context;
        this.productInterface = productInterface;
        this.cardView = cardView;
        this.imageView = imageView;
        this.tvHot = tvHot;
        this.tvName = tvName;
        this.tvDesc = tvDesc;
    }

    public TransactionsAdapter(List<TransactionsModel> list, Context context, TransactionsAdapter.ProductsInterface productInterface,
                               int cardViewId, int imageViewId, int tvHotId, int tvNameId, int tvDescId) {
        this.data = list;
        this.context = context;
        this.productInterface = productInterface;
        this.cardViewId = cardViewId;
        this.imageViewId = imageViewId;
        this.tvHotId = tvHotId;
        this.tvNameId = tvNameId;
        this.tvDescId = tvDescId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_card_view_product, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TransactionsModel model = data.get(position);
        Log.d(getClass().getSimpleName(), "ID : " + model.getID());
        Log.d(getClass().getSimpleName(), "Name : " + model.getName());
        Log.d(getClass().getSimpleName(), "Desc : " + model.getDescription());
        Log.d(getClass().getSimpleName(), "HOT : " + model.getHot());
        Log.d(getClass().getSimpleName(), "Price : " + model.getPrice());

//        Glide.with(context)
//                .load(model.getImageURL())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .override(Target.SIZE_ORIGINAL)
//                .into(holder.ivProductImg);
        if (model.getHot().equals("1")) {
            holder.tvHotDeal.setVisibility(View.VISIBLE);
            holder.tvHotDeal.setText("HOT DEAL");
        }
        else
            holder.tvHotDeal.setVisibility(View.INVISIBLE);

        holder.tvProductName.setText(model.getName());
        holder.tvProductDesc.setText(model.getDescription());
        holder.cvProduct.setOnClickListener(view -> {
            productInterface.onSelected(model);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface ProductsInterface {
        void onSelected(TransactionsModel model);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cvProduct;
        private TextView tvHotDeal;
        private ImageView ivProductImg;
        private TextView tvProductName;
        private TextView tvProductDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvProduct = itemView.findViewById(cardViewId);
            tvHotDeal = itemView.findViewById(tvHotId);
            ivProductImg = itemView.findViewById(imageViewId);
            tvProductName = itemView.findViewById(tvNameId);
            tvProductDesc = itemView.findViewById(tvDescId);
        }
    }
}
