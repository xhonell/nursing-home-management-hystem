package bean.dto.diet;

import lombok.Data;

import java.sql.Date;

/**
 * program: nursing-home-management-system
 * ClassName DietQueryDto
 * description:
 * author: xhonell
 * create: 2024年12月16日15时06分
 * Version 1.0
 **/
@Data
public class DietQueryDto {
    private Integer page;
    private Integer limit;
    private String dietFood;
    private Date dietTime;

}
