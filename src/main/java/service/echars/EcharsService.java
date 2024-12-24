package service.echars;

import bean.pojo.Fee;
import bean.vo.EcharsAgeVo;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName EcharsService
 * description:
 * author: xhonell
 * create: 2024年12月22日10时38分
 * Version 1.0
 **/
public interface EcharsService {
    List<EcharsAgeVo> getEcharsAge();

    Fee getArrears(Integer relationId);

    boolean setArrears(Integer relationId);
}
