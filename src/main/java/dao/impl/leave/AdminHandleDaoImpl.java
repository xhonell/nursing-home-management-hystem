package dao.impl.leave;

import bean.pojo.DoctorLeave;
import commons.DataSourceUtil;
import dao.leave.AdminHandleDao;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName AdminHandleImpl
 * description:
 * author: xhonell
 * create: 2024年12月20日14时16分
 * Version 1.0
 **/
public class AdminHandleDaoImpl implements AdminHandleDao {
    /**
     * 处理医生请假请求，获取所有医生的请假信息列表
     *
     * @return 包含所有医生请假信息的List<DoctorLeave>列表，按照请假状态升序排序
     */
    @Override
    public List<DoctorLeave> handleDoctorLeave() {
        String sql = "select doctorLeave.*,doctor.doctorName,position.positionName,department.departmentName " +
                "from doctorLeave " +
                "left join doctor on doctor.doctorId = doctorLeave.doctorId " +
                "left join position on doctorLeave.positionId = position.positionId " +
                "left join department on department.departmentId = doctorLeave.departmentId" +
                " order by leaveState asc";
        return DataSourceUtil.queryToBeanListHandler(sql, DoctorLeave.class);
    }

    /**
     * 更新医生的请假状态
     *
     * @param params 参数数组，包含医生的请假状态和请假ID
     * @return 更新影响的行数，如果更新成功则返回影响的行数，否则返回0
     */
    @Override
    public int updateDoctorLeave(Object[] params) {
        String sql = "update doctorLeave set leaveState=? where leaveId=?";
        return DataSourceUtil.update(sql, params);
    }

    @Override
    public int updateOlderLeave(Object[] params) {
        String sql = "update olderLeave set leaveState=? where leaveId=?";
        return DataSourceUtil.update(sql, params);
    }
}
