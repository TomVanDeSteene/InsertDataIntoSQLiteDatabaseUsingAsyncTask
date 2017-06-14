package com.tomvandesteene.insertdataintosqlitedatabaseusingasynctask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addProduct(View view){
        startActivity(new Intent(this, SaveInfoActivity.class));
    }

    public void displayProducts(View view){
        startActivity(new Intent(this, DisplayProductActivity.class));
    }
}
