package com.gxa.utils;

/**
 * <p>Project:Nursing Home Management System - UrlUtils
 * <p>POWER by xhonell on 2024-11-30 10:38
 * <p>description：获取路径尾部
 * <p>idea：
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class UrlUtils {
    /**
     * 获取给定URL的路径部分。
     *
     * @param url URL字符串，表示要处理的URL。
     * @return 返回URL的路径部分，如果URL为空或无效则返回null。
     */
    public static String getUrl(String url) {
        /*检查路径是否为空*/
        if (url == null || url.trim().isEmpty())
            return null;
        /*检查路径是否为正斜杠结尾*/
        int index = url.lastIndexOf("/");
        /*检查路径是否为反斜杠结尾的*/
        if (index == -1){
            index = url.lastIndexOf("\\");
        }
        /*返回文件的点路径*/
        return url.substring(index + 1);
    }

}
