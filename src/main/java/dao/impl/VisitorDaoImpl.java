package dao.impl;

import bean.pojo.Visitor;
import commons.JDBCUtils;
import dao.VisitorDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * dao.impl
 * User: hrj
 * Date: 2024/12/17 9:34
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public class VisitorDaoImpl implements VisitorDao {
    // 实例化JDBC工具类，用于执行数据库操作
    private JDBCUtils jdbcUtils = new JDBCUtils();

    /**
     * 插入访客记录
     *
     * @param visitor 访客对象
     * @return 影响的行数
     */
    @Override

    public int insertVisitor(Visitor visitor) {
        String sql = "INSERT INTO visitor (visitorName, visitorCard, visitorTime, visitorReason) VALUES (?, ?, ?, ?)";
        Object[] params = {visitor.getVisitorName(), visitor.getVisitorCard(), visitor.getVisitorTime(), visitor.getVisitorReason()};
        return jdbcUtils.update(sql, params); // 返回插入操作的结果
    }

    /**
     * 插入访客记录（重载方法）
     *
     * @param params 访客参数数组
     * @return 影响的行数
     */
    @Override
    public int insertVisitor(Object[] params) {
        String sql = "INSERT INTO visitor (visitorName, visitorCard, visitorTime, visitorReason) VALUES (?, ?, ?, ?)";
        return jdbcUtils.update(sql, params); // 返回插入操作的结果
    }

    /**
     * 更新访客记录
     *
     * @param visitor 访客对象
     * @return 影响的行数
     */
    @Override
    public int updateVisitor(Visitor visitor) {
        String sql = "UPDATE visitor SET visitorName = ?, visitorCard = ?, visitorTime = ?, visitorReason = ? WHERE visitorId = ?";
        Object[] params = {visitor.getVisitorName(), visitor.getVisitorCard(), visitor.getVisitorTime(), visitor.getVisitorReason(), visitor.getVisitorId()};
        return jdbcUtils.update(sql, params);
    }

    /**
     * 更新访客记录（重载方法）
     *
     * @param params 访客参数数组
     * @return 影响的行数
     */
    @Override
    public int updateVisitor(Object[] params) {
        String sql = "UPDATE visitor SET visitorName = ?, visitorCard = ?, visitorTime = ?, visitorReason = ? WHERE visitorId = ?";
        return jdbcUtils.update(sql, params);
    }

    /**
     * 删除访客记录
     *
     * @param visitorId 访客ID
     * @return 影响的行数
     */
    @Override
    public int deleteVisitor(Long visitorId) {
        String sql = "DELETE FROM visitor WHERE visitorId = ?";
        Object[] params = {visitorId};
        return jdbcUtils.update(sql, params);
    }

    /**
     * 根据ID获取访客记录
     *
     * @param visitorId 访客ID
     * @return 访客对象
     */
    @Override
    public Visitor getVisitorById(Long visitorId) {
        String sql = "SELECT * FROM visitor WHERE visitorId = ?";
        Object[] params = {visitorId};
        List<Map<String, Object>> result = jdbcUtils.select(sql, params);
        if (result.isEmpty()) {
            return null;
        }
        Map<String, Object> row = result.get(0);
        return new Visitor(
                ((Number) row.get("visitorId")).longValue(), // 使用 Number 类进行安全转换
                (String) row.get("visitorName"),
                (String) row.get("visitorCard"),
                (Date) row.get("visitorTime"),
                (String) row.get("visitorReason")
        );
    }

    /**
     * 获取所有访客记录
     *
     * @return 访客对象列表
     */
    @Override
    public List<Visitor> getAllVisitors() {
        String sql = "SELECT * FROM visitor";
        List<Map<String, Object>> results = jdbcUtils.select(sql);
        List<Visitor> visitors = new ArrayList<>();
        for (Map<String, Object> row : results) {
            visitors.add(new Visitor(
                    ((Number) row.get("visitorId")).longValue(), // 使用 Number 类进行安全转换
                    (String) row.get("visitorName"),
                    (String) row.get("visitorCard"),
                    (Date) row.get("visitorTime"),
                    (String) row.get("visitorReason")
            ));
        }
        return visitors;
    }

    /**
     * 获取符合条件的访客数量
     *
     * @param params 查询参数数组
     * @return 符合条件的访客数量
     */
    @Override
    public Long listCount(Object[] params) {
        StringBuilder sqlBuilder = new StringBuilder("SELECT COUNT(*) AS total FROM visitor");
        List<Object> paramList = new ArrayList<>();

        if (params[0] != null) {
            sqlBuilder.append(" WHERE visitorName LIKE ?");
            paramList.add(params[0]);
        }
        if (params[1] != null) {
            if (sqlBuilder.indexOf("WHERE") == -1) {
                sqlBuilder.append(" WHERE ");
            } else {
                sqlBuilder.append(" AND ");
            }
            sqlBuilder.append("DATE(visitorTime) = ?");
            paramList.add(params[1]);
        }

        List<Map<String, Object>> result = jdbcUtils.select(sqlBuilder.toString(), paramList.toArray());
        if (result.isEmpty()) {
            return 0L;
        }
        Map<String, Object> row = result.get(0);
        return ((Number) row.get("total")).longValue();
    }

    /**
     * 分页查询访客记录
     *
     * @param params 查询参数数组
     * @return 访客对象列表
     */
    @Override
    public List<Visitor> list(Object[] params) {
        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM visitor");
        List<Object> paramList = new ArrayList<>();

        if (params[0] != null) {
            sqlBuilder.append(" WHERE visitorName LIKE ?");
            paramList.add(params[0]);
        }
        if (params[1] != null) {
            if (sqlBuilder.indexOf("WHERE") == -1) {
                sqlBuilder.append(" WHERE ");
            } else {
                sqlBuilder.append(" AND ");
            }
            sqlBuilder.append("DATE(visitorTime) = ?");
            paramList.add(params[1]);
        }

        sqlBuilder.append(" LIMIT ?, ?");


        paramList.add(params[2]);
        paramList.add(params[3]);

        List<Map<String, Object>> results = jdbcUtils.select(sqlBuilder.toString(), paramList.toArray());
        List<Visitor> visitors = new ArrayList<>();
        for (Map<String, Object> row : results) {
            visitors.add(new Visitor(
                    ((Number) row.get("visitorId")).longValue(), // 使用 Number 类进行安全转换
                    (String) row.get("visitorName"),
                    (String) row.get("visitorCard"),
                    (Date) row.get("visitorTime"),
                    (String) row.get("visitorReason")
            ));
        }
        return visitors;
    }
}