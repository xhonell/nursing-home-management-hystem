package dao;

import bean.pojo.Router;
import bean.pojo.User;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName checkLoginDao
 * description:
 * author: xhonell
 * create: 2024年12月13日21时58分
 * Version 1.0
 **/
public interface LoginDao {
    User checkLogin(Object[] params);

    List<Router> getFirstRouter(String roles);

    List<Router> getChildrenRouter(long pageId, String roles);
}
