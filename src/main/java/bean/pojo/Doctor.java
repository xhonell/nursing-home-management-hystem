package bean.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class Doctor {
  private Integer doctorId;
  private String doctorName;
  private String doctorSex;
  private Integer doctorAge;
  private Long doctorPhone;
  private String doctorEmail;
  private String doctorJob;
  private String doctorIntroduction;
  private String doctorExperience;
  @JSONField(format = "HH:mm:ss")
  private LocalTime doctorStartTime;
  @JSONField(format = "HH:mm:ss")
  private LocalTime doctorEndTime;
  private String doctorPopularity;
  private Integer positionId;
}
