package bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
@Data
public class DoctorFindByPage extends Page{
    private String doctorName;
    private String doctorSex;
    private Integer doctorAge;
    private Integer departmentId;
    private Integer positionId;
    private String doctorPopularity;
    @JSONField(format = "HH:mm:ss")
    private LocalTime doctorStartTime;
    @JSONField(format = "HH:mm:ss")
    private LocalTime doctorEndTime;
}
