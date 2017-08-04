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
    public String inputProduct() {
        logger.info("inputProduct called");
        return "ProductForm";
    }
    
    
    @RequestMapping(value = "/product_save", method=RequestMethod.POST)
    public String saveProduct(ProductForm productForm, RedirectAttributes redirectAttributes, HttpServletRequest request ) {
        logger.info("saveProduct called");
        
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        Product p = new Product();
        p.setName(productForm.getName());
        p.setDescription(productForm.getDescription());
        try {
            p.setPrice(Float.parseFloat(productForm.getPrice()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Product savedP = productService.add(p);
        redirectAttributes.addFlashAttribute("message", "The product was successfully added.");
        return "redirect:/product_view/" + savedP.getId();
    }
    
    @RequestMapping(value = "/product_view/{id}")
    public String viewProduct(@PathVariable Long id, Model model, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        Product product = productService.get(id);
        model.addAttribute("product", product);
        return "ProductDetails";
    }
}
