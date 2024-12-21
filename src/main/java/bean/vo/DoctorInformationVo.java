package bean.vo;

import lombok.Data;

/**
 * program: nursing-home-management-system
 * ClassName DoctorInformationVo
 * description:
 * author: xhonell
 * create: 2024年12月19日14时32分
 * Version 1.0
 **/
@Data
public class DoctorInformationVo {
    private Long doctorId;
    private String doctorName;
    private String positionId;
    private String positionName;
    private String departmentId;
    private String departmentName;
}
