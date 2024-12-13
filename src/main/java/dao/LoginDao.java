package dao;


import bean.pojo.Router;
import bean.vo.PlayerVo;
import bean.vo.RouterVo;
import commons.DataSourceUtil;

import java.util.List;

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

    public List<RouterVo> getParentPageUrl(String roles) {
        String sql = "SELECT router.* " +
                "FROM router " +
                "LEFT JOIN permission ON permission.router_id = router.router_id " +
                "WHERE router.router_parentId IS NULL " +
                "AND permission.roles = ?";
        return DataSourceUtil.queryToBeanListHandler(sql, RouterVo.class, roles);
    }

    public List<Router> getChildrenPageUrl(long routerParentId, String roles) {
        String sql = "SELECT router.* " +
                "FROM router " +
                "LEFT JOIN permission ON permission.router_id = router.router_id " +
                "WHERE router.router_parentId = ? " +
                "AND permission.roles = ?";
        return DataSourceUtil.queryToBeanListHandler(sql, Router.class, routerParentId, roles);
    }
}
