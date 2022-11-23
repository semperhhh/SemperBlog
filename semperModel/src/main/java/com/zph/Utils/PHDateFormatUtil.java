package com.zph.Utils;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PHDateFormatUtil {

    public static long toTimeStamp() {
        return new Date().getTime();
    }

    /**
     * 时间戳转时间格式
     * @param timeStamp
     * @param format
     * @return
     */
    public static String dateFormat(String timeStamp, String format) {
        long l = Long.parseLong(timeStamp);
        Date date = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static String dateFormat(long timeStamp, String format) {
        Date date = new Date(timeStamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static String dateFormat(String timeStamp) {
        long l = Long.parseLong(timeStamp);
        Date date = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    public static String dateFormat(long timeStamp) {
        Date date = new Date(timeStamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
