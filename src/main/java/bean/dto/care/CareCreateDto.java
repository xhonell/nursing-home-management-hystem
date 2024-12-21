package bean.dto.care;

import lombok.Data;

import java.sql.Date;

/**
 * program: nursing-home-management-system
 * ClassName CareCreateDto
 * description:
 * author: xhonell
 * create: 2024年12月19日08时59分
 * Version 1.0
 **/
@Data
public class CareCreateDto {
    private String careContent;
    private Date careTime;
    private Long doctorId;
    private Long olderId;
}
