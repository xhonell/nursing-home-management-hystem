package bean.vo;

import lombok.Data;

/**
 * User: zhongjing
 * Date: 2024/12/21
 * Description:
 * Version: V1.0
 */
@Data
public class RelationList {
    private Integer relationId;
    private String relationName;
    private String olderName;
    private String relationship;
    private Long relationPhone;
    private String relationEmail;
    private String relationAddress;
}
