package bean.dto.fee;

import lombok.Data;

/**
 * bean.dto.fee
 * User: hrj
 * Date: 2024/12/23 20:09
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@Data
public class FeeQueryDto {
    private Long feeId;
    private String feeName;
    private String feeState;
    private Long olderId;
    private Integer page;
    private Integer limit;
}
