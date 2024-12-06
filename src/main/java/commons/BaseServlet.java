package commons;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>Project:Nursing Home Management System - BaseServlet
 * <p>POWER by xhonell on 2024-11-30 10:33
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)  {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json; charset=UTF-8");
            /*获取当前对象的字节码*/
            Class<? extends BaseServlet> aClass = this.getClass();
            /*获取请求的url*/
            String requestURI = req.getRequestURI();
            /*获取路径后缀*/
            String urlMethod = UrlUtils.getUrl(requestURI);
            /*获取方法并动态调用方法*/
            Method method = aClass.getMethod(urlMethod, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
