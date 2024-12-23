package service.impl.leave;

import bean.dto.leave.RequestDto;
import bean.pojo.DoctorLeave;
import bean.vo.DoctorInformationVo;
import dao.impl.leave.DoctorLeaveDaoImpl;
import service.leave.DoctorLeaveService;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName DoctorLeaveServiceImpl
 * description:
 * author: xhonell
 * create: 2024年12月19日14时30分
 * Version 1.0
 **/
public class DoctorLeaveServiceImpl implements DoctorLeaveService {
    DoctorLeaveDaoImpl doctorLeaveDao = new DoctorLeaveDaoImpl();
    /**
     * 根据医生ID获取医生信息
     *
     * @param doctorId 医生ID
     * @return 医生信息对象DoctorInformationVo
     */
    @Override
    public DoctorInformationVo information(int doctorId) {
        return doctorLeaveDao.information(doctorId);
    }

    /**
     * 请求医生请假
     *
     * @param requestDto 请求参数对象，包含部门ID、医生ID、职位ID、请假结束时间、请假原因、请假开始时间等信息
     * @return 请求成功返回true，失败返回false
     */
    @Override
    public boolean request(RequestDto requestDto) {
        Object [] params = {
                requestDto.getDepartmentId(),
                requestDto.getDoctorId(),
                requestDto.getPositionId(),
                requestDto.getLeaveEndTime(),
                requestDto.getLeaveReason(),
                requestDto.getLeaveStartTime()
        };
        return doctorLeaveDao.request(params) > 0;
    }

    @Override
    public List<DoctorLeave> requestInformation(Integer doctorId) {
        return doctorLeaveDao.requestInformation(doctorId);
    }
}
