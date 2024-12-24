package dao.impl;

import bean.pojo.Fee;
import commons.DataSourceUtil;
import commons.JDBCUtils;
import dao.FeeDao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * dao.impl
 * User: hrj
 * Date: 2024/12/18 14:29
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public class FeeDaoImpl implements FeeDao {


    /**
     * 插入新的费用记录到数据库中。
     *
     * @param fee 要插入的费用对象
     */
    @Override
    public int insertFee(Object[] fee) {
        // 定义SQL语句，插入费用记录
        String sql = "INSERT INTO fee (feeName, feePrice, feeState, feeTime, olderId) VALUES (?, ?, ?, ?, ?)";


        // 执行SQL插入操作
        DataSourceUtil.update(sql, fee);
        return 1;
    }

    /**
     * 更新现有的费用记录在数据库中。
     *
     * @param fee 要更新的费用对象
     */
    @Override
    public int updateFee(Object[] fee) {
        // 定义SQL语句，更新费用记录
        String sql = "UPDATE fee SET feeName = ?, feePrice = ?, feeState = ?, feeTime = ?, olderId = ? WHERE feeId = ?";


        // 执行SQL更新操作
        return DataSourceUtil.update(sql,fee);
    }

    /**
     * 查询费用记录的总数。
     *
     * @param params 查询参数（可选）
     * @return 费用记录的总数
     */
    @Override
    public Long listCount(Object[] params) {
        // 定义SQL语句，查询费用记录的总数
        StringBuilder sqlBuilder = new StringBuilder("SELECT COUNT(*) AS total FROM fee");
        List<Object> paramList = new ArrayList<>();

        if (params[0] != null) {
            sqlBuilder.append(" WHERE feeName LIKE ?");
            paramList.add("%" + params[0] + "%");
        }
        if (params[1] != null) {
            if (sqlBuilder.indexOf("WHERE") == -1) {
                sqlBuilder.append(" WHERE ");
            } else {
                sqlBuilder.append(" AND ");
            }
            sqlBuilder.append("DATE(feeTime) = ?");
            paramList.add(params[1]);
        }

        // 执行SQL查询操作
        List<Map<String, Object>> result = DataSourceUtil.queryToMapListHandler(sqlBuilder.toString(), paramList.toArray());

        // 处理查询结果，返回费用记录的总数
        if (result != null && !result.isEmpty()) {
            Map<String, Object> row = result.get(0);
            return ((Number) row.get("total")).longValue();
        }
        return 0L;
    }

    /**
     * 查询费用记录列表。
     *
     * @param params 查询参数（可选）
     * @return 费用记录列表
     */
    @Override
    public List<Fee> list(Object[] params) {
        // 定义SQL语句，查询所有的费用记录
        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM fee");
        List<Object> paramList = new ArrayList<>();

        if (params[0] != null) {
            sqlBuilder.append(" WHERE feeName LIKE ?");
            paramList.add("%" + params[0] + "%");
        }
        if (params[1] != null) {
            if (sqlBuilder.indexOf("WHERE") == -1) {
                sqlBuilder.append(" WHERE ");
            } else {
                sqlBuilder.append(" AND ");
            }
            sqlBuilder.append("DATE(feeTime) = ?");
            paramList.add(params[1]);
        }
        if (params.length > 2 && params[2] != null && params[3] != null) {
            sqlBuilder.append(" LIMIT ?, ?");
            paramList.add(params[2]);
            paramList.add(params[3]);
        }

        // 执行SQL查询操作
        List<Map<String, Object>> results = DataSourceUtil.queryToMapListHandler(sqlBuilder.toString(), paramList.toArray());
        List<Fee> feeList = new ArrayList<>();
        for (Map<String, Object> row : results) {
            Fee fee = new Fee();
            fee.setFeeId((Integer) row.get("feeId"));
            fee.setFeeName((String) row.get("feeName"));
            fee.setFeePrice((Double) row.get("feePrice"));
            fee.setFeeState((String) row.get("feeState"));
            fee.setFeeTime((Timestamp) row.get("feeTime"));
            fee.setOlderId((Integer) row.get("olderId"));
            feeList.add(fee);
        }

        // 返回费用记录列表
        return feeList;
    }
}
