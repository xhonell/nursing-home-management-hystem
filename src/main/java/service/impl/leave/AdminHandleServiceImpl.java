package service.impl.leave;

import bean.pojo.DoctorLeave;
import dao.impl.leave.AdminHandleDaoImpl;
import dao.leave.AdminHandleDao;
import service.leave.AdminHandleService;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName AdminHandleServiceImpl
 * description:
 * author: xhonell
 * create: 2024年12月20日14时16分
 * Version 1.0
 **/
public class AdminHandleServiceImpl implements AdminHandleService {
    AdminHandleDao adminHandleDao = new AdminHandleDaoImpl();
    /**
     * 处理医生请假请求，获取所有医生的请假信息列表
     *
     * @return 包含所有医生请假信息的List<DoctorLeave>列表，按照请假状态升序排序
     */
    @Override
    public List<DoctorLeave> handleDoctorLeave() {
        return adminHandleDao.handleDoctorLeave();
    }

    /**
     * 更新医生请假信息
     *
     * @param params 包含医生请假信息的参数数组，通常包括请假状态ID和请假记录ID等
     * @return 如果更新成功返回true，否则返回false
     */
    @Override
    public boolean updateDoctorLeave(Object[] params) {
        return adminHandleDao.updateDoctorLeave(params) > 0;
    }

    /**
     * 更新旧版请假信息
     *
     * @param params 包含旧版请假信息的参数数组，通常包括请假状态ID、请假开始时间、请假结束时间、请假原因等
     * @return 如果更新成功返回true，否则返回false
     */
    @Override
    public boolean updateOlderLeave(Object[] params) {
        return adminHandleDao.updateOlderLeave(params) > 0;
    }
}
