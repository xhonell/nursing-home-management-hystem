package service.leave;

import bean.pojo.DoctorLeave;

import java.util.List;

public interface AdminHandleService {
    List<DoctorLeave> handleDoctorLeave();

    boolean updateDoctorLeave(Object[] params);

    boolean updateOlderLeave(Object[] params);
}
