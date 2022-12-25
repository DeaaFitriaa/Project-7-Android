package com.food.loveappetite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.food.loveappetite.R;
import com.food.loveappetite.model.ProductsModel;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<ProductsModel> data;
    private Context context;
    private ProductsAdapter.ProductsInterface productInterface;
    private CardView cardView;
    private ImageView imageView;
    private TextView tvHot;
    private TextView tvName;
    private TextView tvDesc;

    public ProductsAdapter(List<ProductsModel> list, Context context, ProductsAdapter.ProductsInterface productInterface,
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

    public ProductsAdapter(List<ProductsModel> list, Context context, ProductsAdapter.ProductsInterface productInterface,
                           int cardView, int imageView, int tvHot, int tvName, int tvDesc) {
        this.data = list;
        this.context = context;
        this.productInterface = productInterface;
        this.cardView = context;
        this.imageView = imageView;
        this.tvHot = tvHot;
        this.tvName = tvName;
        this.tvDesc = tvDesc;
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
        ProductsModel model = data.get(position);

        Glide.with(context)
                .load(model.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(Target.SIZE_ORIGINAL)
                .into(holder.ivProductImg);
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
        void onSelected(ProductsModel model);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cvProduct;
        private TextView tvHotDeal;
        private ImageView ivProductImg;
        private TextView tvProductName;
        private TextView tvProductDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvProduct = cardView;
            tvHotDeal = tvHot;
            ivProductImg = imageView;
            tvProductName = tvName;
            tvProductDesc = tvDesc;
        }
    }
}
