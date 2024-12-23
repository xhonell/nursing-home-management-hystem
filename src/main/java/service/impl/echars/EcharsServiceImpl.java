package service.impl.echars;

import bean.pojo.Fee;
import bean.vo.EcharsAgeVo;
import dao.echars.EcharsDao;
import dao.impl.echars.EcharsDaoImpl;
import service.echars.EcharsService;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName EcharsServiceImpl
 * description:
 * author: xhonell
 * create: 2024年12月22日10时38分
 * Version 1.0
 **/
public class EcharsServiceImpl implements EcharsService {
    EcharsDao echarsDao = new EcharsDaoImpl();
    @Override
    public List<EcharsAgeVo> getEcharsAge() {
        return echarsDao.getEcharsAge();
    }

    @Override
    public Fee getArrears(Integer relationId) {
        return echarsDao.getArrears(relationId);
    }

    @Override
    public boolean setArrears(Integer relationId) {
        return echarsDao.setArrears(relationId) > 0;
    }
}
