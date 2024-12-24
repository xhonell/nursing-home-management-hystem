package bean.vo;

import lombok.Data;

@Data
public class RiskVo {

    private long riskId;
    private String riskLevel;
    private String riskWarn;
    private String riskPlan;
    private long olderId;
    private String olderName;
}
