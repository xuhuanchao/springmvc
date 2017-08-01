package com.xhc.test.springmvc.decoupcontroller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhc.test.springmvc.decoupcontroller.controller.InputProductController;
import com.xhc.test.springmvc.decoupcontroller.controller.SaveProductController;

public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = -8120265658433785231L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
    
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String uri = request.getRequestURI();
        
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex+1);
        
        String dispatchUrl = null;
        if(action.equals("product_input.action")){
            InputProductController controller = new InputProductController();
            dispatchUrl = controller.handleRequest(request, response);
        }else if (action.equals("product_save.action")){
            SaveProductController spc = new SaveProductController();
            dispatchUrl = spc.handleRequest(request, response);
        }
        
        if(dispatchUrl != null){
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
        
    }
    
}
