package dao;

import bean.pojo.Health;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName healthDao
 * description:
 * author: xhonell
 * create: 2024年12月17日11时28分
 * Version 1.0
 **/
public interface HealthDao {
    List<Health> list(Object[] params);

    Long queryTotal(Object[] params);

    int update(Object[] params);

    List<Object> getOlderName();

    List<Object> getOlderId();

    int create(Object[] params);

    int delete(long id);
}
