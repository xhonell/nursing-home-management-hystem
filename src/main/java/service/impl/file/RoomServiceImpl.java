package service.impl.file;

import bean.vo.RoomVo;
import commons.DataSourceUtil;
import dao.file.RoomDao;
import dao.impl.file.RoomDaoImpl;
import service.file.RoomService;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    @Override
    public List<RoomVo> getlist(Object[] obj) {
        RoomDao roomDao = new RoomDaoImpl();
        return roomDao.getlist(obj);
    }

    @Override
    public Boolean delete(long roomId) {
        RoomDao roomDao = new RoomDaoImpl();
        return roomDao.delete(roomId)>0;
    }

    @Override
    public Boolean insert(Object[] obj) {
        RoomDao roomDao = new RoomDaoImpl();
        return roomDao.insert(obj) > 0;
    }

    @Override
    public Boolean update(Object[] obj) {
        RoomDao roomDao = new RoomDaoImpl();
        return roomDao.update(obj) > 0;
    }
}
