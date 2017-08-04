package com.xhc.test.springmvc.springmvc.controller;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;

public interface Controller {

    String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
