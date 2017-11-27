package com.xhc.test.springmvc.springmvc.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhc.test.springmvc.springmvc.domain.Login;

@Controller
public class ResourceController {

    private static final Log logger = LogFactory.getLog(ResourceController.class);
    
    @RequestMapping(value = "/login")
    public String login(@ModelAttribute Login login,
            HttpSession session, Model model) {
        model.addAttribute("login", new Login());
        if("pual".equals(login.getUserName()) && "secret".equals(login.getPassword())){
            session.setAttribute("loggedIn", Boolean.TRUE);
            return "Main";
        }else {
            return "LoginForm";
        }
    }
    
    
    @RequestMapping(value = "/resource_download")
    public String downloadResource(HttpSession session, 
            HttpServletRequest request, HttpServletResponse response){
        if(session ==null || session.getAttribute("loggedIn") == null){
            return "LoginForm";
        }
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/data");
        File file = new File(dataDirectory, "secret.pdf");
        if(file.exists()){
            response.reset();
            response.setContentType("application/octet-stream");  //application/pdf  自动下载，application/octet-stream save-as
            response.setHeader("Content-Disposition", "attachment; filename=secret.pdf");
            response.setHeader("Content-Length", String.valueOf(file.length()));
            
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer, 0 , i);
                    i = bis.read(buffer);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                if(bis != null ){
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(fis != null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
    
    
    @RequestMapping(value = "/image_get/{id}")
    public void getImage(@PathVariable String id , 
            HttpServletRequest request, HttpServletResponse response,
            @RequestHeader String referer) {
        if(referer != null){
            String imageDirectory = request.getServletContext().getRealPath("/WEB-INF/image");
            File file = new File(imageDirectory, id+".jpg");
            if(file.exists()){
                response.setContentType("image/jpg");
                byte[] buffer = new byte[1024];
               
                try {
                    try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
                        OutputStream os = response.getOutputStream();
                        int i = bis.read(buffer);
                        while(i != -1){
                            os.write(buffer, 0 , i);
                            i = bis.read(buffer);
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }
        }
    }
}
