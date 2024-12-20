package dao.leave;

import bean.pojo.DoctorLeave;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName AdminHandleDao
 * description:
 * author: xhonell
 * create: 2024年12月20日14时15分
 * Version 1.0
 **/
public interface AdminHandleDao {
    List<DoctorLeave> handleDoctorLeave();

    int updateDoctorLeave(Object[] params);
}
