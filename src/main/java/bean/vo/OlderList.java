package bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * User: zhongjing
 * Date: 2024/12/18
 * Description:
 * Version: V1.0
 */
@Data
public class OlderList {
    private Integer olderId;
    private String olderName;
    private String olderSex;
    private Integer olderAge;
    @JSONField(format = "yyyy-MM-dd")
    private Date olderBirth;
    private Long olderPhone;
    private String olderHealth;
    private String olderHistory;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp olderStartTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp olderEndTime;
    private String gradeName;
    private String olderRemark;
}
