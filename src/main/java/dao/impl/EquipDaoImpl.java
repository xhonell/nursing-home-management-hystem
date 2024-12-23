package dao.impl;

import bean.pojo.Equip;
import commons.DataSourceUtil;
import dao.EquipDao;

import java.util.ArrayList;
import java.util.List;

public class EquipDaoImpl implements EquipDao {
    @Override

    //用于用拼接sql语句（模糊）查询，返回查询结果。

    //创建一个盛放查询结果的数组，先检测前端是否有对应的参数，如有，则拼接对应参数的sql查询语句
    //使用DataSourceUtil的queryToBeanListHandler方法处理查询结果，将查询结果封装到List集合中，返回。

    public List<Equip> getList(Object[] obj) {
        //存储sql语句中对应的参数
        List<Object> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from equip where 1=1");
        //判断第一个参数是否为空，不为空则拼接sql语句
        if (obj[0] != null && !(String.valueOf(obj[0]).trim().isEmpty())){
            sql.append(" and equipName like concat('%',?,'%')");
            list.add(String.valueOf(obj[0]));
        }
        //判断第二个参数是否为空，不为空则拼接sql语句
        if(obj[1] != null && !String.valueOf(obj[1]).trim().isEmpty()){
            sql.append(" and equipState = ?");
            list.add(String.valueOf(obj[1]));
        }
        //拼接限制页数sql语句
        sql.append(" limit ?,?");
        list.add(obj[2]);
        list.add(obj[3]);
        //调用DataSourceUtil的queryToBeanListHandler方法，返回查询结果(sql语句，)

        return DataSourceUtil.queryToBeanListHandler(sql.toString(), Equip.class, list.toArray());
    }

    @Override
    public int delete(long id) {
        String sql = "delete from equip where equipId = ?";
        return DataSourceUtil.update(sql, id);
    }
    @Override
    public int create(Object[] params) {
        String sql = "insert into equip(equipName,equipPosition,equipState) values (?,?,?)";
        return DataSourceUtil.update(sql, params);
    }

    @Override
    public int update(Object[] params) {
        String sql = "update equip set equipName = ? , equipPosition = ? , equipState = ? where equipId = ?";
        return DataSourceUtil.update(sql, params);
    }
}
