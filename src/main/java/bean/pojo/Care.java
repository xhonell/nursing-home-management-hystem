package bean.pojo;

import lombok.Data;

/**
 * program: nursing-home-management-system
 * ClassName Care
 * description:
 * author: xhonell
 * create: 2024年12月18日15时42分
 * Version 1.0
 **/
@Data
public class Care {
    private Long careId;
    private String careContent;
    private String careTime;
    private Long olderId;
    private String olderName;
    private Long doctorId;
    private String doctorName;
}
