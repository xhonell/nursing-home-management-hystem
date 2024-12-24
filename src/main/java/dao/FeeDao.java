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
     * 插入新的费用记录
     *
     * @param fee 要插入的费用对象
     */
    void insertFee(Fee fee);

    /**
     * 更新现有的费用记录
     *
     * @param fee 要更新的费用对象
     */
    void updateFee(Fee fee);
}