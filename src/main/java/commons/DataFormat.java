package commons;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * program: nursing-home-management-system
 * ClassName DataFormat
 * description:
 * author: xhonell
 * create: 2024年12月16日16时33分
 * Version 1.0
 **/
public class DataFormat {
    /**
     * 默认格式设置字段
     */
    private static final String PATTERN_DATE = "yyyy-MM-dd";
    private static final String PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    private static final String PATTERN_DATE_CN = "yyyy年MM月dd日";
    private static final String PATTERN_DATE_TIME_CN = "yyyy年MM月dd日 HH:mm:ss";


    /**
     * 将给定的时间戳格式化为指定的日期格式
     *
     * @param timestamp 时间戳，需要是Long类型
     * @param pattern   日期格式，如"yyyy-MM-dd HH:mm:ss"
     * @return 格式化后的日期字符串
     */
    public static String formatDate(Object timestamp, String pattern) {
        if (! (timestamp instanceof Long)) {
            return "";
        }else {
            /*将时间戳转化为日期格式*/
            Date date = new Date((Long)timestamp * 1000);
            /*将时间戳转化为指定格式*/
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            /*获取转化后的时间*/
            return sdf.format(date);
        }
    }
}
