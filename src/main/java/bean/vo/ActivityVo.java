package bean.vo;

import lombok.Data;

@Data
public class ActivityVo {
    private long activityId;
    private String activityName;
    private java.sql.Timestamp activityTime;
    private String activityAddress;
    private String activityContent;
    private long doctorId;
    private String doctorName;


}
