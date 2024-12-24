package dao.impl.file;

import bean.vo.RiskVo;
import commons.DataSourceUtil;
import dao.file.RiskDao;

import java.util.ArrayList;
import java.util.List;

public class RiskDaoImpl implements RiskDao {

    @Override
    public List<RiskVo> getlist(Object[] obj) {
        List<Object> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT r.riskId,r.riskLevel,r.riskWarn,r.riskPlan,o.olderId,o.olderName FROM risk r " +
                "JOIN older o ON r.olderId= o.olderId  WHERE 1=1 ");
        if (obj[0] != null && !(String.valueOf(obj[0]).trim().isEmpty())){
            sql.append(" and r.riskLevel = ?");
            list.add(String.valueOf(obj[0]));
        }
        if(obj[1] != null && !String.valueOf(obj[1]).trim().isEmpty()){
            sql.append(" and o.olderName like concat('%',?,'%')");
            list.add(String.valueOf(obj[1]));
        }
        sql.append(" limit ?,?");
        list.add(obj[2]);
        list.add(obj[3]);
        return DataSourceUtil.queryToBeanListHandler(sql.toString(), RiskVo.class, list.toArray());
    }

    @Override
    public long delete(Long riskId) {
        String sql = "DELETE FROM risk WHERE riskId = ?";
        return DataSourceUtil.update(sql, riskId) ;
    }

    @Override
    public int insert(Object[] obj) {
        String sql = "INSERT INTO risk(riskLevel,riskWarn,riskPlan,olderId) VALUES (?,?,?,?)";
        return DataSourceUtil.update(sql, obj);
    }

    @Override
    public int update(Object[] obj) {
        String sql = "UPDATE risk SET riskLevel=?,riskWarn=?,riskPlan=? ,olderId=? WHERE riskId=?";
        return DataSourceUtil.update(sql, obj);
    }

}
