package bean.dto.leave;

import lombok.Data;

import java.sql.Date;

/**
 * program: nursing-home-management-system
 * ClassName requestDto
 * description:
 * author: xhonell
 * create: 2024年12月19日19时30分
 * Version 1.0
 **/
@Data
public class RequestDto {
    private Long departmentId;
    private String departmentName;
    private String doctorName;
    private Long doctorId;
    private String leaveReason;
    private Date leaveEndTime;
    private Date leaveStartTime;
    private Long positionId;
}
