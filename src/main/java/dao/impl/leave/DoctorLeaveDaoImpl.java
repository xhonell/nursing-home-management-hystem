package dao.impl.leave;

import bean.pojo.DoctorLeave;
import bean.vo.DoctorInformationVo;
import commons.DataSourceUtil;
import dao.leave.DoctorLeaveDao;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName DoctorLeaveDaoImpl
 * description:
 * author: xhonell
 * create: 2024年12月19日14时31分
 * Version 1.0
 **/
public class DoctorLeaveDaoImpl implements DoctorLeaveDao {
    /**
     * 根据医生ID获取医生详细信息
     *
     * @param doctorId 医生ID
     * @return 返回包含医生详细信息的DoctorInformationVo对象
     */
    @Override
    public DoctorInformationVo information(int doctorId) {
        String sql = "select doctor.*,position.positionId,position.positionName,department.departmentId,department.departmentName from doctor " +
                "left join position on position.positionId = doctor.positionId " +
                "left join department on department.departmentId = position.departmentId " +
                "where roleId = ? ";
        return DataSourceUtil.queryToBeanHandler(sql, DoctorInformationVo.class, doctorId);
    }

    /**
     * 请求医生请假
     *
     * @param params 包含请假信息的参数数组，按顺序依次为部门ID、医生ID、职位ID、请假结束时间、请假原因、请假开始时间
     * @return 影响的行数，如果成功插入，返回1；否则返回0
     */
    public int request(Object[] params) {
        String sql = "insert into doctorLeave(departmentId,doctorId,positionId,leaveEndTime,leaveReason,leaveStartTime) values (?,?,?,?,?,?)";
        return DataSourceUtil.update(sql,params);
    }

    @Override
    public List<DoctorLeave> requestInformation(Integer doctorId) {
        String sql = "select doctorLeave.*,doctor.doctorName,position.positionName,department.departmentName " +
                "from doctorLeave " +
                "left join doctor on doctor.doctorId = doctorLeave.doctorId " +
                "left join position on doctorLeave.positionId = position.positionId " +
                "left join department on department.departmentId = doctorLeave.departmentId " +
                "where doctorLeave.doctorId = ? " +
                "order by doctorLeave.leaveId desc";
        return DataSourceUtil.queryToBeanListHandler(sql, DoctorLeave.class, doctorId);
    }
}
