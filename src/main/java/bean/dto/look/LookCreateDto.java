package bean.dto.look;

import lombok.Data;

import java.util.Date;

/**
 * bean.dto.look
 * User: hrj
 * Date: 2024/12/20 13:59
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@Data
public class LookCreateDto {
    private Date lookTime;//探访时间
    private Integer olderId;//老人id
    private Integer relationId;//家属id
}

