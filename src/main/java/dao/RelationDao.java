package dao;

import bean.pojo.Relation;

import java.util.List;

/**
 * dao
 * User: hrj
 * Date: 2024/12/17 16:04
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public interface RelationDao {

    /**
     * 插入一个新的家属关系记录
     *
     * @param relation 要插入的家属关系对象
     */
    void insertRelation(Relation relation);

    /**
     * 更新一个已存在的家属关系记录
     *
     * @param relation 要更新的家属关系对象
     */
    void updateRelation(Relation relation);

    /**
     * 删除一个家属关系记录
     *
     * @param relationId 要删除的家属关系ID
     */
    void deleteRelation(Long relationId);

    /**
     * 根据关系ID获取家属关系记录
     *
     * @param relationId 家属关系ID
     * @return 返回对应的家属关系对象，如果不存在则返回null
     */
    Relation getRelationById(Long relationId);

    /**
     * 获取所有家属关系记录
     *
     * @return 返回家属关系对象的列表
     */
    List<Relation> getAllRelations();
}
