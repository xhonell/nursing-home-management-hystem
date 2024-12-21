package bean.dto.visitor;

import lombok.Data;

import java.util.Date;

/**
 * bean.dto.visitor
 * User: hrj
 * Date: 2024/12/19 10:52
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@Data
public class VisitorUpdateDto {
    private Long visitorId;
    private String visitorName;
    private String visitorCard;
    private Date visitTime;
    private String visitorReason;}
