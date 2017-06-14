package com.tomvandesteene.insertdataintosqlitedatabaseusingasynctask;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Tom Van de Steene on 13/06/2017.
 */

public class DbOperations extends SQLiteOpenHelper {

    private static final int DB_VERSON = 1;
    private static final String DB_NAME = "product_info.db";

    private static final String CREATE_QUERY = "create table " + ProductContract.ProductEntry.TABLE_NAME +
            "("+ ProductContract.ProductEntry.ID + " text,"+ ProductContract.ProductEntry.NAME+" text,"+
            ProductContract.ProductEntry.PRICE+ " integer,"+ ProductContract.ProductEntry.QUANTITY+ " integer);";


    public DbOperations(Context context) {
        super(context, DB_NAME, null, DB_VERSON);
        Log.d("Database operations", "Database created ...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created ...");
    }

    public void addInformations(SQLiteDatabase db, String id, String name, int price, int quantity){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ProductContract.ProductEntry.ID, id);
        contentValues.put(ProductContract.ProductEntry.NAME, name);
        contentValues.put(ProductContract.ProductEntry.PRICE, price);
        contentValues.put(ProductContract.ProductEntry.QUANTITY, quantity);
        db.insert(ProductContract.ProductEntry.TABLE_NAME, null, contentValues);
        Log.d("Database operations", "One row inserted ...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
