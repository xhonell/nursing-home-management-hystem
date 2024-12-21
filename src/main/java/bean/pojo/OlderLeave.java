package bean.pojo;

import lombok.Data;

import java.sql.Date;

/**
 * program: nursing-home-management-system
 * ClassName olderLeave
 * description:
 * author: xhonell
 * create: 2024年12月21日13时49分
 * Version 1.0
 **/
@Data
public class OlderLeave {
    private long leaveId;
    private long olderId;
    private String olderName;
    private long relationId;
    private String relationName;
    private String relationship;
    private Date leaveStartTime;
    private Date leaveEndTime;
    private String leaveReason;
    private String leaveState;
}
