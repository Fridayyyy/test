package com.example.file.util;

import java.util.Date;

public class DateUtil {
    public static String getCurrentTime(){
        Date date=new Date();
        String stringDate=String.format("%tF %<tT", date);
        return stringDate;
    }
}
