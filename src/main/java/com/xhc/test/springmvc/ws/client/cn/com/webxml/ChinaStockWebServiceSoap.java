
package com.xhc.test.springmvc.ws.client.cn.com.webxml;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ChinaStockWebServiceSoap", targetNamespace = "http://WebXml.com.cn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ChinaStockWebServiceSoap {


    /**
     * <br /><h3>直接获得中国股票GIF分时走势图（545*300pixel/72dpi）</h3><p>输入参数：theStockCode = 股票代号，如：sh000001； 返回数据：股票GIF分时走势图。</p><br />
     * 
     * @param theStockCode
     */
    @WebMethod(action = "http://WebXml.com.cn/getStockImageByCode")
    @RequestWrapper(localName = "getStockImageByCode", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetStockImageByCode")
    @ResponseWrapper(localName = "getStockImageByCodeResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetStockImageByCodeResponse")
    public void getStockImageByCode(
            @WebParam(name = "theStockCode", targetNamespace = "http://WebXml.com.cn/")
                    String theStockCode);

    /**
     * <br /><h3>获得中国股票GIF分时走势图字节数组</h3><p>输入参数：theStockCode = 股票代号，如：sh000001； 返回数据：股票GIF分时走势图字节数组。<br /><strong>字节流到图片可以参考以下方法</strong>（.NET vb）：<br />HttpContext.Current.Response.Cache.SetCacheability(System.Web.HttpCacheability.NoCache) '不缓存<br />HttpContext.Current.Response.ClearContent()<br />HttpContext.Current.Response.ContentType = "image/Gif"<br />HttpContext.Current.Response.BinaryWrite(Ary) 'Ary 图片字节数组<br />HttpContext.Current.Response.End()</p><br />
     * 
     * @param theStockCode
     * @return
     *     returns byte[]
     */
    @WebMethod(action = "http://WebXml.com.cn/getStockImageByteByCode")
    @WebResult(name = "getStockImageByteByCodeResult", targetNamespace = "http://WebXml.com.cn/")
    @RequestWrapper(localName = "getStockImageByteByCode", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetStockImageByteByCode")
    @ResponseWrapper(localName = "getStockImageByteByCodeResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetStockImageByteByCodeResponse")
    public byte[] getStockImageByteByCode(
            @WebParam(name = "theStockCode", targetNamespace = "http://WebXml.com.cn/")
                    String theStockCode);

    /**
     * <br /><h3>直接获得中国股票GIF日/周/月 K 线图（545*300pixel/72dpi）</h3><p>输入参数：theStockCode = 股票代号，如：sh000001；theType = K 线图类型（D：日[默认]、W：周、M：月），返回数据：股票GIF日 K 线图。</p><br />
     * 
     * @param theStockCode
     * @param theType
     */
    @WebMethod(operationName = "getStockImage_kByCode", action = "http://WebXml.com.cn/getStockImage_kByCode")
    @RequestWrapper(localName = "getStockImage_kByCode", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetStockImageKByCode")
    @ResponseWrapper(localName = "getStockImage_kByCodeResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetStockImageKByCodeResponse")
    public void getStockImageKByCode(
            @WebParam(name = "theStockCode", targetNamespace = "http://WebXml.com.cn/")
                    String theStockCode,
            @WebParam(name = "theType", targetNamespace = "http://WebXml.com.cn/")
                    String theType);

    /**
     * <br /><h3>获得中国股票GIF日/周/月 K 线图字节数组</h3><p>输入参数：theStockCode = 股票代号，如：sh000001；theType = K 线图类型（D：日[默认]、W：周、M：月），返回数据：股票GIF日 K 线图字节数组。</p><br />
     * 
     * @param theStockCode
     * @param theType
     * @return
     *     returns byte[]
     */
    @WebMethod(operationName = "getStockImage_kByteByCode", action = "http://WebXml.com.cn/getStockImage_kByteByCode")
    @WebResult(name = "getStockImage_kByteByCodeResult", targetNamespace = "http://WebXml.com.cn/")
    @RequestWrapper(localName = "getStockImage_kByteByCode", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetStockImageKByteByCode")
    @ResponseWrapper(localName = "getStockImage_kByteByCodeResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetStockImageKByteByCodeResponse")
    public byte[] getStockImageKByteByCode(
            @WebParam(name = "theStockCode", targetNamespace = "http://WebXml.com.cn/")
                    String theStockCode,
            @WebParam(name = "theType", targetNamespace = "http://WebXml.com.cn/")
                    String theType);

    /**
     * <br /><h3>获得中国股票及时行情 String()</h3><p>输入参数：theStockCode = 股票代号，如：sh000001； 返回数据：一个一维字符串数组 String(24)，结构为：String(0)股票代号、String(1)股票名称、String(2)行情时间、String(3)最新价（元）、String(4)昨收盘（元）、String(5)今开盘（元）、String(6)涨跌额（元）、String(7)最低（元）、String(8)最高（元）、String(9)涨跌幅（%）、String(10)成交量（手）、String(11)成交额（万元）、String(12)竞买价（元）、String(13)竞卖价（元）、String(14)委比（%）、String(15)-String(19)买一 - 买五（元）/手、String(20)-String(24)卖一 - 卖五（元）/手。</p><br />
     * 
     * @param theStockCode
     * @return
     *     returns cn.com.webxml.ArrayOfString
     */
    @WebMethod(action = "http://WebXml.com.cn/getStockInfoByCode")
    @WebResult(name = "getStockInfoByCodeResult", targetNamespace = "http://WebXml.com.cn/")
    @RequestWrapper(localName = "getStockInfoByCode", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetStockInfoByCode")
    @ResponseWrapper(localName = "getStockInfoByCodeResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetStockInfoByCodeResponse")
    public ArrayOfString getStockInfoByCode(
            @WebParam(name = "theStockCode", targetNamespace = "http://WebXml.com.cn/")
                    String theStockCode);

}
