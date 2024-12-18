package service;

import bean.dto.login.ForgetPasswordDto;
import bean.dto.login.LoginDto;
import bean.pojo.Router;
import bean.pojo.User;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName LoginService
 * description:
 * author: xhonell
 * create: 2024年12月13日21时55分
 * Version 1.0
 **/
public interface LoginService {

    User checkLogin(LoginDto loginDto);

    List<Router> getRouter(String roles);

    boolean queryEmail(String email);

    boolean resetPassword(ForgetPasswordDto forgetPasswordDto);
}
