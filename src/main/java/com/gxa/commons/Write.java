package com.gxa.commons;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>Project:test_01 - Write
 * <p>POWER by xhonell on 2024-11-22 19:44
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Write {

    /**
     * 向HttpServletResponse中写入一个默认的成功响应。
     *
     * @param resp HttpServletResponse对象，用于向客户端发送响应。
     */
    public static void writeSuccess(HttpServletResponse resp) {
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = JSON.toJSONString(R.success());
        writer.write(jsonString);
    }

    /**
     * 向HttpServletResponse中写入一个成功的响应。
     *
     * @param resp HttpServletResponse对象，用于向客户端发送响应。
     * @param obj  要写入响应中的数据对象。
     */
    public static void writeSuccess(HttpServletResponse resp, Object obj) {
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = JSON.toJSONString(R.success(obj));
        writer.write(jsonString);
    }

    /**
     * 向HttpServletResponse中写入一个默认的失败响应。
     *
     * @param resp HttpServletResponse对象，用于向客户端发送响应。
     */
    public static void writeFail(HttpServletResponse resp) {
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = JSON.toJSONString(R.failed());
        writer.write(jsonString);
    }

    /**
     * 向HttpServletResponse中写入失败的响应
     *
     * @param resp HttpServletResponse对象
     * @param str  要写入响应中的错误信息
     */
    public static void writeFail(HttpServletResponse resp,String str) {
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = JSON.toJSONString(R.failed(str));
        writer.write(jsonString);
    }
}
