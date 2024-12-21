package bean.dto.care;

import lombok.Data;

import java.sql.Date;

/**
 * program: nursing-home-management-system
 * ClassName CareQuery
 * description:
 * author: xhonell
 * create: 2024年12月18日15时02分
 * Version 1.0
 **/
@Data
public class CareQueryDto {
    private Integer page;
    private Integer limit;
    private String healthState;
    private String olderName;
    private Date healthTime;
}
