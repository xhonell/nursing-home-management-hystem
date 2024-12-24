package bean.dto.fee;

import lombok.Data;

import java.sql.Date;

/**
 * bean.dto.fee
 * User: hrj
 * Date: 2024/12/23 20:08
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@Data
public class FeeUpdateDto {
    private Long feeId;
    private String feeName;
    private Double feePrice;
    private String feeState;
    private Date feeTime;
    private Long olderId;}
