package com.xhc.test.springmvc.initspring;

public class Bomb {

    private String name;
    private float damage;
    
    
    @Override
    public String toString() {
        return "name= "+name+", damage="+damage;
    }
    
    public static Bomb getInstance(){
        Bomb b = new Bomb();
        b.name="原子弹";
        b.damage=9999.99f;
        return b;
    }
    
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getDamage() {
        return damage;
    }
    public void setDamage(float damage) {
        this.damage = damage;
    }
    
    
    
}
