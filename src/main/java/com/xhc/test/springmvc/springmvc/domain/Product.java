package com.xhc.test.springmvc.springmvc.domain;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 7432240308562625521L;

    private long id;
    private String name;
    private String description;
    private float price;
    
    
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Product(String name, String description, float price) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
    }


    
    @Override
    public String toString() {
        return "Product is name: "+name+", description: "+description+", price: "+price ;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
}
