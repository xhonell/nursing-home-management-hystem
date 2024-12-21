package bean.dto.diet;

import lombok.Data;

import java.sql.Date;

/**
 * program: nursing-home-management-system
 * ClassName DietCreateDto
 * description:
 * author: xhonell
 * create: 2024年12月16日19时21分
 * Version 1.0
 **/
@Data
public class DietCreateDto {
    private String dietFood;
    private Date dietTime;
    private String doctorId;
}
