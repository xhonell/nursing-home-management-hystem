package bean.dto.care;

import lombok.Data;

import java.sql.Date;

/**
 * program: nursing-home-management-system
 * ClassName CareUpdateDto
 * description:
 * author: xhonell
 * create: 2024年12月18日19时56分
 * Version 1.0
 **/
@Data
public class CareUpdateDto {
    private Long careId;
    private String careContent;
    private Date careTime;
    private Long doctorId;
    private Long olderId;
}
