package bean.dto.look;

import lombok.Data;

/**
 * bean.dto.look
 * User: hrj
 * Date: 2024/12/20 14:16
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@Data
public class LookQueryDto {
    private Integer page;//当前页码
    private Integer limit;//每页显示条数
    private Integer olderId;//老人id
    private Integer relationId;//家属id
    private String startTime;//开始时间
    private String endTime;//结束时间
}

