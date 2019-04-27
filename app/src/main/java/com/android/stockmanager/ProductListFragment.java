package com.android.stockmanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment {

    private View rootView;
    private RecyclerView productRecyclerView;
    private ProductListAdapter productListAdapter;
    private LinkedList<String> productsList = new LinkedList<>();


    public ProductListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_product_list, container, false);
        setProductListAdapter();
        return rootView;
    }

    public void notifyItemInserted(){
        productListAdapter.notifyItemInserted(0);
        productRecyclerView.smoothScrollToPosition(0);
    }

    public void addProduct(String product) {
        this.productsList.addFirst(product);
    }

    //set the adapter for the stockProductsList
    private void setProductListAdapter(){
        productRecyclerView = rootView.findViewById(R.id.recyclerview_stock);
        productListAdapter = new ProductListAdapter(getContext(), productsList);
        productRecyclerView.setAdapter(productListAdapter);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
