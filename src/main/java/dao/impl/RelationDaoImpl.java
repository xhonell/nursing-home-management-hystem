package dao.impl;

import bean.pojo.Relation;
import commons.JDBCUtils;
import dao.RelationDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * dao.impl
 * User: hrj
 * Date: 2024/12/17 16:05
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public class RelationDaoImpl implements RelationDao {

    // 实例化JDBC工具类，用于执行数据库操作
    private JDBCUtils jdbcUtils = new JDBCUtils();


    /**
     * 插入一个新的家属记录
     *
     * @param relation 要插入的家属对象
     */
    @Override
    public void insertRelation(Relation relation) {
        String sql = "INSERT INTO relation(relationName, relationship, relationPhone, relationAddress, relationEmail, olderId) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        Object[] params = {
                relation.getRelationName(),
                relation.getRelationship(),
                relation.getRelationPhone(),
                relation.getRelationAddress(),
                relation.getRelationEmail(),
                relation.getOlderId()
        };
        jdbcUtils.update(sql, params);
    }

    /**
     * 更新一个已存在的家属记录
     *
     * @param relation 要更新的家属对象
     */
    @Override
    public void updateRelation(Relation relation) {
        String sql = "UPDATE relation SET relationName = ?, relationship = ?, relationPhone = ?, " +
                "relationAddress = ?, relationEmail = ?, olderId = ? WHERE relationId = ?";
        Object[] params = {
                relation.getRelationName(),
                relation.getRelationship(),
                relation.getRelationPhone(),
                relation.getRelationAddress(),
                relation.getRelationEmail(),
                relation.getOlderId(),
                relation.getRelationId()
        };
        jdbcUtils.update(sql, params);
    }

    /**
     * 删除一个家属记录
     *
     * @param relationId 要删除的家属ID
     */
    @Override
    public void deleteRelation(Long relationId) {
        String sql = "DELETE FROM relation WHERE relationId = ?";
        Object[] params = {relationId};
        jdbcUtils.update(sql, params);
    }

    /**
     * 根据家属ID获取家属记录
     *
     * @param relationId 家属ID
     * @return 返回对应的家属对象，如果不存在则返回null
     */
    @Override
    public Relation getRelationById(Long relationId) {
        String sql = "SELECT * FROM relation WHERE relationId = ?";
        Object[] params = {relationId};
        try (Connection conn = jdbcUtils.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, relationId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapToRelation(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取所有家属记录
     *
     * @return 返回家属对象的列表
     */
    @Override
    public List<Relation> getAllRelations() {
        String sql = "SELECT * FROM relation";
        List<Relation> relations = new ArrayList<>();
        try (Connection conn = jdbcUtils.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                relations.add(mapToRelation(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relations;
    }

    /**
     * 将ResultSet映射到Relation对象
     *
     * @param rs ResultSet对象
     * @return 返回Relation对象
     * @throws SQLException 如果发生SQL异常
     */
    private Relation mapToRelation(ResultSet rs) throws SQLException {
        Relation relation = new Relation();
        relation.setRelationId((int) rs.getLong("relationId"));
        relation.setRelationName(rs.getString("relationName"));
        relation.setRelationship(rs.getString("relationship"));
        relation.setRelationPhone(rs.getLong("relationPhone"));
        relation.setRelationAddress(rs.getString("relationAddress"));
        relation.setRelationEmail(rs.getString("relationEmail"));
        relation.setOlderId(rs.getInt("olderId"));
        return relation;
    }
}