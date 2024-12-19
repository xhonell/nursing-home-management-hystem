package service.impl.login;

import bean.dto.login.ResetPasswordDto;
import bean.pojo.User;
import dao.login.UserDao;
import dao.impl.login.UserDaoImpl;
import service.login.UserService;

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

    /**
     * 重置用户密码
     *
     * @param resetPasswordDto 重置密码数据传输对象，包含新密码和用户角色ID
     * @return 如果重置密码成功，则返回true；否则返回false
     */
    @Override
    public boolean resetPassword(ResetPasswordDto resetPasswordDto) {
        Object[] params = {
                resetPasswordDto.getNewRolePassword(),
                resetPasswordDto.getRoleId(),
        };
        return userDao.updatePasswordById(params) > 0;
    }
}
