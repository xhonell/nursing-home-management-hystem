package bean.vo;

import bean.pojo.Diet;
import lombok.Data;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName DietQueryVo
 * description:
 * author: xhonell
 * create: 2024年12月16日15时28分
 * Version 1.0
 **/
@Data
public class DietQueryVo {
    private Long count;
    List<Diet> list;
}
