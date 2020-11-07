package com.kostya_zinoviev.retrofit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kostya_zinoviev.retrofit.R;
import com.kostya_zinoviev.retrofit.retrofit.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> productList;
    private Context mContext;

    public ProductAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(mContext).inflate(R.layout.layout_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product currentProduct = productList.get(position);

        holder.name.setText(currentProduct.getName());
        holder.price.setText(currentProduct.getPrice());
        holder.quantity.setText(currentProduct.getQuantity());
        holder.unit.setText(currentProduct.getUnit());

        Glide.with(mContext).load(currentProduct.getImageUrl()).into(holder.imageUrl);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageUrl;
        public TextView name,price,quantity,unit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.productName);
            price = itemView.findViewById(R.id.productPrice);
            imageUrl = itemView.findViewById(R.id.productImage);
            quantity = itemView.findViewById(R.id.productQuantity);
            unit = itemView.findViewById(R.id.productUnit);
        }
    }

}
