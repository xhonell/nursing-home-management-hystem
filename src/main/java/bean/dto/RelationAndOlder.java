package bean.dto;

import lombok.Data;

/**
 * User: zhongjing
 * Date: 2024/12/21
 * Description:
 * Version: V1.0
 */
@Data
public class RelationAndOlder {
    private Integer relationId;
    private String relationName;
    private String relationship;
    private Long relationPhone;
    private String relationAddress;
    private String relationEmail;
    private Integer olderId;
    private String olderName;
    private Integer roleId;
}
