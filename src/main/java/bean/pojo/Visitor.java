package bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * bean.pojo
 * User: hrj
 * Date: 2024/12/16 16:39
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {
    private Long visitorId;
    private String visitorName;
    private String visitorCard;
    private Date visitorTime;
    private String visitorReason;

}
