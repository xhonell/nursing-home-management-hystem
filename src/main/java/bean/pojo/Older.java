package bean.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.security.Timestamp;
import java.util.Date;

@Data
public class Older {
  private Integer olderId;
  private String olderName;
  private String olderSex;
  private Integer olderAge;
  @JSONField(format = "yyyy-MM-dd")
  private Date olderBirth;
  private Integer olderPhone;
  private String olderHealth;
  private String olderHistory;
  private String olderRemark;
  private Timestamp olderStartTime;
  private Timestamp olderEndTime;
  private Integer gradeId;
}
