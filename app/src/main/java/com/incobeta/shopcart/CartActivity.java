package com.incobeta.shopcart;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.incobeta.shopcart.models.Clothing;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    //variables
    RecyclerView cartRecyclerView;
    CartAdapter cartAdapter;

    ArrayList<Clothing> clothingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //enable back button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Your Cart");
        }

        //initialize arraylist
        clothingList = new ArrayList<>();

        generateFakeData();

        cartRecyclerView = (RecyclerView) findViewById(R.id.cartRecyclerView);

        //define recycler layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        cartRecyclerView.setLayoutManager(linearLayoutManager);


        cartAdapter = new CartAdapter(clothingList);
        cartRecyclerView.setAdapter(cartAdapter);

    }

    public void onClick(View view) {
        if (view.getId() == R.id.goToCheckoutButton) {
            Snackbar.make(view, "Proceed to Checkout", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void generateFakeData() {
        Clothing cloth1 = new Clothing(R.drawable.lady1, "Sweater", 500.00f);
        clothingList.add(cloth1);

        Clothing cloth2 = new Clothing(R.drawable.lady2, "Blouse", 950.0f);

        clothingList.add(cloth2);

        Clothing cloth3 = new Clothing(R.drawable.lady3, "Stripped", 950.0f);
        clothingList.add(cloth3);
    }


    private class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

        private ArrayList<Clothing> dataSet;

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            CardView cardItem;
            TextView itemNameView;
            ImageView itemIconView;
            TextView itemQuantityView;
            TextView itemPriceView;
            ImageView itemAddView;
            ImageView itemSubtractView;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.cardItem = (CardView) itemView.findViewById(R.id.cartItemCard);
                this.itemNameView = (TextView) itemView.findViewById(R.id.cartItemName);
                this.itemIconView = (ImageView) itemView.findViewById(R.id.cartItemIcon);
                this.itemQuantityView = (TextView) itemView.findViewById(R.id.cartItemQuantity);
                this.itemPriceView = (TextView) itemView.findViewById(R.id.cartItemPrice);
                this.itemAddView = (ImageView) itemView.findViewById(R.id.cartItemQuantityAdd);
                this.itemSubtractView = (ImageView) itemView.findViewById(R.id.cartItemQuantitySubtract);

                cardItem.setOnClickListener(this);
            }


            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        }



        public CartAdapter(ArrayList<Clothing> data) {
            this.dataSet = data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_cart, parent, false);

            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

            TextView itemNameView = holder.itemNameView;
            ImageView itemIconView = holder.itemIconView;
            TextView itemPriceView = holder.itemPriceView;

            itemNameView.setText(dataSet.get(listPosition).getName());
            itemIconView.setImageResource(dataSet.get(listPosition).getImage());
            itemPriceView.setText("KES " + dataSet.get(listPosition).getPrice());

        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }

    }
}
