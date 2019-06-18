package com.wang.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * 日期转字符串
     * @param date
     * @param patt
     * @return
     */
    public static String DateToString(Date date,String patt) {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        return sdf.format(date);
    }

    /**
     * 字符串转日期
     * @param str
     * @param patt
     * @return
     */
    public static Date ToStringDate(String str,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        return sdf.parse(str);
    }
}
