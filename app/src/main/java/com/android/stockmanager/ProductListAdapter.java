package com.android.stockmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {
    private LinkedList<String> products;
    private LayoutInflater inflater;
    private PopupMenu popupMenu;

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
    public void onBindViewHolder(@NonNull final ProductListAdapter.ProductViewHolder productViewHolder, int i) {
        String current = products.get(i);
        productViewHolder.productItemView.setText(current);

        //set a click listener for the three-dotted image-button
        productViewHolder.popupMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create the popupMenu and anchor it to the current button
                popupMenu = new PopupMenu(productViewHolder.itemView.getContext(), productViewHolder.popupMenuButton);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.menu_actions, popupMenu.getMenu());
                popupMenu.show();

                //set the click listener for the popup menu
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int productPosition = productViewHolder.getAdapterPosition();
                        //check which button was clicked
                        switch(menuItem.getItemId()){
                            //delete a product from the list
                            case R.id.menu_item_delete:
                                products.remove(productPosition);
                                notifyItemRemoved(productPosition);
                                break;
                                //show the details of a given product
                            case R.id.menu_item_details:
                                Toast.makeText(productViewHolder.itemView.getContext(), "Details Clicked " + productPosition, Toast.LENGTH_SHORT).show();
                                break;
                                //edit the information of a product
                            case R.id.menu_item_edit:
                                Toast.makeText(productViewHolder.itemView.getContext(), "Edit Clicked " + productPosition, Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return products != null ? this.products.size() : 0;
    }


    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        public TextView productItemView;
        public ImageButton popupMenuButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productItemView = itemView.findViewById(R.id.product);
            popupMenuButton = itemView.findViewById(R.id.imgbutton_actions);
        }

    }
}
