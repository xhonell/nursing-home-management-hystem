package dao.impl.file;

import bean.vo.ActivityVo;
import commons.DataSourceUtil;
import dao.file.ActivityDao;

import java.util.ArrayList;
import java.util.List;

public class ActivityDaoImpl implements ActivityDao {
    @Override
    public List<ActivityVo> getlist(Object[] arr) {
        List<Object> list = new ArrayList<>(); // 封装参数
        StringBuilder sql = new StringBuilder("select a.activityId,a.activityName,a.activityTime,a.activityAddress,a.activityContent,d.doctorName,d.doctorId" +
                " from activity a JOIN doctor d ON a.doctorId=d.doctorId where 1=1");
        if (arr[0] != null && !(String.valueOf(arr[0]).trim().isEmpty())) {
            sql.append(" and activityName like concat('%',?,'%')");
            list.add(String.valueOf(arr[0]));
        }
        if (arr[1] != null && !(String.valueOf(arr[1]).trim().isEmpty())) {
            sql.append(" and activityAddress like concat('%',?,'%')");
            list.add(String.valueOf(arr[1]));
        }
        if (arr[2] != null && !(String.valueOf(arr[2]).trim().isEmpty())) {
            sql.append(" and doctorName like concat('%',?,'%')");
            list.add(String.valueOf(arr[2]));
        }
        sql.append(" limit ?,?");
        list.add(arr[3]);
        list.add(arr[4]);
        return DataSourceUtil.queryToBeanListHandler(sql.toString(), ActivityVo.class,list.toArray());
    }

    @Override
    public long delete(Long activityId) {
        String sql = "delete from activity where activityId=?";
        return DataSourceUtil.update(sql,activityId);
    }

    @Override
    public int update(Object[] arr) {
        String sql = "update activity set activityName=?,activityTime=?,activityAddress=?,activityContent=? where activityId=?";

        return DataSourceUtil.update(sql,arr);
    }

    @Override
    public int insert(Object[] arr) {
        String sql = "insert into activity(activityName,activityTime,activityAddress,activityContent,doctorId) values (?,?,?,?,?)";
        return DataSourceUtil.update(sql,arr);
    }


}
