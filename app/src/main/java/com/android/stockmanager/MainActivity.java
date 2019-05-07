package com.android.stockmanager;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    //private Spinner spinner;
//    private LinkedList<String> stockProducts = new LinkedList<>();
//    private LinkedList<String> storeProducts = new LinkedList<>();

    private TabLayout productsTabLayout;
    private PagerAdapter pagerAdapter;
    private ViewPager pager;

    private ProductListFragment currentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productsTabLayout = findViewById(R.id.tablayout_products);
        pager = findViewById(R.id.pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), productsTabLayout.getTabCount());
        pager.setAdapter(pagerAdapter);

        // works perfectly fine !
//        currentFragment = (ProductListFragment) pager.getAdapter().instantiateItem(pager, pager.getCurrentItem());
//        for(int i = 0; i < 10; i++){
//            stockProducts.add("Hi" + i);
//        }

        //spinner = findViewById(R.id.spinner);
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories_array, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);

        //pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productsTabLayout));
        productsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    //when the floating action button is pressed ==> launch the addProductsActivity to add a product
    public void addProduct(View view){
        Intent intent = new Intent(this, AddProductsActivity.class);
        startActivityForResult(intent, 1);
    }

    //retrieve the product information after the addProductActivity has finished
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(this, "name added: " + name, Toast.LENGTH_SHORT).show();
                currentFragment = (ProductListFragment) pager.getAdapter().instantiateItem(pager, pager.getCurrentItem());
                currentFragment.addProduct(name);
                currentFragment.notifyItemInserted();
            }
        }
    }

}
