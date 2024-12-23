package dao.impl.person;

import bean.dto.OlderFindByPage;
import bean.pojo.Older;
import bean.vo.OlderHealthList;
import bean.vo.OlderList;
import commons.DBHelper;
import commons.JDBCUtils;
import dao.person.OlderDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public class OlderDaoImpl implements OlderDao {
    JDBCUtils jdbcUtils=new JDBCUtils();
    DBHelper dbHelper=new DBHelper();
    @Override
    public Long findTotal(OlderFindByPage olderFindByPage) {
        StringBuffer sql=new StringBuffer("select count(o.olderId) total from older o " +
                "left join grade g on g.gradeId=o.gradeId where 1=1 ");
        List<Object> parameters=new ArrayList<>();
        if (olderFindByPage.getOlderName()!=null){
            sql.append("and o.olderName like concat('%',?,'%') ");
            parameters.add(olderFindByPage.getOlderName());
        }
        if (olderFindByPage.getOlderSex()!=null){
            sql.append("and o.olderSex=? ");
            parameters.add(olderFindByPage.getOlderSex());
        }
        if (olderFindByPage.getOlderAge()!=null){
            sql.append("and o.olderAge=? ");
            parameters.add(olderFindByPage.getOlderAge());
        }
        if (olderFindByPage.getOlderBirth()!=null){
            sql.append("and o.olderBirth=? ");
            parameters.add(olderFindByPage.getOlderBirth());
        }
        if (olderFindByPage.getOlderHealth()!=null){
            sql.append("and o.olderHealth=? ");
            parameters.add(olderFindByPage.getOlderHealth());
        }
        if (olderFindByPage.getOlderStartTime()!=null){
            sql.append("and o.olderStartTime>=? ");
            parameters.add(olderFindByPage.getOlderStartTime());
        }
        if (olderFindByPage.getOlderEndTime()!=null){
            sql.append("and o.olderEndTime<=? ");
            parameters.add(olderFindByPage.getOlderEndTime());
        }
        if (olderFindByPage.getGradeId()!=null){
            sql.append("and g.gradeId=? ");
            parameters.add(olderFindByPage.getGradeId());
        }
        List<Map<String, Object>> list = jdbcUtils.select(sql.toString(), parameters.toArray());
        Long totalNumber=0L;
        if (list.size()>0){
            totalNumber=(Long) list.get(0).get("total");
        }
        return totalNumber;
    }

    @Override
    public List<OlderList> findByPage(OlderFindByPage olderFindByPage) {
        StringBuffer sql=new StringBuffer("select o.olderId,o.olderName,o.olderSex,o.olderAge,o.olderBirth,o.olderPhone,"+
                "o.olderHealth,o.olderHistory,o.olderStartTime,o.olderEndTime,g.gradeName,o.olderRemark "+
                "from older o left join grade g on g.gradeId=o.gradeId where 1=1 ");
        List<Object> parameters=new ArrayList<>();
        if (olderFindByPage.getOlderName()!=null){
            sql.append("and o.olderName like concat('%',?,'%') ");
            parameters.add(olderFindByPage.getOlderName());
        }
        if (olderFindByPage.getOlderSex()!=null){
            sql.append("and o.olderSex=? " );
            parameters.add(olderFindByPage.getOlderSex());
        }
        if (olderFindByPage.getOlderAge()!=null){
            sql.append("and o.olderAge=? ");
            parameters.add(olderFindByPage.getOlderAge());
        }
        if (olderFindByPage.getOlderBirth()!=null){
            sql.append("and o.olderBirth=? ");
            parameters.add(olderFindByPage.getOlderBirth());
        }
        if (olderFindByPage.getOlderHealth()!=null){
            sql.append("and o.olderHealth=? ");
            parameters.add(olderFindByPage.getOlderHealth());
        }
        if (olderFindByPage.getOlderStartTime()!=null){
            sql.append("and o.olderStartTime>=? ");
            parameters.add(olderFindByPage.getOlderStartTime());
        }
        if (olderFindByPage.getOlderEndTime()!=null){
            sql.append("and o.olderEndTime<=? ");
            parameters.add(olderFindByPage.getOlderEndTime());
        }
        if (olderFindByPage.getGradeId()!=null){
            sql.append("and g.gradeId=? ");
            parameters.add(olderFindByPage.getGradeId());
        }
        sql.append("order by o.olderId limit "+(olderFindByPage.getPage()-1)*olderFindByPage.getLimit()+","+olderFindByPage.getLimit());
        List<OlderList> olderList = dbHelper.getBeanList(OlderList.class, sql.toString(), parameters.toArray());
        return olderList;
    }

    @Override
    public Boolean addOlder(Older older) {
        String sql="insert into older(olderName,olderSex,olderAge,olderBirth,olderPhone,olderHealth,olderHistory,olderStartTime,"+
                "olderEndTime,gradeId,olderRemark) values(?,?,?,?,?,?,?,?,?,?,?)";
        Object[] parameters={older.getOlderName(),older.getOlderSex(),older.getOlderAge(),older.getOlderBirth(),older.getOlderPhone(),older.getOlderHealth(),older.getOlderHistory(),older.getOlderStartTime(),older.getOlderEndTime(),older.getGradeId(),older.getOlderRemark()};
        int row = dbHelper.update(sql, parameters);
        return row>0?true:false;
    }

    @Override
    public Boolean updateOlder(Older older) {
        String sql="update older set olderName=?,olderSex=?,olderAge=?,olderBirth=?,olderPhone=?,olderHealth=?,olderHistory=?,"+
                "olderStartTime=?,olderEndTime=?,gradeId=?,olderRemark=? where olderId=?";
        Object[] parameters={older.getOlderName(),older.getOlderSex(),older.getOlderAge(),older.getOlderBirth(),older.getOlderPhone(),older.getOlderHealth(),older.getOlderHistory(),older.getOlderStartTime(),older.getOlderEndTime(),older.getGradeId(),older.getOlderRemark(),older.getOlderId()};
        int row = dbHelper.update(sql, parameters);
        return row>0?true:false;
    }

    @Override
    public Boolean deleteOlder(Older older) {
        String sql="delete from older where olderId=?";
        int row = dbHelper.update(sql, older.getOlderId());
        return row>0?true:false;
    }

    @Override
    public List<OlderHealthList> findAllOlderHealthList() {
        String sql="select distinct olderHealth from older";
        return dbHelper.getBeanList(OlderHealthList.class,sql);
    }
}
