package bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * User: zhongjing
 * Date: 2024/12/24
 * Description:
 * Version: V1.0
 */
@Data
public class DetailList {

    private Integer doctorId;
    private String doctorName;
    private String doctorSex;
    private Integer doctorAge;
    private String departmentName;
    private String positionName;
    private String doctorJob;
    private String doctorIntroduction;
    private String doctorExperience;
    private String doctorPopularity;
}
