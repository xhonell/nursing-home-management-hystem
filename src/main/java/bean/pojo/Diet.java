package bean.pojo;

import lombok.Data;

import java.util.Date;

/**
 * program: nursing-home-management-system
 * ClassName Diet
 * description:
 * author: xhonell
 * create: 2024年12月16日15时26分
 * Version 1.0
 **/
@Data
public class Diet {
    private Long dietId;
    private Date dietTime;
    private String dietFood;
    private Long doctorId;
    private String doctorName;
}
