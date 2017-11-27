package com.xhc.test.springmvc.ws.service;

/**
 * Created by mymac on 2017/11/27.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello() {
        return "hello world";
    }

    @Override
    public String returnWord(String word) {
        return word;
    }
}
