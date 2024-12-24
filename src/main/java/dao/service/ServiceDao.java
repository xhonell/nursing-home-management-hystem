package dao.service;

import bean.dto.service.FindQuestion;
import bean.dto.service.FindService;
import bean.pojo.Service;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/23
 * Description:
 * Version: V1.0
 */
public interface ServiceDao {
    Long findTotal(FindService findService);

    List<Service> findService(FindService findService);

    Boolean updateService(Service service);

    Long findTotalQuestion(FindQuestion findQuestion);

    List<Service> findQuestion(FindQuestion findQuestion);

    Boolean addQuestion(Service service);

    Boolean updateQuestion(Service service);
}
