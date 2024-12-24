package bean.pojo;

import lombok.Data;

@Data
public class Risk {

  private long riskId;
  private String riskLevel;
  private String riskWarn;
  private String riskPlan;
  private long olderId;
}
