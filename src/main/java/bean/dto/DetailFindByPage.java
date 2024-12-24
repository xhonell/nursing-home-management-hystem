package bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalTime;

/**
 * User: zhongjing
 * Date: 2024/12/24
 * Description:
 * Version: V1.0
 */
@Data
public class DetailFindByPage extends Page{
    private String doctorName;
    private String doctorSex;
    private Integer doctorAge;
    private Integer departmentId;
    private Integer positionId;
    private String doctorPopularity;
}
