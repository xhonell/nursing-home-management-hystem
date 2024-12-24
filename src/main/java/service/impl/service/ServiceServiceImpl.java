package service.impl.service;

import bean.dto.service.FindQuestion;
import bean.dto.service.FindService;
import bean.pojo.Service;
import dao.impl.service.ServiceDaoImpl;
import dao.service.ServiceDao;
import service.service.ServiceService;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/23
 * Description:
 * Version: V1.0
 */
public class ServiceServiceImpl implements ServiceService {
    private ServiceDao serviceDao=new ServiceDaoImpl();
    @Override
    public Long findTotal(FindService findService) {
        return serviceDao.findTotal(findService);
    }

    @Override
    public List<Service> findService(FindService findService) {
        return serviceDao.findService(findService);
    }

    @Override
    public Boolean updateService(Service service) {
        return serviceDao.updateService(service);
    }

    @Override
    public Long findTotalQuestion(FindQuestion findQuestion) {
        return serviceDao.findTotalQuestion(findQuestion);
    }

    @Override
    public List<Service> findQuestion(FindQuestion findQuestion) {
        return serviceDao.findQuestion(findQuestion);
    }

    @Override
    public Boolean addQuestion(Service service) {
        return serviceDao.addQuestion(service);
    }

    @Override
    public Boolean updateQuestion(Service service) {
        return serviceDao.updateQuestion(service);
    }
}
