package com.xhc.test.springmvc.springmvc.service;

import com.xhc.test.springmvc.springmvc.domain.Product;

public interface ProductService {
    
    Product add(Product product);
    Product get(long id);
    
}
