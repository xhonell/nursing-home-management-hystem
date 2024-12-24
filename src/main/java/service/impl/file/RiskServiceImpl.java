package service.impl.file;

import bean.vo.RiskVo;
import dao.file.RiskDao;
import dao.impl.file.RiskDaoImpl;
import service.file.RiskService;

import java.util.List;

public class RiskServiceImpl implements RiskService {

    @Override
    public List<RiskVo> getlist(Object[] obj) {
        RiskDao riskDao = new RiskDaoImpl();
        return riskDao.getlist(obj);
    }

    @Override
    public Boolean delete(Long riskId) {
        RiskDao riskDao = new RiskDaoImpl();
        return riskDao.delete(riskId) > 0;
    }

    @Override
    public Boolean insert(Object[] obj) {
        RiskDao riskDao = new RiskDaoImpl();
        return riskDao.insert(obj) > 0;
    }

    @Override
    public Boolean update(Object[] obj) {
        RiskDao riskDao = new RiskDaoImpl();
        return riskDao.update(obj) > 0;
    }
}
