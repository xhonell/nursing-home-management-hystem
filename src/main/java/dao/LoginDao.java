package dao;


import bean.vo.PlayerVo;
import commons.DataSourceUtil;

/**
 * <p>Project:java_maven_project - LoginDao
 * <p>POWER by xhonell on 2024-12-09 15:05
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class LoginDao {
    public PlayerVo login(Object[] params) {
        String sql = "select * from player where player_nickName=? and player_password=?";
        return DataSourceUtil.queryToBeanHandler(sql, PlayerVo.class, params);
    }
}
