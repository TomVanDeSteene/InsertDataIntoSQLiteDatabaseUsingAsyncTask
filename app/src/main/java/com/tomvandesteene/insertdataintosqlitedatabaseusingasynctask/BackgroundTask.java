package com.tomvandesteene.insertdataintosqlitedatabaseusingasynctask;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Tom Van de Steene on 14/06/2017.
 */

public class BackgroundTask extends AsyncTask<String, Product, String> {

    Context context;
    ProductAdapter productAdapter;
    Activity activity;
    ListView listView;

    public BackgroundTask(Context context) {
        this.context = context;
        activity = (Activity) context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];
        DbOperations dbOperations = new DbOperations(context);
        if (method.equals("add_info")){

            String id = params[1];
            String name = params[2];
            int price = Integer.parseInt(params[3]);
            int quantity = Integer.parseInt(params[4]);
            SQLiteDatabase db = dbOperations.getWritableDatabase();
            dbOperations.addInformations(db, id, name, price, quantity);
            return "One row inserted ...";
        }
        else if (method.equals("get_info")){

            listView = (ListView)activity.findViewById(R.id.display_listview);
            SQLiteDatabase db = dbOperations.getReadableDatabase();
            Cursor cursor = dbOperations.getInformations(db);
            productAdapter = new ProductAdapter(context, R.layout.display_product_row);
            String id, name;
            int price, quantity;
            while (cursor.moveToNext()){

                id = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.ID));
                name = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.NAME));
                price = cursor.getInt(cursor.getColumnIndex(ProductContract.ProductEntry.PRICE));
                quantity = cursor.getInt(cursor.getColumnIndex(ProductContract.ProductEntry.QUANTITY));
                Product product = new Product(id, name, price, quantity);
                publishProgress(product);
            }
            return "get_info";
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Product... values) {
        productAdapter.add(values[0]);

    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("get_info")){
            listView.setAdapter(productAdapter);
        }else {
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }
    }
}
