package dao.impl.login;

import bean.pojo.Router;
import bean.pojo.User;
import commons.DataSourceUtil;
import dao.login.LoginDao;

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
        String sql = "select distinct page.* from page left join permission on page.pageId = permission.pageId" +
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
        String sql = "select distinct page.* from page left join permission on page.pageId = permission.pageId" +
                " left join roles on permission.roleId = roles.roleId" +
                " left join user on roles.rolePrivileges = user.rolePrivileges" +
                " where page.pageParentId = ? and roles.rolePrivileges = ?";
        return DataSourceUtil.queryToBeanListHandler(sql, Router.class, pageId, roles);
    }

    /**
     * 根据邮箱查询用户信息
     *
     * @param email 用户的邮箱地址
     * @return 查询到的用户对象，如果未找到则返回null
     *
     * 通过执行SQL查询语句，从"user"表中查找与指定邮箱地址匹配的用户记录。
     * 如果找到匹配的记录，则将该记录转换为User对象并返回；否则返回null。
     * 使用DataSourceUtil的queryToBeanHandler方法处理查询结果，将结果集的第一行数据映射到User对象中。
     */
    @Override
    public User queryEmail(String email) {
        String sql = "select * from user where roleEmail = ?";
        return DataSourceUtil.queryToBeanHandler(sql, User.class, email);
    }

    /**
     * 重置用户密码
     *
     * @param params 参数数组，包含新密码和用户的邮箱地址
     * @return 影响的行数，成功更新则返回1，否则返回0
     *
     * 通过执行SQL更新语句，将指定邮箱地址的用户的密码更新为新密码。
     * SQL语句从"user"表中查找与给定邮箱地址匹配的用户记录，并将其密码字段更新为新的密码值。
     * 使用DataSourceUtil的update方法执行更新操作，并返回受影响的行数作为操作结果。
     */
    @Override
    public int forgetPassword(Object[] params) {
        String sql = "update user set rolePassword = ? where roleEmail = ?";
        return DataSourceUtil.update(sql, params);
    }
}
