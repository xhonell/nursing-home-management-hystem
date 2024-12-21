package service.leave;

import bean.dto.leave.RequestDto;
import bean.pojo.DoctorLeave;
import bean.vo.DoctorInformationVo;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName DoctorLeaveService
 * description:
 * author: xhonell
 * create: 2024年12月19日14时28分
 * Version 1.0
 **/
public interface DoctorLeaveService {
    DoctorInformationVo information(int doctorId);

    boolean request(RequestDto requestDto);

    List<DoctorLeave> requestInformation(Integer doctorId);
}
