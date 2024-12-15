package service;

import bean.pojo.User;

/**
 * program: nursing-home-management-system
 * ClassName UserService
 * description:
 * author: xhonell
 * create: 2024年12月15日13时42分
 * Version 1.0
 **/
public interface UserService {
    boolean updateAvatar(long roleId, String relativePath);

    User updateUser(User user);
}
