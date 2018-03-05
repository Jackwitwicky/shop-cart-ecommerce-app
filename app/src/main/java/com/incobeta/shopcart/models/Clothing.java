package com.incobeta.shopcart.models;

/**
 * Created by witwicky on 03/03/18.
 */

public class Clothing {

    //instance variables
    private int image;
    private String name;
    private float price;

    //empty constructor
    public Clothing() {}

    //default constructor
    public Clothing(int image, String name, float price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
