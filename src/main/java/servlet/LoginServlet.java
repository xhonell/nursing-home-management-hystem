package servlet;

import bean.dto.LoginDto;
import bean.pojo.Router;
import bean.pojo.User;
import bean.vo.LoginVo;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName LoginServlet
 * description:登录接口
 * author: xhonell
 * create: 2024年12月13日21时28分
 * Version 1.0
 **/
@WebServlet("/user/*")
public class LoginServlet extends BaseServlet {
    LoginService loginService = new LoginServiceImpl();
    /**
     * 用户登录处理
     *
     * @param req  HttpServletRequest对象，包含客户端发送的HTTP请求信息
     * @param resp HttpServletResponse对象，用于向客户端发送HTTP响应
     */
    public void login(HttpServletRequest req, HttpServletResponse resp){
        LoginDto loginDto = GetJsonParamsUtils.receiveJsonToPojo(req, LoginDto.class);
        User user = loginService.checkLogin(loginDto);
        String sessionId = req.getSession().getId();
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(sessionId);

        if (user != null){
            /*将token和用户信息保存*/
            req.getSession().setAttribute("token", sessionId);
            req.getSession().setAttribute("user", user);

            Write.writeSuccess(resp, loginVo);
        }else{
            String msg = "账号密码错误";
            Write.writeSuccess(resp,null,msg);
        }
    }

    /**
     * 处理用户信息请求
     *
     * @param req  HttpServletRequest对象，包含客户端发送的HTTP请求信息
     * @param resp HttpServletResponse对象，用于向客户端发送HTTP响应
     */
    public void info(HttpServletRequest req, HttpServletResponse resp){
        String token = req.getParameter("token");
        String sessionToken = String.valueOf(req.getSession().getAttribute("token"));
        if (sessionToken.equals(token)){
            Object user = req.getSession().getAttribute("user");
            Write.writeSuccess(resp, user);
        } else {
            Write.writeSuccess(resp,null, "token失效");
        }
    }

    /**
     * 用户登出处理
     *
     * @param req  HttpServletRequest对象，包含客户端发送的HTTP请求信息
     * @param resp HttpServletResponse对象，用于向客户端发送HTTP响应
     */
    public void logout(HttpServletRequest req, HttpServletResponse resp){
        req.getSession().invalidate();
        Write.writeSuccess(resp);
    }

    /**
     * 处理路由请求
     *
     * @param req  HttpServletRequest对象，包含请求信息
     * @param resp HttpServletResponse对象，用于向客户端发送响应
     */
    public void router(HttpServletRequest req, HttpServletResponse resp){
        String roles = req.getParameter("roles");
        List<Router> routerList = loginService.getRouter(roles);
        if (routerList != null){
            Write.writeSuccess(resp, routerList);
        } else {
            Write.writeSuccess(resp, null, "角色权限不足，请联系管理员！");
        }
    }
}
