package bean.dto.look;

import lombok.Data;

import java.util.Date;

/**
 * bean.dto.look
 * User: hrj
 * Date: 2024/12/20 14:17
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@Data
public class LookUpdateDto {
    private Integer lookId;//查看记录id
    private Date lookTime;//查看时间
    private Integer olderId;//老人id
    private Integer relationId;//家属关系id
    private String remarks;//备注
}

