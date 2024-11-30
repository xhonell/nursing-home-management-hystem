package com.gxa.servlet.login;

import com.gxa.common.Write;
import com.gxa.pojo.Role;
import com.gxa.service.LoginService;
import com.gxa.service.impl.LoginServiceImpl;
import com.gxa.utils.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Project:Nursing Home Management System - loginServlet
 * <p>POWER by xhonell on 2024-11-30 11:01
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
@WebServlet("/login")
public class loginServlet extends BaseServlet {
    LoginService loginService = new LoginServiceImpl();

    public  void login(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Role role = loginService.login(username,password);
        if(role != null){
            Write.writeSuccess(response,role);
        }else {
            Write.writeFail(response,"用户名或密码错误");
        }
    }
}
