package dao;

import bean.pojo.Visitor;

import java.util.List;

/**
 * dao
 * User: hrj
 * Date: 2024/12/17 9:25
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public interface VisitorDao {
    /**
     * 插入访客记录
     *
     * @param visitor 访客对象
     * @return 影响的行数
     */

    int insertVisitor(Visitor visitor);



    /**
     * 更新访客记录
     *
     * @param visitor 访客对象
     * @return 影响的行数
     */

    int updateVisitor(Visitor visitor);



    /**
     * 删除访客记录
     *
     * @param visitorId 访客ID
     * @return 影响的行数
     */
    int deleteVisitor(Long visitorId);





    /**
     * 获取符合条件的访客数量
     *
     * @param params 查询参数数组
     * @return 符合条件的访客数量
     */
    Long listCount(Object[] params);

    /**
     * 分页查询访客记录
     *
     * @param params 查询参数数组
     * @return 访客对象列表
     */
    List<Visitor> list(Object[] params);
}
