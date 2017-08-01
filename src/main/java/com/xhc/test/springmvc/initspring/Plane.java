package com.xhc.test.springmvc.initspring;

public class Plane {

    private String name;
    private float length;
    private Bomb bomb ;

    public Plane(String name, float length, Bomb bomb) {
        super();
        this.name = name;
        this.length = length;
        this.bomb = bomb;
    }
    
    
    
    
    @Override
    public String toString() {
        return "name= "+name+", length="+length + ", bomb["+bomb+"]";
    }




    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }
    public Bomb getBomb() {
        return bomb;
    }
    public void setBomb(Bomb bomb) {
        this.bomb = bomb;
    }
    
    
}
