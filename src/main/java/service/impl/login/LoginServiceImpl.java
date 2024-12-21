package service.impl.login;

import bean.dto.login.ForgetPasswordDto;
import bean.dto.login.LoginDto;
import bean.pojo.Router;
import bean.pojo.User;
import dao.login.LoginDao;
import dao.impl.login.LoginDaoImpl;
import service.login.LoginService;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName LoginServiceImpl
 * description:
 * author: xhonell
 * create: 2024年12月13日21时55分
 * Version 1.0
 **/
public class LoginServiceImpl implements LoginService {
    LoginDao loginDao = new LoginDaoImpl();
    /**
     * 检查用户登录信息
     *
     * @param loginDto 登录信息对象，包含用户名和密码
     * @return 登录成功的用户对象，若登录失败则返回null
     */
    @Override
    public User checkLogin(LoginDto loginDto) {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        Object[] params = {username, password};
        return loginDao.checkLogin(params);
    }

    /**
     * 根据角色获取路由信息
     *
     * @param roles 角色名称
     * @return 路由信息列表，如果查询失败或没有对应的路由信息则返回null
     */
    @Override
    public List<Router> getRouter(String roles) {
        List<Router> firstRouter = loginDao.getFirstRouter(roles);
        if (firstRouter == null) {
            return null;
        }
        for (Router router : firstRouter) {
            List<Router> childrenRouter = loginDao.getChildrenRouter(router.getPageId(),roles);
            if (childrenRouter != null) {
                router.setPageChildren(childrenRouter);
            }
        }
        return firstRouter;
    }

    /**
     * 根据邮箱地址查询用户是否存在
     *
     * @param email 用户的邮箱地址
     * @return 如果用户存在返回true，否则返回false
     *
     * 通过调用loginDao的queryEmail方法，根据提供的邮箱地址查询用户是否存在。
     * 如果查询结果不为null，表示用户存在，方法返回true；否则返回false。
     */
    @Override
    public boolean queryEmail(String email) {
        return loginDao.queryEmail(email) != null ;
    }

    /**
     * 重置用户密码
     *
     * @param forgetPasswordDto 包含新密码和邮箱地址的数据传输对象
     * @return 如果密码重置成功返回true，否则返回false
     *
     * 此方法用于重置用户的密码。它接收一个ForgetPasswordDto对象作为参数，该对象包含用户的新密码和邮箱地址。
     * 方法内部，将新密码和邮箱地址封装到一个对象数组中，并调用loginDao的forgetPassword方法尝试更新用户密码。
     * 如果loginDao的forgetPassword方法返回的影响行数大于0，则表示密码重置成功，方法返回true；否则返回false。
     */
    @Override
    public boolean resetPassword(ForgetPasswordDto forgetPasswordDto) {
        Object[] params = {forgetPasswordDto.getRolePassword(),forgetPasswordDto.getRoleEmail()};
        return loginDao.forgetPassword(params) > 0;
    }
}
