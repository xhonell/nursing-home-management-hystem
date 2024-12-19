package dao.impl.record;

import bean.pojo.Diet;
import commons.DataSourceUtil;
import dao.record.DietDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * program: nursing-home-management-system
 * ClassName DietDaoImpl
 * description:
 * author: xhonell
 * create: 2024年12月16日15时22分
 * Version 1.0
 **/
public class DietDaoImpl implements DietDao {
    /**
     * 计算饮食记录的总数
     *
     * @param params 查询参数，对于此实现来说，此参数未被使用
     * @return 饮食记录的总数
     */
    public Long listCount(Object[] params) {
        StringBuilder sql = new StringBuilder("select count(*) from diet " +
                "left join doctor on doctor.doctorId = diet.doctorId " +
                "where 1=1");

        List<Object> paramsList = new ArrayList<>();

        // dietFood模糊查询
        if (params[0] != null && !String.valueOf(params[0]).trim().isEmpty()) {
            sql.append(" and dietFood like concat('%',?,'%')");
            paramsList.add(String.valueOf(params[0]));
        }

        // dietTime精确查询
        if (params[1] != null && !String.valueOf(params[1]).trim().isEmpty()) {
            sql.append(" and dietTime = ?");
            paramsList.add(String.valueOf(params[1]));
        }

        // 执行查询并返回结果
        return (Long) Objects.requireNonNull(DataSourceUtil.queryToArrayHandler(sql.toString(), paramsList.toArray()))[0];
    }


    /**
     * 根据给定的参数列表查询饮食记录列表
     *
     * @param params 参数列表，包含以下参数：
     *                 params[0]: 饮食内容，用于模糊匹配饮食名称
     *                 params[1]: 饮食时间，精确匹配饮食时间
     *                 params[2]: 查询起始记录位置（分页参数）
     *                 params[3]: 查询记录数量（分页参数）
     * @return 符合查询条件的饮食记录列表
     */
    @Override
    public List<Diet> list(Object[] params) {
        List<Object> paramsList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select diet.dietId,diet.dietTime,diet.dietFood,doctor.doctorId, doctor.doctorName" +
                " from diet" +
                " left join doctor on doctor.doctorId = diet.doctorId" +
                " where 1=1");
        if (params[0] != null && !String.valueOf(params[0]).trim().isEmpty()) {
            sql.append(" and dietFood like concat('%',?,'%')");
            paramsList.add(String.valueOf(params[0]));
        }
        if (params[1] != null && !String.valueOf(params[1]).trim().isEmpty()) {
            sql.append(" and dietTime = ? ");
            paramsList.add(String.valueOf(params[1]));
        }
        sql.append(" limit ? , ?");
        paramsList.add(params[2]);
        paramsList.add(params[3]);

        return DataSourceUtil.queryToBeanListHandler(sql.toString(), Diet.class, paramsList.toArray());
    }

    /**
     * 更新饮食信息
     *
     * @param params 包含更新信息的参数数组，顺序为：饮食内容, 饮食时间, 饮食ID
     * @return 如果更新成功，则返回影响的行数；否则返回0
     */
    @Override
    public int update(Object[] params) {
        String sql = "update diet set dietFood = ? , dietTime = ? where dietId = ?";
        return DataSourceUtil.update(sql, params);
    }

    /**
     * 向饮食表中插入一条新的饮食记录
     *
     * @param params 包含插入数据的参数数组，顺序为：饮食内容, 饮食时间, 医生ID
     * @return 如果插入成功，则返回影响的行数；否则返回0
     */
    @Override
    public int create(Object[] params) {
        String sql = "insert into diet(dietFood,dietTime,doctorId) values (?,?,?)";
        return DataSourceUtil.update(sql, params);
    }

    @Override
    public int delete(Integer dietId) {
        String sql = "delete from diet where dietId=?";
        return DataSourceUtil.update(sql, dietId);
    }
}
