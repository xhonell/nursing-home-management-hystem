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
     * 插入一个新的访客记录
     *
     * @param visitor 要插入的访客对象
     */
    void insertVisitor(Visitor visitor);

    /**
     * 更新一个已存在的访客记录
     *
     * @param visitor 要更新的访客对象
     */
    void updateVisitor(Visitor visitor);

    /**
     * 删除一个访客记录
     *
     * @param visitorId 要删除的访客ID
     */
    void deleteVisitor(Long visitorId);

    /**
     * 根据访客ID获取访客记录
     *
     * @param visitorId 访客ID
     * @return 返回对应的访客对象，如果不存在则返回null
     */
    Visitor getVisitorById(Long visitorId);

    /**
     * 获取所有访客记录
     *
     * @return 返回访客对象的列表
     */
    List<Visitor> getAllVisitors();
}
