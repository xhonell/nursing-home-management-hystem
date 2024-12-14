package commons;


import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * program: nursing-home-management-system
 * ClassName GetWebJsonParamsUtils
 * description:获取前段传递的JSON流格式参数
 * author: xhonell
 * create: 2024年12月13日21时37分
 * Version 1.0
 **/
public class GetJsonParamsUtils {

    /**
     * 将HTTP请求中的JSON数据转换为指定类型的Java对象
     *
     * @param request HTTP请求对象，包含JSON格式的请求体
     * @param clazz   目标Java对象的Class对象
     * @param <T>     目标Java对象的类型
     * @return 转换后的Java对象，如果转换失败则返回null
     * @throws IOException 如果读取请求体时发生IO异常
     */
    public static <T> T receiveJsonToPojo (HttpServletRequest request, Class<T> clazz){
        try (BufferedReader reader = request.getReader()){
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return  JSONObject.parseObject(sb.toString(), clazz);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
