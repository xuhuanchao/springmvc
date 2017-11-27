package com.xhc.test.springmvc.springmvc.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.xhc.test.springmvc.springmvc.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

    private Map<Long, Product> products = new HashMap<Long, Product>();
    
    private AtomicLong generator = new AtomicLong();
    
    public ProductServiceImpl() {
        super();
        Product p = new Product("JX1 Power Drill", "Powerful hand drill, made to perfection", 129.99f);
        add(p);
    }
    
    @Override
    public Product add(Product product) {
        long newId = generator.incrementAndGet();
        product.setId(newId);
        products.put(newId, product);
        return product;
    }

    @Override
    public Product get(long id) {
        
        return products.get(id);
    }

}
