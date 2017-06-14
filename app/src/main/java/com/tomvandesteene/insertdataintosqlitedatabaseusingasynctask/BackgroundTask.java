package com.tomvandesteene.insertdataintosqlitedatabaseusingasynctask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Tom Van de Steene on 14/06/2017.
 */

public class BackgroundTask extends AsyncTask<String, Void, String> {

    Context context;

    public BackgroundTask(Context context) {
        this.context = context;
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
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}
