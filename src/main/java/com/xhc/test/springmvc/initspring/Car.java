package com.xhc.test.springmvc.initspring;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {

    private String name;
    private float weight;
    
    @Autowired
    private Animal animal;
    
    public Car() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Car(String name, float weight) {
        super();
        this.name = name;
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "name= "+name+", weight="+weight + ", Animal["+animal+"] in the car";
    }

    
    public void init() {
        System.out.println(this + " 加载完成");
    }
    
    public void destory(){
        System.out.println(this + " destroy...");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    
}
