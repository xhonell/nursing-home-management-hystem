package service.file;

import bean.vo.RoomVo;

import java.util.List;

public interface RoomService {
    List<RoomVo> getlist(Object[] obj);

    Boolean delete(long roomId);

    Boolean insert(Object[] obj);
    Boolean update(Object[] obj);
}
