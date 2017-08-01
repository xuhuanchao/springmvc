package com.xhc.test.springmvc.initspring;

import java.util.HashMap;
import java.util.Map;

public class PlaneFactory {

    private Map<String, Plane> map = new HashMap<String, Plane>();
    
    
    public PlaneFactory() {
        super();
        Bomb bomb = new Bomb();
        bomb.setName("飞毛腿");
        bomb.setDamage(100.3f);
        Plane plane = new Plane("歼-8", 300.55f, bomb);
        map.put("歼-8", plane);
        
        bomb = new Bomb();
        bomb.setName("爱国者");
        bomb.setDamage(120.1f);
        plane = new Plane("歼-20", 300.55f, bomb);
        map.put("歼-20", plane);
        
        
        
    }



    public Plane createPlane(String name){
        return map.get(name);
    }
    
}
