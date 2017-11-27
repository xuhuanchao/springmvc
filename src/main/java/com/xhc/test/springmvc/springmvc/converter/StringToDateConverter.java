package com.xhc.test.springmvc.springmvc.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {
    private String datePattern;
    
    public StringToDateConverter(String datePattern){
        this.datePattern = datePattern;
        System.out.println("instantiating ... converter with pattern: " + datePattern);
    }

    @Override
    public Date convert(String source) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
            sdf.setLenient(false);
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("invalid date format. Please use this pattern\"" +datePattern+ "\"");
        }
    }
    
    
}
