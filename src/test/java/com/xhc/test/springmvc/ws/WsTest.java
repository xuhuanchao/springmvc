package com.xhc.test.springmvc.ws;

import com.xhc.test.springmvc.ws.client.cn.com.webxml.ArrayOfString;
import com.xhc.test.springmvc.ws.client.cn.com.webxml.ChinaStockWebServiceSoap;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by mymac on 2017/11/27.
 */
//@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
//@ContextConfiguration
//        ({"/app*.xml"})
public class WsTest {

    public static void test(){
        ApplicationContext ctx = new FileSystemXmlApplicationContext( "classpath:applicationContext.xml");
        //从Spring容器中取出portType
        ChinaStockWebServiceSoap stockWs = (ChinaStockWebServiceSoap) ctx.getBean("chinaStockWebService");

        //调用portType方法
        ArrayOfString aos = stockWs.getStockInfoByCode("300385");
        List<String> list = aos.getString();

        for(String s : list){
            System.out.println(s);
        }


    }


    public static void main(String[] args) {
        test();
    }
}
