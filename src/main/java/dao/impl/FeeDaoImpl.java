package dao.impl;

import bean.pojo.Fee;
import bean.pojo.Visitor;
import commons.JDBCUtils;
import dao.FeeDao;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
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
    // 实例化JDBC工具类，用于执行数据库操作
    private JDBCUtils jdbcUtils = new JDBCUtils();

    /**
     * 插入新的费用记录到数据库中。
     *
     * @param fee 要插入的费用对象
     */
    @Override
    public void insertFee(Fee fee) {
        // 定义SQL语句，插入费用记录
        String sql = "insert into fee(feeName, feePrice, feeState, feeTime, olderId) values(?, ?, ?, ?, ?)";

        // 将参数封装成Object数组，按顺序对应SQL中的占位符
        Object[] params = new Object[]{
                fee.getFeeName(),   // 费用名称
                fee.getFeePrice(),  // 费用金额
                fee.getFeeState(),  // 费用状态
                fee.getFeeTime(),   // 费用时间
                fee.getOlderId()    // 关联的老人ID
        };

        // 执行SQL插入操作
        jdbcUtils.update(sql, params);
    }

    /**
     * 更新现有的费用记录在数据库中。
     *
     * @param fee 要更新的费用对象
     */
    @Override
    public void updateFee(Fee fee) {
        // 定义SQL语句，更新费用记录
        String sql = "update fee set feeName=?, feePrice=?, feeState=?, feeTime=?, olderId=? where feeId=?";

        // 将参数封装成Object数组，按顺序对应SQL中的占位符
        Object[] params = new Object[]{
                fee.getFeeName(),   // 费用名称
                fee.getFeePrice(),  // 费用金额
                fee.getFeeState(),  // 费用状态
                fee.getFeeTime(),   // 费用时间
                fee.getOlderId(),   // 关联的老人ID
                fee.getFeeId()      // 费用记录的唯一标识
        };

        // 执行SQL更新操作
        jdbcUtils.update(sql, params);
    }
}