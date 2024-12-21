package bean.pojo;

import lombok.Data;

import java.sql.Date;

@Data

public class DoctorLeave {
  private String doctorName;
  private long leaveId;
  private long positionId;
  private long departmentId;
  private String positionName;
  private String departmentName;
  private Date leaveStartTime;
  private Date leaveEndTime;
  private String leaveReason;
  private String leaveState;

}
