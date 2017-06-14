package com.tomvandesteene.insertdataintosqlitedatabaseusingasynctask;

/**
 * Created by Tom Van de Steene on 13/06/2017.
 */

public final class ProductContract {

    public ProductContract() {
    }

    public static abstract class ProductEntry{

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String QUANTITY = "quantity";
        public static final String PRICE = "price";
        public static final String TABLE_NAME = "product_table";
    }
}
