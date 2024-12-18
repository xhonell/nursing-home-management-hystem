package bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * bean.pojo
 * User: hrj
 * Date: 2024/12/17 15:47
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relation {
    private Integer relationId;
    private String relationName;
    private String relationship;
    private Long relationPhone;
    private String relationAddress;
    private String relationEmail;
    private Integer olderId;
}
