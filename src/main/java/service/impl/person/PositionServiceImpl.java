package service.impl.person;

import bean.pojo.Position;
import dao.impl.person.PositionDaoImpl;
import dao.person.PositionDao;
import service.person.PositionService;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public class PositionServiceImpl implements PositionService {
    private PositionDao positionDao=new PositionDaoImpl();
    @Override
    public List<Position> findPositionByDepartmentIdList(Position position) {
        return positionDao.findPositionByDepartmentIdList(position);
    }

    @Override
    public List<Position> findPositionAllList() {
        return positionDao.findPositionAllList();
    }
}
