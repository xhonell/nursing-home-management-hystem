package service.impl;

import bean.pojo.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

/**
 * program: nursing-home-management-system
 * ClassName UserServiceImpl
 * description:
 * author: xhonell
 * create: 2024年12月15日13时43分
 * Version 1.0
 **/
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    /**
     * 更新用户头像路径
     *
     * @param roleId 用户角色ID
     * @param relativePath 头像文件的相对路径
     * @return 如果更新成功返回true，否则返回false
     */
    @Override
    public boolean updateAvatar(long roleId, String relativePath) {
        return userDao.updateAvatar(roleId, relativePath) > 0;
    }

    /**
     * 更新用户信息
     *
     * @param user 需要更新的用户对象
     * @return 如果更新成功并查询到更新后的用户信息，则返回该用户对象；如果更新失败或未查询到用户信息，则返回null
     */
    @Override
    public User updateUser(User user) {
        Object[] params = new Object[]{

                user.getRoleName(),
                user.getRoleAge(),
                user.getRoleSex(),
                user.getRolePhone(),
                user.getRoleEmail(),
                user.getRoleId()
        };
        boolean isSuccess = userDao.updateUser(params) > 0;
        if (isSuccess) {
            return userDao.selectUserById(user.getRoleId());
        } else {
            return null;
        }
    }
}
