package dao.impl.file;

import bean.vo.RoomVo;
import commons.DataSourceUtil;
import dao.file.RoomDao;

import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {

    @Override
    public List<RoomVo> getlist(Object[] obj) {
        List<Object> list = new ArrayList<>();
        StringBuilder sql= new StringBuilder("select r.roomId,r.roomName,d.doctorId,d.doctorName,o.olderId,o.olderName from room r " +
                "JOIN doctor d ON r.doctorId=d.doctorId " +
                "JOIN older o ON r.olderId=o.olderId where 1=1");
        if (obj[0]!=null&&!(String.valueOf(obj[0]).trim().isEmpty())){
            sql.append(" and r.roomName like concat('%',?,'%')");
            list.add(obj[0]);
        }
        if (obj[1]!=null&&!(String.valueOf(obj[1]).trim().isEmpty())){
            sql.append(" and d.doctorName like concat('%',?,'%')");
            list.add(obj[1]);
        }
        if (obj[2]!=null&&!(String.valueOf(obj[2]).trim().isEmpty())){
            sql.append(" and o.olderName like concat('%',?,'%')");
            list.add(obj[2]);
        }
        sql.append(" limit ?,?");
        list.add(obj[3]);
        list.add(obj[4]);
        return DataSourceUtil.queryToBeanListHandler(sql.toString(), RoomVo.class, list.toArray());
    }
    @Override
    public long delete(long roomId) {
        String sql = "delete from room where roomId=?";
        return DataSourceUtil.update(sql, roomId);
    }

    @Override
    public int insert(Object[] obj) {
        String sql = "insert into room(roomName,doctorId,olderId) values (?,?,?)";
        return DataSourceUtil.update(sql, obj);
    }

    @Override
    public int update(Object[] obj) {
        String sql = "update room set roomName=?,doctorId=?,olderId=? where roomId=?";
        return DataSourceUtil.update(sql, obj);
    }
}
