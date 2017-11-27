package com.xhc.test.springmvc.springmvc.validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xhc.test.springmvc.springmvc.domain.Product;
import com.xhc.test.springmvc.springmvc.form.ProductForm;

/**
 * 当Fotmatter 转换一个字段值后 Spring validator就会介入 
 * @author Administrator
 *
 */
public class ProductValidator implements Validator{

    
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product)target;
        ValidationUtils.rejectIfEmpty(errors, "name", "productname.required");
        ValidationUtils.rejectIfEmpty(errors, "price", "price.required");
        ValidationUtils.rejectIfEmpty(errors, "productionDate", "productiondate.required");
        Float price = product.getPrice();
        if(price != null && price < 0){
            errors.rejectValue("price", "price.negative");
        }
        Date productionDate = product.getProductionDate();
        if(productionDate != null){
            //判断 生产日期是否小于大当前时间
            if(productionDate.after(new Date())){
                System.out.println("salah lagi");
                errors.rejectValue("productionDate", "productiondate.invalid");
            }
        }
    }

    public List<String> validate (ProductForm productForm) {
        List<String> errors = new ArrayList<String>();
        String name = productForm.getName();
        if(name == null || name.trim().isEmpty()) {
            errors.add("Product must have a name");
        }
        String price = productForm.getPrice();
        if(price == null || price.trim().isEmpty()){
            errors.add("Product must have a price");
        }else {
            try {
                Float.parseFloat(price);
            } catch (NumberFormatException e) {
                errors.add("Invalid price value");
            }
        }
        return errors;
    }
}
