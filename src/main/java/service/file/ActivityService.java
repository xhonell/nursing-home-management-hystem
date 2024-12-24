package service.file;

import bean.pojo.Activity;
import bean.vo.ActivityVo;

import java.util.List;

public interface ActivityService {
     Boolean delete(Long activityId);

    List<ActivityVo> getlist(Object[] arr);

    Boolean update(Object[] arr);

    Boolean insert(Object[] arr);
}
