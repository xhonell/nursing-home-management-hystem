package dao.impl;

import bean.pojo.Look;
import commons.JDBCUtils;
import dao.LookDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * dao.impl
 * User: hrj
 * Date: 2024/12/20 14:46
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public class LookDaoImpl implements LookDao {

    /**
     * JDBC 工具类实例，用于数据库操作
     */
    private final JDBCUtils jdbcUtils = new JDBCUtils();

    /**
     * 获取符合条件的 Look 记录总数
     *
     * @param params 包含查询条件的参数数组
     *               - params[0]: older_id
     *               - params[1]: relation_id
     *               - params[2]: start_time
     *               - params[3]: end_time
     * @return 符合条件的记录总数
     */
    @Override
    public Long listCount(Object[] params) {
        String sql = "SELECT COUNT(*) FROM look WHERE 1=1";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> paramList = new ArrayList<>();

        // 根据传入的参数动态添加查询条件
        addParamIfNotNull(sb, paramList, params, 0, " AND olderId = ?");
        addParamIfNotNull(sb, paramList, params, 1, " AND relationId = ?");
        addParamIfNotNull(sb, paramList, params, 2, " AND lookTime >= ?");
        addParamIfNotNull(sb, paramList, params, 3, " AND lookTime <= ?");

        try (Connection connection = jdbcUtils.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sb.toString())) {

            // 设置查询参数
            setParams(preparedStatement, paramList);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getLong(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0L;
    }

    /**
     * 获取符合条件的 Look 记录列表
     *
     * @param params 包含查询条件和分页参数的数组
     *               - params[0]: older_id
     *               - params[1]: relation_id
     *               - params[2]: start_time
     *               - params[3]: end_time
     *               - params[4]: offset
     *               - params[5]: limit
     * @return 符合条件的 Look 记录列表
     */
    @Override
    public List<Look> list(Object[] params) {
        String sql = "SELECT * FROM look WHERE 1=1";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> paramList = new ArrayList<>();

        // 根据传入的参数动态添加查询条件
        addParamIfNotNull(sb, paramList, params, 0, " AND olderId = ?");
        addParamIfNotNull(sb, paramList, params, 1, " AND relationId = ?");
        addParamIfNotNull(sb, paramList, params, 2, " AND lookTime >= ?");
        addParamIfNotNull(sb, paramList, params, 3, " AND lookTime <= ?");
        sb.append(" LIMIT ?, ?");
        paramList.add(params[4]); // offset
        paramList.add(params[5]); // limit

        try (Connection connection = jdbcUtils.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sb.toString())) {

            // 设置查询参数
            setParams(preparedStatement, paramList);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Look> looks = new ArrayList<>();
                while (resultSet.next()) {
                    looks.add(new Look(
                            resultSet.getInt("lookId"),
                            resultSet.getTimestamp("lookTime"),
                            resultSet.getInt("olderId"),
                            resultSet.getInt("relationId")
                    ));
                }
                return looks;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    /**
     * 更新 Look 记录
     *
     * @param params 包含更新信息的参数数组
     *               - params[0]: look_time
     *               - params[1]: older_id
     *               - params[2]: relation_id
     *               - params[3]: look_id
     * @return 影响的行数
     */
    @Override
    public int update(Object[] params) {
        String sql = "UPDATE look SET lookTime = ?, olderId = ?, relationId = ? WHERE lookId = ?";
        return jdbcUtils.update(sql, params);
    }

    /**
     * 创建新的 Look 记录
     *
     * @param params 包含新记录信息的参数数组
     *               - params[0]: look_time
     *               - params[1]: older_id
     *               - params[2]: relation_id
     * @return 影响的行数
     */
    @Override
    public int create(Object[] params) {
        String sql = "INSERT INTO look (lookTime, olderId, relationId) VALUES (?, ?, ?)";
        return jdbcUtils.update(sql, params);
    }

    /**
     * 删除指定 ID 的 Look 记录
     *
     * @param lookId 要删除的 Look 记录的 ID
     * @return 影响的行数
     */
    @Override
    public int delete(Integer lookId) {
        String sql = "DELETE FROM look WHERE lookId = ?";
        Object[] params = {lookId};
        return jdbcUtils.update(sql, params);
    }

    /**
     * 如果参数不为空，则将其添加到 SQL 语句和参数列表中
     *
     * @param sb       SQL 语句构建器
     * @param paramList 参数列表
     * @param params    传入的所有参数
     * @param index     当前参数的索引
     * @param condition 条件字符串
     */
    private void addParamIfNotNull(StringBuilder sb, List<Object> paramList, Object[] params, int index, String condition) {
        if (params[index] != null) {
            sb.append(condition);
            paramList.add(params[index]);
        }
    }

    /**
     * 将参数列表中的值设置到 PreparedStatement 中
     *
     * @param preparedStatement 预编译语句
     * @param paramList         参数列表
     * @throws SQLException SQL 异常
     */
    private void setParams(PreparedStatement preparedStatement, List<Object> paramList) throws SQLException {
        for (int i = 0; i < paramList.size(); i++) {
            preparedStatement.setObject(i + 1, paramList.get(i));
        }
    }
}