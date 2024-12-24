package bean.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.security.Timestamp;

@Data
public class Activity {

  private long activityId;
  private String activityName;
  @JSONField(format = "yyyy-MM-dd HH:mm:ss")
  private Timestamp activityTime;
  private String activityAddress;
  private String activityContent;
  private long doctorId;



}
