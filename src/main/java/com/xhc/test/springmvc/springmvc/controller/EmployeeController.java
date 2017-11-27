package com.xhc.test.springmvc.springmvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhc.test.springmvc.springmvc.domain.Employee;

@org.springframework.stereotype.Controller
public class EmployeeController {

    private static final Log logger = LogFactory.getLog(EmployeeController.class);
    
    @RequestMapping(value = "/employee_input")
    public String inputEmployee(Model model) {
        model.addAttribute(new Employee());
        return "EmployeeForm";
    }
    
    @RequestMapping(value = "/employee_save")
    public String saveEmployee(@ModelAttribute Employee employee, 
            BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            String error = "Code:" + fieldError.getCode() + ", field:" + fieldError.getField();
            logger.info(error);
            model.addAttribute("error", error);
            return "EmployeeForm";
        }
        model.addAttribute("employee", employee);
        return "EmployeeDetails";
    }
    
}
