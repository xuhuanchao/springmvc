package com.xhc.test.springmvc.springmvc.formatter;


import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class FloatFormatter implements Formatter<Float>{

    @Override
    public Float parse(String text, Locale locale) throws ParseException {
        try {
            return Float.parseFloat(text);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("金额：" + text+" 不能转为FLoat");
        }
    }

    @Override
    public String print(Float object, Locale locale) {
        return object != null ? object.toString() : "0.0 ";
    }

    
}
