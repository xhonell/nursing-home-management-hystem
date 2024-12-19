package servlet;

import bean.dto.login.ForgetPasswordDto;
import bean.dto.login.LoginDto;
import bean.pojo.Router;
import bean.pojo.User;
import bean.vo.LoginVo;
import commons.BaseServlet;
import commons.EmailUtils;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Random;

/**
 * program: nursing-home-management-system
 * ClassName LoginServlet
 * description:登录接口
 * author: xhonell
 * create: 2024年12月13日21时28分
 * Version 1.0
 **/
@WebServlet("/login/*")
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
            Write.writeFail(resp,msg);
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
            Write.writeFail(resp,"登录过期，请重新登录！");
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
            Write.writeFail(resp,  "角色权限不足，请联系管理员！");
        }
    }

    /**
     * 发送验证码到指定邮箱
     *
     * @param req  HttpServletRequest对象，用于接收客户端的请求
     * @param resp HttpServletResponse对象，用于向客户端返回响应
     *
     * 此方法接收客户端发送的HTTP请求，从请求中获取名为"email"的参数，该参数表示要发送验证码的邮箱地址。
     * 首先，通过调用loginService的queryEmail方法验证邮箱是否存在。
     * 如果邮箱不存在，则通过Write.writeFail方法向客户端返回"邮箱不存在"的响应。
     * 如果邮箱存在，则生成一个6位数的随机验证码，并将该验证码存储在Session中，同时调用EmailUtils的sendAuthCodeEmail方法将验证码发送到指定的邮箱。
     * 最后，通过Write.writeSuccess方法向客户端返回"验证码已发送，请注意查收！"的响应，但响应体中不包含具体的数据。
     */
    public void sendCode(HttpServletRequest req, HttpServletResponse resp){
        String email = req.getParameter("email");
        // 验证邮箱是否存在
        boolean isSuccess = loginService.queryEmail(email);
        if (!isSuccess){
            Write.writeFail(resp, "邮箱不存在");
        }
        Random random = new Random();
        Integer randomNumber = 100000 + random.nextInt(900000);
        EmailUtils.sendAuthCodeEmail(email,"悦年康居养老院",randomNumber.toString());
        req.getSession().setAttribute("code", randomNumber.toString());
        Write.writeSuccess(resp,null, "验证码已发送，请注意查收！");
    }

    /**
     * 重置密码
     *
     * @param req   HttpServletRequest 对象，包含请求信息
     * @param resp  HttpServletResponse 对象，用于返回响应信息
     */
    public void reset(HttpServletRequest req, HttpServletResponse resp){
        ForgetPasswordDto forgetPasswordDto = GetJsonParamsUtils.receiveJsonToPojo(req, ForgetPasswordDto.class);
        Integer vCode = forgetPasswordDto.getVCode();
        Integer code = Integer.valueOf(req.getSession().getAttribute("code").toString());
        if (!vCode.equals(code) )
            Write.writeFail(resp, "验证码错误");
        boolean isSuccess = loginService.resetPassword(forgetPasswordDto);
        if (!isSuccess){
            Write.writeFail(resp, "重置密码失败");
        }  else {
            Write.writeSuccess(resp,null, "重置密码成功");
        }

    }

}
