package bean.dto.health;

import lombok.Data;

import java.sql.Date;

/**
 * program: nursing-home-management-system
 * ClassName HealthQueryDao
 * description:
 * author: xhonell
 * create: 2024年12月17日11时17分
 * Version 1.0
 **/
@Data
public class HealthQueryDto {
    private long page;
    private long limit;
    private String healthState;;
    private String olderName;
    private Date healthTime;;
}
