package service.impl.file;

import bean.pojo.Activity;
import bean.vo.ActivityVo;
import dao.file.ActivityDao;
import dao.impl.file.ActivityDaoImpl;
import service.file.ActivityService;

import java.util.List;

public class ActivityServiceImpl implements ActivityService {
    @Override
    public Boolean delete(Long activityId) {
        ActivityDao activityDao= new ActivityDaoImpl();
        return activityDao.delete(activityId) > 0;
    }

    @Override
    public List<ActivityVo> getlist(Object[] arr) {
        ActivityDao activityDao= new ActivityDaoImpl();
        return activityDao.getlist(arr);
    }

    @Override
    public Boolean update(Object[] arr) {
        ActivityDao activityDao= new ActivityDaoImpl();
        return activityDao.update(arr) > 0;
    }

    @Override
    public Boolean insert(Object[] arr) {
        ActivityDao activityDao= new ActivityDaoImpl();
        return activityDao.insert(arr) > 0;
    }
}
