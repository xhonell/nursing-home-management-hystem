package dao.impl.file;

import bean.vo.OlderInfoVo;
import commons.DataSourceUtil;
import dao.file.OlderInfoDao;

import java.util.ArrayList;
import java.util.List;

public class OlderInfoDaoImpl implements OlderInfoDao {


    @Override
    public OlderInfoVo getInfo(Integer obj) {
        String sql = "select older.* from older " +
                "left join relation on older.olderId = relation.olderId " +
                "where relation.relationId = ?";
        return DataSourceUtil.queryToBeanHandler(sql,OlderInfoVo.class,obj);
    }
    @Override
    public int updateInfo(Object [] obj){
        String sql="update older set olderName=?,olderAge=?,olderPhone=?,olderHealth=?,olderHistory=?,olderRemark=? where olderId =?";
        return DataSourceUtil.update(sql,obj);
    }
}
