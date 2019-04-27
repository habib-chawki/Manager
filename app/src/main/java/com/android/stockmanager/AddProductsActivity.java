package com.android.stockmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AddProductsActivity extends AppCompatActivity {
    private TextView productName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);
        productName = findViewById(R.id.text_product_name);
    }

    //called when the add button is pressed
    //create an intent with the product information and send it to MainActivity

    public void addProduct(View view){
        Intent replyIntent = new Intent();
//        Intent intent = getIntent();
//        int qte = intent.getIntExtra("qte", -1);
//        Toast.makeText(this, "qte = " + qte, Toast.LENGTH_SHORT).show();

        replyIntent.putExtra("name", productName.getText().toString());
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
