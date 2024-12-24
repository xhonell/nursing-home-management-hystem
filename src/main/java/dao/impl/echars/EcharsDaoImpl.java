package dao.impl.echars;

import bean.pojo.Fee;
import bean.vo.EcharsAgeVo;
import commons.DataSourceUtil;
import dao.echars.EcharsDao;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName EcharsDaoImpl
 * description:
 * author: xhonell
 * create: 2024年12月22日10时40分
 * Version 1.0
 **/
public class EcharsDaoImpl implements EcharsDao {
    @Override
    public List<EcharsAgeVo> getEcharsAge() {
        String sql = "SELECT name, COUNT(*) AS value " +
                " FROM ( SELECT " +
                " CASE " +
                " WHEN olderAge BETWEEN 50 AND 59 THEN '50-59'" +
                " WHEN olderAge BETWEEN 60 AND 69 THEN '60-69'" +
                " WHEN olderAge BETWEEN 70 AND 79 THEN '70-79'" +
                " WHEN olderAge BETWEEN 80 AND 89 THEN '80-89'" +
                " WHEN olderAge BETWEEN 90 AND 99 THEN '90-99'" +
                " WHEN olderAge BETWEEN 100 AND 110 THEN '100-110'" +
                " ELSE 'Other'" +
                " END AS name" +
                " FROM older" +
                " ) AS age " +
                " GROUP BY name " +
                " ORDER BY name ";
        return DataSourceUtil.queryToBeanListHandler(sql, EcharsAgeVo.class);
    }

    @Override
    public Fee getArrears(Integer relationId) {
        String sql = "select fee.* from fee " +
                "left join relation on relation.olderId = fee.olderId " +
                "where relation.relationId = ?" ;
        return DataSourceUtil.queryToBeanHandler(sql, Fee.class, relationId);
    }

    @Override
    public int setArrears(Integer relationId) {
        String sql = "update fee set feeState = '已支付' " +
                "where feeId = ?";
        return DataSourceUtil.update(sql, relationId);
    }
}
