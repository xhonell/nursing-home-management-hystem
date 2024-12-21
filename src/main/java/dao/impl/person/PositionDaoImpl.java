package dao.impl.person;

import bean.pojo.Position;
import commons.DBHelper;
import dao.person.PositionDao;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public class PositionDaoImpl implements PositionDao {
    DBHelper dbHelper=new DBHelper();
    @Override
    public List<Position> findPositionByDepartmentIdList(Position position) {
        StringBuffer sql=new StringBuffer("select positionId,positionName from position where 1=1 ");
        List<Object> parameters=new ArrayList<>();
        if (position.getDepartmentId()!=null){
            sql.append("and departmentId=?");
            parameters.add(position.getDepartmentId());
        }
        return dbHelper.getBeanList(Position.class,sql.toString(),parameters.toArray());
    }

    @Override
    public List<Position> findPositionAllList() {
        String sql="select positionId,positionName from position";
        return dbHelper.getBeanList(Position.class,sql);
    }
}
