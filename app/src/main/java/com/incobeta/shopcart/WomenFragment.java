package com.incobeta.shopcart;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.incobeta.shopcart.models.Clothing;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class WomenFragment extends Fragment {

    //variables
    RecyclerView womenRecyclerView;
    WomenAdapter womenAdapter;

    ArrayList<Clothing> clothingList;

    private int NO_OF_COLUMNS = 2;

    public WomenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_women, container, false);

        //initialize arraylist
        clothingList = new ArrayList<>();

        generateFakeData();

        womenRecyclerView = (RecyclerView) view.findViewById(R.id.womenRecyclerView);

        //define recycler layout manager
        womenRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), NO_OF_COLUMNS));

        womenAdapter = new WomenAdapter(clothingList);
        womenRecyclerView.setAdapter(womenAdapter);

        return view;
    }

    private void generateFakeData() {
        Clothing cloth1 = new Clothing(R.drawable.lady1, "Sweater", 500.00f);
        clothingList.add(cloth1);

        Clothing cloth2 = new Clothing(R.drawable.lady2, "Blouse", 950.0f);

        clothingList.add(cloth2);

        Clothing cloth3 = new Clothing(R.drawable.lady3, "Stripped", 950.0f);
        clothingList.add(cloth3);
        clothingList.add(cloth1);

        clothingList.add(cloth2);

        clothingList.add(cloth3);
    }

    private class WomenAdapter extends RecyclerView.Adapter<WomenAdapter.MyViewHolder> {

        private ArrayList<Clothing> dataSet;

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            CardView cardItem;
            TextView itemNameView;
            ImageView itemIconView;
            ImageView addItemView;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.cardItem = (CardView) itemView.findViewById(R.id.shopItemCard);
                this.itemNameView = (TextView) itemView.findViewById(R.id.shopItemName);
                this.itemIconView = (ImageView) itemView.findViewById(R.id.shopItemIcon);
                this.addItemView = itemView.findViewById(R.id.addItemToCart);

                addItemView.setOnClickListener(this);

                cardItem.setOnClickListener(this);
            }


            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.addItemToCart) {
                    Toast.makeText(getActivity(), "Item has been added to the cart", Toast.LENGTH_SHORT).show();
                }
                else if(v.getId() == R.id.shopItemCard) {
                    Toast.makeText(getActivity(), "Clicked!", Toast.LENGTH_SHORT).show();

                    Intent productItent = new Intent(getActivity(), ProductDetailActivity.class);
                    startActivity(productItent);
                }
            }
        }



        public WomenAdapter(ArrayList<Clothing> data) {
            this.dataSet = data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_clothing, parent, false);

            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

            TextView itemNameView = holder.itemNameView;
            ImageView itemIconView = holder.itemIconView;


            itemNameView.setText(dataSet.get(listPosition).getName());
            itemIconView.setImageResource(dataSet.get(listPosition).getImage());

        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }

    }

}
