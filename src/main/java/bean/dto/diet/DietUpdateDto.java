package bean.dto.diet;

import lombok.Data;

import java.sql.Date;

/**
 * program: nursing-home-management-system
 * ClassName DietUpdateDto
 * description:
 * author: xhonell
 * create: 2024年12月16日18时46分
 * Version 1.0
 **/
@Data
public class DietUpdateDto {
    private Long dietId;
    private String dietFood;
    private Date dietTime;
    private Long doctorId;
}
