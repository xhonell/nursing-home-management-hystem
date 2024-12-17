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
     * 插入访客信息到数据库
     *
     * 该方法使用JDBC连接数据库，并执行SQL插入语句，将访客对象中的信息插入到visitor表中
     *
     * @param visitor 访客对象，包含需要插入的访客信息，包括访客ID、访客姓名、访客卡号、访问时间和访问原因
     */
    @Override
    public void insertVisitor(Visitor visitor) {
        // 定义SQL插入语句，使用占位符(?)来代替实际的参数值，以防止SQL注入并提高代码可读性
        String sql = "INSERT INTO visitor (VisitorName, VisitorCard, VisitorTime, VisitorReason) VALUES (?, ?, ?, ?)";
        // 创建参数数组，将访客对象中的属性值填入数组，对应SQL语句中的占位符
        Object[] params = {visitor.getVisitorName(), visitor.getVisitorCard(), visitor.getVisitorTime(), visitor.getVisitorReason()};
        // 执行SQL更新操作，将访客信息插入到数据库中
        jdbcUtils.update(sql, params);
    }

    /**
     * 更新访客信息
     *
     * 该方法使用JDBC连接数据库，并执行SQL更新语句，根据访客ID更新访客对象中的信息
     *
     * @param visitor 访客对象，包含需要更新的访客信息，包括访客ID、访客姓名、访客卡号、访问时间和访问原因
     */
    @Override
    public void updateVisitor(Visitor visitor) {
        // 定义SQL更新语句，使用占位符(?)来代替实际的参数值，以防止SQL注入并提高代码可读性
        String sql = "UPDATE visitor SET VisitorName = ?, VisitorCard = ?, VisitorTime = ?, VisitorReason = ? WHERE VisitorId = ?";
        // 创建参数数组，将访客对象中的属性值填入数组，对应SQL语句中的占位符
        Object[] params = {visitor.getVisitorName(), visitor.getVisitorCard(), visitor.getVisitorTime(), visitor.getVisitorReason(), visitor.getVisitorId()};
        // 执行SQL更新操作，更新数据库中的访客信息
        jdbcUtils.update(sql, params);
    }

    /**
     * 根据访客ID删除访客信息
     *
     * 该方法使用JDBC连接数据库，并执行SQL删除语句，根据访客ID删除对应的访客记录
     *
     * @param visitorId 访客ID，用于指定要删除的访客记录
     */
    @Override
    public void deleteVisitor(Long visitorId) {
        // 定义SQL删除语句，使用占位符(?)来代替实际的参数值，以防止SQL注入并提高代码可读性
        String sql = "DELETE FROM visitor WHERE VisitorId = ?";
        // 创建参数数组，将访客ID填入数组，对应SQL语句中的占位符
        Object[] params = {visitorId};
        // 执行SQL更新操作，删除数据库中的访客记录
        jdbcUtils.update(sql, params);
    }

    /**
     * 根据访客ID获取访客信息
     *
     * 该方法使用JDBC连接数据库，并执行SQL查询语句，根据访客ID查询对应的访客记录
     *
     * @param visitorId 访客ID，用于指定要查询的访客记录
     * @return 返回与指定访客ID匹配的访客对象；如果没有找到匹配的访客记录，则返回null
     */
    @Override
    public Visitor getVisitorById(Long visitorId) {
        // 定义SQL查询语句，使用占位符(?)来代替实际的参数值，以防止SQL注入并提高代码可读性
        String sql = "SELECT * FROM visitor WHERE VisitorId = ?";
        // 创建参数数组，将访客ID填入数组，对应SQL语句中的占位符
        Object[] params = {visitorId};
        // 执行SQL查询操作，获取查询结果
        List<Map<String, Object>> result = jdbcUtils.select(sql, params);
        // 检查查询结果是否为空，如果为空则返回null
        if (result.isEmpty()) {
            return null;
        }
        // 获取查询结果中的第一条记录
        Map<String, Object> row = result.get(0);
        // 根据查询结果创建访客对象并返回
        return new Visitor(
                (Long) row.get("VisitorId"),
                (String) row.get("VisitorName"),
                (String) row.get("VisitorCard"),
                (Date) row.get("VisitorTime"),
                (String) row.get("VisitorReason")
        );
    }

    /**
     * 获取所有访客信息
     *
     * 该方法使用JDBC连接数据库，并执行SQL查询语句，获取visitor表中的所有访客记录
     *
     * @return 返回包含所有访客对象的列表
     */
    @Override
    public List<Visitor> getAllVisitors() {
        // 定义SQL查询语句，用于获取visitor表中的所有记录
        String sql = "SELECT * FROM visitor";
        // 执行SQL查询操作，获取查询结果
        List<Map<String, Object>> results = jdbcUtils.select(sql);
        // 创建一个空的访客对象列表，用于存储查询结果
        List<Visitor> visitors = new ArrayList<>();
        // 遍历查询结果，将每一条记录转换为访客对象并添加到列表中
        for (Map<String, Object> row : results) {
            visitors.add(new Visitor(
                    (Long) row.get("VisitorId"),
                    (String) row.get("VisitorName"),
                    (String) row.get("VisitorCard"),
                    (Date) row.get("VisitorTime"),
                    (String) row.get("VisitorReason")
            ));
        }
        // 返回包含所有访客对象的列表
        return visitors;
    }
}