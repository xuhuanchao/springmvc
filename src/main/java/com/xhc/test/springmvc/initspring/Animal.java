package com.xhc.test.springmvc.initspring;

public class Animal {

    private String name;
    private String color;
   
    
    
    public Animal(String name, String color) {
        super();
        this.name = name;
        this.color = color;
    }
    
    
    @Override
    public String toString() {
        return "name= "+name+", color="+color;
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
   
}
