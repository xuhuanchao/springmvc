package com.xhc.test.springmvc.springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xhc.test.springmvc.springmvc.domain.Product;
import com.xhc.test.springmvc.springmvc.form.ProductForm;
import com.xhc.test.springmvc.springmvc.service.ProductService;
import com.xhc.test.springmvc.springmvc.validator.ProductValidator;

@Controller
public class ProductController {

    private static final Log logger = LogFactory.getLog(ProductController.class);
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value = "/product_input")
    public String inputProduct(@ModelAttribute Product product) {
        logger.info("inputProduct called");
        return "ProductForm";
    }
    
    
    @RequestMapping(value = "/product_save", method=RequestMethod.POST)
    public String saveProduct(Product product, Model model, 
            BindingResult bindingResult, HttpServletRequest request ) throws Exception {
        logger.info("saveProduct called");
        
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        ProductValidator pv = new ProductValidator();
        pv.validate(product, bindingResult);
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            logger.info("Code:" + fieldError.getCode() + " , field:" + fieldError.getField());
            return "ProductForm";
        }
        Product savedP = productService.add(product);
        return "ProductDetails";
    }
    
    @RequestMapping(value = "/product_view/{id}")
    public String viewProduct(@PathVariable Long id, Model model, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        Product product = productService.get(id);
        model.addAttribute("product", product);
        return "ProductDetails";
    }
}
