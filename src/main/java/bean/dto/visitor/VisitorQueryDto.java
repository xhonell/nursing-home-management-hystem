package bean.dto.visitor;

import lombok.Data;

import java.util.Date;

/**
 * bean.dto.visitor
 * User: hrj
 * Date: 2024/12/19 10:28
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@Data
public class VisitorQueryDto {
    private String visitorName;
    private Date visitTime;
    private int page;
    private int limit;
}

