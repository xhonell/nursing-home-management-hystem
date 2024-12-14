package dao.impl;

import bean.pojo.Router;
import bean.pojo.User;
import commons.DataSourceUtil;
import dao.LoginDao;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName checkLoginDaoImmpl
 * description:
 * author: xhonell
 * create: 2024年12月13日21时59分
 * Version 1.0
 **/
public class LoginDaoImpl implements LoginDao {
    /**
     * 检查用户登录信息
     *
     * @param params 包含用户登录信息的数组，其中第一个元素为用户名，第二个元素为密码
     * @return 登录成功的用户对象，若登录失败则返回null
     */
    @Override
    public User checkLogin(Object[] params) {
        String sql = "select * from user where rolePhone = ? and rolePassword = ?";
        return DataSourceUtil.queryToBeanHandler(sql, User.class, params);
    }

    /**
     * 根据角色获取顶级路由列表
     *
     * @param roles 角色名称
     * @return 顶级路由列表
     */
    @Override
    public List<Router> getFirstRouter(String roles) {
        String sql = "select page.* from page left join permission on page.pageId = permission.pageId" +
                " left join roles on permission.roleId = roles.roleId" +
                " left join user on roles.rolePrivileges = user.rolePrivileges" +
                " where page.pageParentId is null and roles.rolePrivileges = ?";
        return DataSourceUtil.queryToBeanListHandler(sql, Router.class, roles);
    }

    /**
     * 根据页面ID和角色获取子路由列表
     *
     * @param pageId 页面ID
     * @param roles 角色名称
     * @return 子路由列表
     */
    @Override
    public List<Router> getChildrenRouter(long pageId, String roles) {
        String sql = "select page.* from page left join permission on page.pageId = permission.pageId" +
                " left join roles on permission.roleId = roles.roleId" +
                " left join user on roles.rolePrivileges = user.rolePrivileges" +
                " where page.pageParentId = ? and roles.rolePrivileges = ?";
        return DataSourceUtil.queryToBeanListHandler(sql, Router.class, pageId, roles);
    }
}
