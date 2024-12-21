package dao.impl.leave;

import bean.pojo.OlderLeave;
import bean.vo.OlderInformationVo;
import commons.DataSourceUtil;
import dao.leave.OlderLeaveDao;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName OlderLeaveDaoImpl
 * description:
 * author: xhonell
 * create: 2024年12月21日10时08分
 * Version 1.0
 **/
public class OlderLeaveDaoImpl implements OlderLeaveDao {
    /**
     * 根据关系ID获取关联的老员工信息
     *
     * @param relationId 关系ID
     * @return OlderInformationVo 包含老员工信息的对象
     */
    @Override
    public OlderInformationVo olderInformation(Integer relationId) {
        String sql = "select relation.* ,older.olderName from relation " +
                "left join older on relation.olderId = older.olderId " +
                "WHERE relation.roleId = ?";
        return DataSourceUtil.queryToBeanHandler(sql, OlderInformationVo.class, relationId);
    }

    /**
     * 将旧版请假信息插入到数据库中
     *
     * @param params 参数数组，包含旧版ID、关系ID、请假开始时间、请假结束时间和请假原因等信息
     * @return 插入的行数，如果插入成功则返回1，否则返回0
     */
    @Override
    public int request(Object[] params) {
        String sql = "insert into olderLeave(olderId,relationId,leaveStartTime,leaveEndTime,leaveReason) values(?,?,?,?,?)";
        return DataSourceUtil.update(sql, params);
    }

    @Override
    public List<OlderLeave> requestInformation(Integer relationId) {
        if (relationId == 0) {
            String sql = "select olderLeave.*, older.olderName,relation.relationName,relation.relationship " +
                    "from olderLeave " +
                    "left join older on older.olderId = olderLeave.olderId " +
                    "left join relation on relation.relationId = olderLeave.relationId " +
                    "order by olderLeave.leaveState asc";
            return DataSourceUtil.queryToBeanListHandler(sql, OlderLeave.class);
        }
        String sql = "select olderLeave.*, older.olderName,relation.relationName,relation.relationship " +
                "from olderLeave " +
                "left join older on older.olderId = olderLeave.olderId " +
                "left join relation on relation.relationId = olderLeave.relationId " +
                "where olderLeave.relationId = ? " +
                "order by olderLeave.leaveId desc";
        return DataSourceUtil.queryToBeanListHandler(sql, OlderLeave.class, relationId);
    }
}
