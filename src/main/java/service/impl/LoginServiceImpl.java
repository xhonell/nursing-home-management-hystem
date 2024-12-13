package service.impl;


import bean.pojo.Player;
import bean.pojo.Router;
import bean.vo.PlayerVo;
import bean.vo.RouterVo;
import dao.LoginDao;
import service.LoginService;

import java.util.List;

/**
 * <p>Project:java_maven_project - LoginServiceImpl
 * <p>POWER by xhonell on 2024-12-09 15:00
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class LoginServiceImpl implements LoginService {
    LoginDao loginDao = new LoginDao();
    @Override
    public PlayerVo login(Player player) {
        Object [] params = {player.getPlayer_nickName(),player.getPlayer_Password()};
        return loginDao.login(params);
    }

    @Override
    public List<RouterVo> getPageUrl(String roles) {
        List<RouterVo> parentPageUrl = loginDao.getParentPageUrl(roles);
        for (RouterVo routerVo : parentPageUrl) {
            List<Router> childrenPageUrl = loginDao.getChildrenPageUrl(routerVo.getRouter_id(), roles);
            routerVo.setChildren(childrenPageUrl);
        }
        return parentPageUrl;
    }
}
