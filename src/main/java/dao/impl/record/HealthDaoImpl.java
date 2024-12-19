package dao.impl.record;

import bean.pojo.Health;
import commons.DataSourceUtil;
import dao.record.HealthDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * program: nursing-home-management-system
 * ClassName HealthDaoImpl
 * description:
 * author: xhonell
 * create: 2024年12月17日11时29分
 * Version 1.0
 **/
public class HealthDaoImpl implements HealthDao {
    /**
     * 查询健康记录列表
     *
     * @param params 查询参数数组，按顺序依次为：健康状态、老人姓名、健康时间、分页偏移量、分页大小
     * @return Health对象列表
     */
    @Override
    public List<Health> list(Object[] params) {
        List<Object> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select health.*, older.olderName,doctor.doctorName " +
                "from health " +
                "left join older on older.olderId = health.olderId " +
                "left join doctor on doctor.doctorId = health.doctorId " +
                "where 1=1");
        if (params[0] != null && !(String.valueOf(params[0]).trim().isEmpty())){
            sql.append(" and health.healthState = ?");
            list.add(params[0]);
        }
        if (params[1] != null && !(String.valueOf(params[1]).trim().isEmpty())){
            sql.append(" and older.olderName like concat('%',?,'%')");
            list.add(params[1]);
        }
        if (params[2] != null && !(String.valueOf(params[2]).trim().isEmpty())){
            sql.append(" and health.healthTime = ?");
            list.add(params[2]);
        }
        sql.append(" limit ?,?");
        list.add(params[3]);
        list.add(params[4]);
        return DataSourceUtil.queryToBeanListHandler(sql.toString(),Health.class, list.toArray());
    }

    /**
     * 查询健康记录的总条数
     *
     * @param params 查询参数数组，当前方法未使用此参数
     * @return Long类型，返回健康记录的总条数
     */
    @Override
    public Long queryTotal(Object[] params) {
        StringBuilder sql = new StringBuilder("select count(*) from health " +
                "left join older on older.olderId = health.olderId " +
                "left join doctor on doctor.doctorId = health.doctorId " +
                "where 1=1");

        List<Object> list = new ArrayList<>();

        // healthState条件
        if (params[0] != null && !(String.valueOf(params[0]).trim().isEmpty())) {
            sql.append(" and health.healthState = ?");
            list.add(params[0]);
        }

        // olderName条件
        if (params[1] != null && !(String.valueOf(params[1]).trim().isEmpty())) {
            sql.append(" and older.olderName like concat('%',?,'%')");
            list.add(params[1]);
        }

        // healthTime条件
        if (params[2] != null && !(String.valueOf(params[2]).trim().isEmpty())) {
            sql.append(" and health.healthTime = ?");
            list.add(params[2]);
        }

        // 执行查询，返回总数
        return (Long) Objects.requireNonNull(DataSourceUtil.queryToArrayHandler(sql.toString(), list.toArray()))[0];
    }

    /**
     * 更新健康信息
     *
     * @param params 更新参数数组，依次为：健康状态、身高、体重、血压、心率、血压、老人ID、健康记录ID、健康记录ID
     * @return int 更新影响的行数
     */
    @Override
    public int update(Object[] params) {
        String sql = "update health set healthState=?,healthHeight=?,healthWeight=?,healthBlood=?,healthHeart=?,healthTime=?,olderId=?,doctorId=? where healthId=?";
        return DataSourceUtil.update(sql,params);
    }

    /**
     * 获取所有老人的姓名列表
     *
     * @return 包含老人姓名的列表
     */
    @Override
    public List<Object> getOlderName() {
        String sql = "select olderName from older ";
        return DataSourceUtil.queryToColumnListHandler(sql, "olderName");
    }

    /**
     * 获取所有老人的ID列表
     *
     * @return 包含所有老人ID的列表
     *
     * 通过执行SQL查询语句，从"older"表中选取所有老人的ID，并返回一个包含这些ID的列表。
     * 使用DataSourceUtil的queryToColumnListHandler方法处理查询结果，将"olderId"列的值作为列表元素返回。
     */
    @Override
    public List<Object> getOlderId() {
        String sql = "select olderId from older ";
        return DataSourceUtil.queryToColumnListHandler(sql, "olderId");
    }

    @Override
    public int create(Object[] params) {
        String sql = "insert into health(healthState,healthHeight,healthWeight,healthBlood,healthHeart,healthTime,olderId,doctorId) values (?,?,?,?,?,?,?,?)";
        return DataSourceUtil.update(sql,params);
    }

    @Override
    public int delete(long id) {
        String sql = "delete from health where healthId=?";
        return DataSourceUtil.update(sql,id);
    }

}
