package bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.security.Timestamp;
import java.util.Date;

/**
 * User: zhongjing
 * Date: 2024/12/18
 * Description:
 * Version: V1.0
 */
@Data
public class OlderFindByPage extends Page{
    private String olderName;
    private String olderSex;
    private Integer olderAge;
    @JSONField(format = "yyyy-MM-dd")
    private Date olderBirth;
    private String olderHealth;
    private Timestamp olderStartTime;
    private Timestamp olderEndTime;
    private Integer gradeId;
}
