package bean.vo;

import bean.pojo.Care;
import lombok.Data;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName CareQueryVo
 * description:
 * author: xhonell
 * create: 2024年12月18日19时20分
 * Version 1.0
 **/
@Data
public class CareQueryVo {
    private Long total;
    private List<Care> list;
}
