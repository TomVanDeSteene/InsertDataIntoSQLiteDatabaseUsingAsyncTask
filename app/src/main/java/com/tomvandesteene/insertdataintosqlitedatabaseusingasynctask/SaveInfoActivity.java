package com.tomvandesteene.insertdataintosqlitedatabaseusingasynctask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SaveInfoActivity extends AppCompatActivity {

    EditText e_id, e_name, e_quantity, e_price;
    String id, name, quantity, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_info);
        e_id = (EditText)findViewById(R.id.d_id);
        e_name = (EditText)findViewById(R.id.d_name);
        e_quantity = (EditText)findViewById(R.id.d_quantity);
        e_price = (EditText)findViewById(R.id.d_price);
    }

    public void saveData(View view){
         id = e_id.getText().toString();
         name = e_name.getText().toString();
         quantity = e_quantity.getText().toString();
         price = e_price.getText().toString();

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("add_info", id, name, price, quantity);
        finish();
    }
}
