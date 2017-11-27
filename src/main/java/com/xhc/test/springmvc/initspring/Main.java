package com.xhc.test.springmvc.initspring;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    
    
    public static void main(String[] args) {
        Main main = new Main();
        main.createApplicationContext();
    }

    /**
     * 使用xml配置文件创建bean，定义bean的方法 使用 name 、 id 标识，如果没有使用全类名标识
     * 可以提供 factory-bean和factory-method  提供创建bean的类和创建bean的方法
     * 可以使用init-method \ destory-method 在创建bean后和容器销毁后时执行方法
     * 
     */
    private void createApplicationContext() {
        String classpath = Main.class.getResource("/").getPath();  
        String path = "com/xhc/test/springmvc/initspring/";
        
        
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{path+"spring-cfg1.xml", path+"spring-cfg2.xml"});
        
//        AbstractApplicationContext context = new FileSystemXmlApplicationContext(
//                new String[]{classpath+path+"spring-cfgall.xml"}); 
                
        
        
        Car car = (Car)context.getBean("car", Car.class);
        System.out.println("Car : " + car);
        
        Car car2 = (Car)context.getBean("com.xhc.test.springmvc.initspring.Car", Car.class);
        System.out.println("Car2 : " + car2);
        
        
        Animal animal = (Animal)context.getBean("animal", Animal.class);
        System.out.println("Animal : "+animal);
        
        Bomb bomb = (Bomb)context.getBean("bomb", Bomb.class);
        System.out.println("Bomb : "+ bomb);
        
        Plane plane = (Plane)context.getBean("plane", Plane.class);
        System.out.println("Plane : " + plane);
        
        
        Plane plane2 = (Plane)context.getBean("plane2", Plane.class);
        System.out.println("Plane2 : " +plane2);

        ExecutorService newCachedThreadPool = (ExecutorService)context.getBean("executorService", ExecutorService.class);
        newCachedThreadPool.submit(new Runnable() {
            
            @Override
            public void run() {
                System.out.println("do work...");
            }
        });
        
        
        context.close();
    }
    
    
}
