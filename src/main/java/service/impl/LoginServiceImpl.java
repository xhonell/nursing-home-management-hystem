package service.impl;

import bean.dto.LoginDto;
import bean.pojo.Router;
import bean.pojo.User;
import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import service.LoginService;

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
}
