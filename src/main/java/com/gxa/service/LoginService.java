package com.gxa.service;

import com.gxa.pojo.Role;

/**
 * <p>Project:Nursing Home Management System - LoginService
 * <p>POWER by xhonell on 2024-11-30 11:05
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public interface LoginService {

    Role login(String username, String password);
}
