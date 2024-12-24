package bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * bean.pojo
 * User: hrj
 * Date: 2024/12/20 11:37
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Look {
    private Integer lookId;
    private Timestamp lookTime;
    private Integer olderId;
    private Integer relationId;
}
