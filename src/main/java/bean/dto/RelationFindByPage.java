package bean.dto;

import lombok.Data;

/**
 * User: zhongjing
 * Date: 2024/12/21
 * Description:
 * Version: V1.0
 */
@Data
public class RelationFindByPage extends Page{
    private String relationName;
    private String olderName;
    private String relationship;
}
