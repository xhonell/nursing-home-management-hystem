package com.gxa.service.impl;

import com.gxa.dao.LoginDao;
import com.gxa.pojo.Role;
import com.gxa.service.LoginService;

/**
 * <p>Project:Nursing Home Management System - LoginServiceImpl
 * <p>POWER by xhonell on 2024-11-30 11:07
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class LoginServiceImpl implements LoginService {
    LoginDao loginDao = new LoginDao();
    @Override
    public Role login(String username, String password) {
        return loginDao.login(username, password);
    }
}
