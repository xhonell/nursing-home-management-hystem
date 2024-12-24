package dao.file;

import bean.pojo.Activity;
import bean.vo.ActivityVo;

import java.util.List;

public interface ActivityDao {
    List<ActivityVo> getlist(Object[] arr);
    long delete(Long activityId);

    int update(Object[] arr);
    int insert(Object[] arr);
}
