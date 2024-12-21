package dao.impl.login;

import bean.pojo.User;
import commons.DataSourceUtil;
import dao.login.UserDao;

/**
 * program: nursing-home-management-system
 * ClassName UserDaoImpl
 * description:
 * author: xhonell
 * create: 2024年12月15日13时44分
 * Version 1.0
 **/
public class UserDaoImpl implements UserDao {
    /**
     * 更新用户头像路径
     *
     * @param roleId 用户角色ID
     * @param relativePath 头像文件的相对路径
     * @return 如果更新成功，返回受影响的行数；如果更新失败，返回0
     */
    @Override
    public int updateAvatar(long roleId, String relativePath) {
        String sql = "update user set roleImage = ? where roleId = ?";
        return DataSourceUtil.update(sql, relativePath, roleId);
    }

    /**
     * 更新用户信息
     *
     * @param params 包含更新用户信息所需的参数数组
     * @return 如果更新成功，返回受影响的行数；如果更新失败，返回0
     */
    @Override
    public int updateUser(Object[] params) {
        String sql = "update user set roleName = ?, roleAge = ?,roleSex = ?, rolePhone = ?, roleEmail  = ? where roleId = ?";
        return DataSourceUtil.update(sql, params);
    }

    /**
     * 根据用户角色ID查询用户信息
     *
     * @param roleId 用户角色ID
     * @return 返回查询到的用户信息对象，如果未查询到则返回null
     */
    @Override
    public User selectUserById(long roleId) {
        String sql = "select * from user where roleId = ?";
        return DataSourceUtil.queryToBeanHandler(sql, User.class, roleId);
    }

    /**
     * 通过ID更新用户密码
     *
     * @param params 参数数组，其中第一个元素为新的密码，第二个元素为用户ID
     * @return 更新成功返回受影响的行数，更新失败返回-1
     */
    @Override
    public int updatePasswordById(Object[] params) {
        String sql = "update user set rolePassword = ? where roleId = ?";
        return DataSourceUtil.update(sql, params);
    }
}
