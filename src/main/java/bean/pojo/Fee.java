package bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

/**
 * bean.pojo
 * User: hrj
 * Date: 2024/12/18 11:35
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fee {
    private Integer feeId;
    private String feeName;
    private Double feePrice;
    private String feeState;
    private Timestamp feeTime;
    private Integer olderId;
}

