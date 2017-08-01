package com.xhc.test.springmvc.decoupcontroller.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhc.test.springmvc.decoupcontroller.domain.Product;
import com.xhc.test.springmvc.decoupcontroller.form.ProductForm;
import com.xhc.test.springmvc.decoupcontroller.validator.ProductValidator;

public class SaveProductController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ProductForm productForm = new ProductForm();
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));
        
        //validate
        ProductValidator productValidator = new ProductValidator();
        List<String> errors = productValidator.validate(productForm);
        
        if(errors.isEmpty()){
            Product p = new Product();
            p.setName(productForm.getName());
            p.setDescription(productForm.getDescription());
            p.setPrice(Float.parseFloat(productForm.getPrice()));
            
            request.setAttribute("product", p);
            return "/WEB-INF/jsp/ProductDetails.jsp";
        }else {
            request.setAttribute("errors", errors);
            request.setAttribute("form", productForm);
            return "/WEB-INF/jsp/ProductForm.jsp";
        }
    
    }

}
