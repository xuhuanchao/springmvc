
package com.xhc.test.springmvc.ws.client.cn.com.webxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getStockInfoByCodeResult" type="{http://WebXml.com.cn/}ArrayOfString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getStockInfoByCodeResult"
})
@XmlRootElement(name = "getStockInfoByCodeResponse")
public class GetStockInfoByCodeResponse {

    protected ArrayOfString getStockInfoByCodeResult;

    /**
     * 获取getStockInfoByCodeResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getGetStockInfoByCodeResult() {
        return getStockInfoByCodeResult;
    }

    /**
     * 设置getStockInfoByCodeResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setGetStockInfoByCodeResult(ArrayOfString value) {
        this.getStockInfoByCodeResult = value;
    }

}
