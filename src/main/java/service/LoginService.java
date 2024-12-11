package service;


import bean.pojo.Player;
import bean.vo.PlayerVo;

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
public interface LoginService {
    PlayerVo login(Player player);
}
