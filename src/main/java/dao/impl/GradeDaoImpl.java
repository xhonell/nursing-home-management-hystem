package dao.impl;

import bean.pojo.Equip;
import bean.pojo.Grade;
import commons.DataSourceUtil;
import dao.GradeDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GradeDaoImpl implements GradeDao {

    @Override
    public List<Grade> getList(Object[] obj) {
            List<Object> list = new ArrayList<>();
            StringBuilder sql = new StringBuilder("select * from grade where 1=1");
            if (obj[0] != null && !(String.valueOf(obj[0]).trim().isEmpty())){
                sql.append(" and gradeName like concat('%',?,'%')");
                list.add(String.valueOf(obj[0]));
            }
            if(obj[1] != null && !String.valueOf(obj[1]).trim().isEmpty()){
                sql.append(" and gradeContent like concat('%',?,'%')");
                list.add(String.valueOf(obj[1]));
            }
            sql.append(" limit ?,?");
            list.add(obj[2]);
            list.add(obj[3]);

            return DataSourceUtil.queryToBeanListHandler(sql.toString(), Grade.class, list.toArray());
        }
    @Override
    public int delete(long id) {
        String sql = "delete from grade where gradeId = ?";
        return DataSourceUtil.update(sql, id);
    }
    @Override
    public int create(Object[] params) {
        String sql = "insert into grade(gradeName,gradeContent,gradeCharge) values (?,?,?)";
        return DataSourceUtil.update(sql, params);
    }

    @Override
    public int update(Object[] params) {
        String sql = "update grade set gradeName = ? , gradeContent = ? , gradeCharge = ? where gradeId = ?";
        return DataSourceUtil.update(sql, params);
    }
}

