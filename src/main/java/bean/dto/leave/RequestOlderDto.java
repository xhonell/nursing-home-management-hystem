package bean.dto.leave;

import lombok.Data;

import java.sql.Date;

/**
 * program: nursing-home-management-system
 * ClassName RequestOlderDto
 * description:
 * author: xhonell
 * create: 2024年12月21日10时49分
 * Version 1.0
 **/
@Data
public class RequestOlderDto {
    private long olderId;
    private String olderAddress;
    private long relationId;
    private Date leaveStartTime;
    private Date leaveEndTime;
    private String leaveReason;
}
