package dao.impl;

import bean.pojo.Classify;
import dao.ClassifyDao;
import commons.DataSourceUtil;

import java.util.ArrayList;
import java.util.List;

public class ClassifyDaoImpl implements ClassifyDao {
    public List<Classify> getList(Object[] obj) {
        List<Object> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from classify where 1=1");
        if(obj[0]!=null){
            sql.append(" and classifyName like concat('%',?,'%')");
            list.add(obj[0]);
        }
        sql.append(" limit ?,?");
        list.add(obj[1]);
        list.add(obj[2]);
        return DataSourceUtil.queryToBeanListHandler(sql.toString(), Classify.class, list.toArray());
    }
    public int delete(long id) {
        String sql = "delete from classify where classifyId=?";
        return DataSourceUtil.update(sql, id);
    }
    public int create(Object[] params) {
        String sql = "insert into classify(classifyName) values(?)";
        return DataSourceUtil.update(sql, params);
    }
    public int update(Object[] params) {
        String sql = "update classify set classifyName=? where classifyId=?";
        return DataSourceUtil.update(sql, params);
    }
}
