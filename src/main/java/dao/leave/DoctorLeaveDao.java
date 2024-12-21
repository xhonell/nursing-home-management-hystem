package dao.leave;

import bean.pojo.DoctorLeave;
import bean.vo.DoctorInformationVo;

import java.util.List;

public interface DoctorLeaveDao {
    DoctorInformationVo information(int doctorId);

    int request(Object[] params);

    List<DoctorLeave> requestInformation(Integer doctorId);
}
