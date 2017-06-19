package com.tomvandesteene.insertdataintosqlitedatabaseusingasynctask;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom Van de Steene on 14/06/2017.
 */

public class ProductAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public ProductAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }


    public void add(Product object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        ProductHolder productHolder;

        if (row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.display_product_row, parent, false);
            productHolder = new ProductHolder();
            productHolder.tx_id = (TextView) row.findViewById(R.id.t_id);
            productHolder.tx_name = (TextView) row.findViewById(R.id.t_name);
            productHolder.tx_price = (TextView) row.findViewById(R.id.t_price);
            productHolder.tx_quantity = (TextView) row.findViewById(R.id.t_quantity);
            row.setTag(productHolder);
        }
        else{
            productHolder = (ProductHolder) row.getTag();
        }
        Product product = (Product) getItem(position);
        productHolder.tx_id.setText(product.getId().toString());
        productHolder.tx_name.setText(product.getName().toString());
        productHolder.tx_price.setText(Integer.toString(product.getPrice()));
        productHolder.tx_quantity.setText(Integer.toString(product.getQuantity()));

        return row;
    }

    static class ProductHolder{
        TextView tx_id, tx_name, tx_price, tx_quantity;
    }
}
