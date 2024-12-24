package dao;

import bean.pojo.Fee;

import java.util.List;

/**
 * dao
 * User: hrj
 * Date: 2024/12/18 14:14
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
*/
public interface FeeDao {
    /**
     * 插入新的费用记录到数据库中。
     *
     * @param fee 要插入的费用对象
     */
    int insertFee(Object[] fee);

    /**
     * 更新现有的费用记录在数据库中。
     *
     * @param fee 要更新的费用对象
     */
    int updateFee(Object[] fee);

    /**
     * 查询费用记录的总数。
     *
     * @param params 查询参数（可选）
     * @return 费用记录的总数
     */
    Long listCount(Object[] params);

    /**
     * 查询费用记录列表。
     *
     * @param params 查询参数（可选）
     * @return 费用记录列表
     */
    List<Fee> list(Object[] params);
}
