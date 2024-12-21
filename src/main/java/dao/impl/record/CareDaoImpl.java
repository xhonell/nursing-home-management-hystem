package dao.impl.record;

import bean.pojo.Care;
import commons.DataSourceUtil;
import dao.record.CareDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * program: nursing-home-management-system
 * ClassName CareDaoImpl
 * description:
 * author: xhonell
 * create: 2024年12月18日15时17分
 * Version 1.0
 **/
public class CareDaoImpl implements CareDao {
    /**
     * 根据传入条件获取CareDaoImpl列表
     *
     * @param obj 条件参数数组，包含：健康状态、老年人姓名、健康时间、分页起始位置、分页大小
     * @return 满足条件的CareDaoImpl列表
     */
    @Override
    public List<Care>  getlist(Object[] obj) {
        List<Object> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select care.*, older.olderName,doctor.doctorName from care join older on care.olderId = older.olderId" +
                " join doctor on care.doctorId = doctor.doctorId where 1=1 ");
        if (obj[0] != null && !(String.valueOf(obj[0]).trim().isEmpty())) {
            sql.append(" and healthState like concat('%',?,'%')");
            list.add(obj[0]);
        }
        if (obj[1] != null && !(String.valueOf(obj[1]).trim().isEmpty())) {
            sql.append(" and olderName like concat('%',?,'%')");
            list.add(obj[1]);
        }
        if (obj[2] != null && !(String.valueOf(obj[2]).trim().isEmpty())) {
            sql.append(" and healthTime =?");
            list.add(obj[2]);
        }
        sql.append(" limit ?,?");
        list.add(obj[3]);
        list.add(obj[4]);
        return DataSourceUtil.queryToBeanListHandler(sql.toString(), Care.class, list.toArray());
    }

    /**
     * 根据传入条件查询符合条件的记录总数
     *
     * @param obj 条件参数数组，包含：健康状态、老年人姓名、健康时间、分页起始位置、分页大小
     * @return 符合条件的记录总数
     */
    @Override
    public Long queryTotal(Object[] obj) {
        List<Object> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select count(*) from care join older on care.olderId = older.olderId " +
                "join doctor on care.doctorId = doctor.doctorId where 1=1 ");
        if (obj[0] != null && !(String.valueOf(obj[0]).trim().isEmpty())) {
            sql.append(" and healthState like concat('%',?,'%')");
            list.add(obj[0]);
        }
        if (obj[1] != null && !(String.valueOf(obj[1]).trim().isEmpty())) {
            sql.append(" and olderName like concat ('%',?,'%')");
            list.add(obj[1]);
        }
        if (obj[2] != null && !(String.valueOf(obj[2]).trim().isEmpty())) {
            sql.append(" and healthTime =?");
            list.add(obj[2]);
        }
        return (Long) Objects.requireNonNull(DataSourceUtil.queryToArrayHandler(sql.toString(), list.toArray()))[0];
    }

    /**
     * 更新数据
     *
     * @param params 包含要更新的数据的数组
     * @return 更新操作的结果，通常返回更新的行数
     */
    @Override
    public int update(Object[] params) {
        String sql = "update care set careContent = ?, careTime = ?, doctorId = ?, olderId = ? where careId =?";
        return DataSourceUtil.update(sql, params);
    }

    @Override
    public int create(Object[] params) {
        String sql = "insert into care(careContent,careTime,doctorId,olderId) values (?,?,?,?)";
        return DataSourceUtil.update(sql, params);
    }

    @Override
    public int delete(Integer careId) {
        String sql = "delete from care where careId=?";
        return DataSourceUtil.update(sql, careId);
    }
}
