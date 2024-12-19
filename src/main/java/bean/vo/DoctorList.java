package bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
@Data
public class DoctorList {
    private Integer doctorId;
    private String doctorName;
    private String doctorSex;
    private Integer doctorAge;
    private Long doctorPhone;
    private String doctorEmail;
    private String departmentName;
    private String positionName;
    private String doctorJob;
    private String doctorIntroduction;
    private String doctorExperience;
    @JSONField(format = "HH:mm:ss")
    private Date doctorStartTime;
    @JSONField(format = "HH:mm:ss")
    private Date doctorEndTime;
    private String doctorPopularity;
}
