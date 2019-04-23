package com.ljb.mvp.plugin.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getCurDate() {
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }
}
