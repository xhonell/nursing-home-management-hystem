package dao.impl.person;

import bean.dto.RelationAndOlder;
import bean.dto.RelationFindByPage;
import bean.pojo.Older;
import bean.pojo.Relation;
import bean.vo.RelationList;
import commons.DBHelper;
import commons.JDBCUtils;
import dao.person.RelationDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public class RelationDaoImpl implements RelationDao {
    JDBCUtils jdbcUtils=new JDBCUtils();
    DBHelper dbHelper=new DBHelper();
    @Override
    public Long findTotal(RelationFindByPage relationFindByPage) {
        StringBuffer sql=new StringBuffer("select count(r.relationId) total from relation r join older o on o.olderId=r.olderId "+
                "where 1=1 ");
        List<Object> parameters=new ArrayList<>();
        if (relationFindByPage.getRelationName()!=null){
            sql.append("and r.relationName like concat('%',?,'%') ");
            parameters.add(relationFindByPage.getRelationName());
        }
        if (relationFindByPage.getOlderName()!=null){
            sql.append("and o.olderName like concat('%',?,'%') ");
            parameters.add(relationFindByPage.getOlderName());
        }
        if (relationFindByPage.getRelationship()!=null){
            sql.append("and r.relationship=? ");
            parameters.add(relationFindByPage.getRelationship());
        }
        List<Map<String, Object>> list = jdbcUtils.select(sql.toString(), parameters.toArray());
        Long totalNumber=0L;
        if (list.size()>0){
            totalNumber=(Long) list.get(0).get("total");
        }
        return totalNumber;
    }

    @Override
    public List<RelationList> findByPage(RelationFindByPage relationFindByPage) {
        StringBuffer sql=new StringBuffer("select r.relationId, r.relationName,o.olderName,r.relationship,r.relationPhone,r.relationEmail,r.relationAddress " +
                "from relation r join older o on o.olderId=r.olderId where 1=1 ");
        List<Object> parameters=new ArrayList<>();
        if (relationFindByPage.getRelationName()!=null){
            sql.append("and r.relationName like concat('%',?,'%') ");
            parameters.add(relationFindByPage.getRelationName());
        }
        if (relationFindByPage.getOlderName()!=null){
            sql.append("and o.olderName like concat('%',?,'%') ");
            parameters.add(relationFindByPage.getOlderName());
        }
        if (relationFindByPage.getRelationship()!=null){
            sql.append("and r.relationship=? ");
            parameters.add(relationFindByPage.getRelationship());
        }
        sql.append("order by r.relationId limit "+(relationFindByPage.getPage()-1)*relationFindByPage.getLimit()+","+relationFindByPage.getLimit());
        List<RelationList> beanList = dbHelper.getBeanList(RelationList.class, sql.toString(), parameters.toArray());
        return beanList;
    }

    @Override
    public List<Relation> findAllRelationship() {
        String sql="select distinct relationship from relation";
        return dbHelper.getBeanList(Relation.class,sql);
    }

    @Override
    public Boolean addRelation(RelationAndOlder relationAndOlder) {
        String sql1="select olderId from older where olderName like ?";
        Older older = dbHelper.getBean(Older.class, sql1,relationAndOlder.getOlderName());
        if (older==null){
            return false;
        }else {
            String sql="insert into relation(relationName,olderId,relationship,relationPhone,relationEmail,relationAddress) values(?,?,?,?,?,?)";
            Object[] parameters={relationAndOlder.getRelationName(),older.getOlderId(),relationAndOlder.getRelationship(),relationAndOlder.getRelationPhone(),relationAndOlder.getRelationEmail(),relationAndOlder.getRelationAddress()};
            int row = dbHelper.update(sql, parameters);
            return row>0?true:false;
        }
    }

    @Override
    public Boolean updateRelation(RelationAndOlder relationAndOlder) {
        String sql1="select olderId from older where olderName like ?";
        Older older = dbHelper.getBean(Older.class, sql1,relationAndOlder.getOlderName());
        if (older==null){
            return false;
        }else {
            String sql="update relation set relationName=?,olderId=?,relationship=?,relationPhone=?,relationEmail=?,relationAddress=? where relationId=?";
            Object[] parameters={relationAndOlder.getRelationName(),older.getOlderId(),relationAndOlder.getRelationship(),relationAndOlder.getRelationPhone(),relationAndOlder.getRelationEmail(),relationAndOlder.getRelationAddress(),relationAndOlder.getRelationId()};
            int row = dbHelper.update(sql, parameters);
            return row>0?true:false;
        }
    }

    @Override
    public Boolean deleteRelation(Integer relationId) {
        String sql="delete from relation where relationId=?";
        int row = dbHelper.update(sql, relationId);
        return row>0?true:false;
    }
}
