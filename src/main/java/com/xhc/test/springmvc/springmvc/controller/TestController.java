package com.xhc.test.springmvc.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.xhc.test.springmvc.springmvc.domain.Product;


/**
 * 通过springmvc 可以访问WEB-INF下的jsp页面
 * @RequestMapping  value 设定处理uri ， method：设定请求方式，默认全部 
 * 
 * 
 *  在处理请求方法中可以出现的参数：
    javax.servlet.ServletRequest
    javax.servlet.http.HttpServletRequest
    javax.servlet.ServletResponse 或
    javax.servlet.http.HttpServletResponse
    javax.servlet.http.HttpSession 
    org.springframework.web.context.request.WebRequest  或
    org.springframework.web.context.request.NativeWebRequest
    java.util.Locale
    java.io.InputStream /   java.io.Reader
    java.io.OutputStream /  java.io.Writer
    java.security.Principal
    HttpEntity<?>
    java.util.Map 或    org.springframework.ui.Model
    org.springframework.web.servlet.mvc.support.RedirectAttributes 或     org.springframework.validation.Errors
        命令或表单对象
    org.springframework.web.bind.support.SessionStatus 
    org.springframework.web.util.UriComponentsBuilder
    @PathVariable , @MatrixVariable
    @RequestParam , @RequestHeader , @RequestBody , @RequestPart   
    
    请求方法可以返回的对象：
    ModelAndView
    Model
    Map包含模型的属性
    View
    代表逻辑视图名的String
    void
    提供对servlet的访问，以响应HTTP头和内容HttpEntity或ResponseEntity对象
    Callable
    DeferredResult
    其他任意类型，Spring将其视作输出给View的对象模型
     
   @ModelAttribute 
     
 * @author xhc
 *
 */
@org.springframework.stereotype.Controller
public class TestController {

    private static final Log logger = LogFactory.getLog(TestController.class);
    
    @RequestMapping(value="/test", method={RequestMethod.POST , RequestMethod.GET})
    public String test (HttpServletRequest request, HttpServletResponse response, String param) {
        request.setAttribute("param", param + "_test");
        return "Test";
    }

    @ModelAttribute
    public Product addProduct1 (String param) {
        Product p = new Product(param ==null? "默认产品1" : param, "return Product", 199.9f);
        logger.info("addProduct1 run");
        return p;
    }
    
    @ModelAttribute
    public void addProduct2(Model model) {
        Product p = new Product("默认产品2", "return void", 199.9f);
        Map m = new HashMap();
        m.put("default2", p);
        model.addAllAttributes(m);
        logger.info("addProduct2 run");
    }
    
    /**
     * param 会自动保存入Model
     * @param param
     * @return
     */
    @RequestMapping(value = "/test1")
    public String test1 (@ModelAttribute("product2")Product p){
        return "Test";
    }
    
    
    
}
