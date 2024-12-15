package dao;

import bean.pojo.User;

/**
 * program: nursing-home-management-system
 * ClassName UserDao
 * description:
 * author: xhonell
 * create: 2024年12月15日13时44分
 * Version 1.0
 **/
public interface UserDao {
    int updateAvatar(long roleId, String relativePath);

    int updateUser(Object[] params);

    User selectUserById(long roleId);

    int updatePasswordById(Object[] params);
}
