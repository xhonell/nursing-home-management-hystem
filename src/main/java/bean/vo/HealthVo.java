package bean.vo;

import bean.pojo.Health;
import lombok.Data;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName HealthVo
 * description:
 * author: xhonell
 * create: 2024年12月17日12时43分
 * Version 1.0
 **/
@Data
public class HealthVo {
    private List<Health> healthList;
    private Long total;
}
