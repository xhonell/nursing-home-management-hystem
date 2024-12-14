package commons;

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
     * 返回默认的成功信息
     * @param resp
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
        writer.flush();
        writer.close();
    }

    /**
     * 返回m默认成功信息和数据
     * @param resp
     * @param obj
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
        writer.flush();
        writer.close();
    }

    /**
     * 返回成功信息和数据
     * @param resp
     * @param obj
     */
    public static void writeSuccess(HttpServletResponse resp, Object obj, String msg) {
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = JSON.toJSONString(R.success(obj,msg));
        writer.write(jsonString);
        writer.flush();
        writer.close();
    }

    public static void writeFail(HttpServletResponse resp) {
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = JSON.toJSONString(R.failed());
        writer.write(jsonString);
        writer.flush();
        writer.close();
    }

    public static void writeFail(HttpServletResponse resp,String str) {
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = JSON.toJSONString(R.failed(str));
        writer.write(jsonString);
        writer.flush();
        writer.close();
    }
}
