package bean.dto;

import lombok.Data;

@Data
public class UpdateOlderDto {
    private String olderName;
    private Long olderAge;
    private Long olderPhone;
    private String olderHealth;
    private String olderHistory;
    private String olderRemark;

    private Integer olderId;
}
