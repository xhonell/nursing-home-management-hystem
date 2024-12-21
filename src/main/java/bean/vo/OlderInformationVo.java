package bean.vo;

import lombok.Data;

/**
 * program: nursing-home-management-system
 * ClassName OlderInfomationVo
 * description:
 * author: xhonell
 * create: 2024年12月21日10时09分
 * Version 1.0
 **/
@Data
public class OlderInformationVo {
    private long relationId;
    private String relationName;
    private String relationship;
    private String relationAddress;
    private Long olderId;
    private String olderName;
}
