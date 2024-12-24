package dao.file;

import bean.vo.RoomVo;

import java.util.List;

public interface RoomDao {
    List<RoomVo> getlist(Object[] obj);

    long delete(long roomId);

    int insert(Object[] obj);

    int update(Object[] obj);
}
