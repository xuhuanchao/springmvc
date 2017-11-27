package com.xhc.test.springmvc.springmvc.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {

    private String datePattern;
    private SimpleDateFormat dateFormat;
    
    public DateFormatter(String datePattern) {
        super();
        this.datePattern = datePattern;
        this.dateFormat = new SimpleDateFormat(datePattern);
        dateFormat.setLenient(false); //比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        try {
            dateFormat.setLenient(false);
            return dateFormat.parse(text);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("invalid date format. Please use this pattern\"" +datePattern+ "\"");
        }
    }

    @Override
    public String print(Date object, Locale locale) {
        return dateFormat.format(object);
    }

    
}
