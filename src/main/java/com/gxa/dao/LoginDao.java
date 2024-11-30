package com.gxa.dao;

import com.gxa.pojo.Role;
import com.gxa.utils.DataSourceUtil;

/**
 * <p>Project:Nursing Home Management System - LoginDao
 * <p>POWER by xhonell on 2024-11-30 11:28
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class LoginDao {
    public Role login(String username, String password) {
        String sql = "select * from role where rolePhone=? and rolePassword=?";
        return DataSourceUtil.queryToBeanHandler(sql, Role.class, username, password);

    }
}
