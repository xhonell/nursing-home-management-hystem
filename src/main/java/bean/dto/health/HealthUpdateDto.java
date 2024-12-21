package bean.dto.health;

import lombok.Data;

import java.sql.Date;

/**
 * program: nursing-home-management-system
 * ClassName HealthUpdateDto
 * description:
 * author: xhonell
 * create: 2024年12月17日14时41分
 * Version 1.0
 **/
@Data
public class HealthUpdateDto {
    private Long doctorId;
    private Double healthBlood;
    private Double healthHeart;
    private Double healthHeight;
    private Long healthId;
    private String healthState;
    private Date healthTime;
    private Double healthWeight;
    private Long olderId;
}
