package bean.dto.health;

import lombok.Data;

import java.sql.Date;

/**
 * program: nursing-home-management-system
 * ClassName HealthCreateDto
 * description:
 * author: xhonell
 * create: 2024年12月17日16时44分
 * Version 1.0
 **/
@Data
public class HealthCreateDto {
    private Long doctorId;
    private Double healthBlood;
    private Double healthHeart;
    private Double healthHeight;
    private Double healthWeight;
    private String healthState;
    private Date healthTime;
    private Long olderId;
}
