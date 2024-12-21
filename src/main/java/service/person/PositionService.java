package service.person;

import bean.pojo.Position;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public interface PositionService {
    List<Position> findPositionByDepartmentIdList(Position position);

    List<Position> findPositionAllList();
}
