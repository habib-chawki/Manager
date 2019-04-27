package com.android.stockmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {
    private LinkedList<String> products;
    private LayoutInflater inflater;

    public ProductListAdapter(Context context, LinkedList<String> products){
        this.products = products;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProductListAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = inflater.inflate(R.layout.item_product, viewGroup, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.ProductViewHolder productViewHolder, int i) {
        String current = products.get(i);
        productViewHolder.productItemView.setText(current);


    }

    @Override
    public int getItemCount() {
        return products != null ? this.products.size() : 0;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        public TextView productItemView;
        //public ProductListAdapter adapter;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productItemView = itemView.findViewById(R.id.product);
        }
    }
}
