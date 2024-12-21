package dao;

import bean.pojo.Equip;
import bean.pojo.Grade;

import java.util.List;

public interface GradeDao {
    List<Grade> getList(Object[] obj);
    int delete(long id);
    int create(Object[] params);
    int update(Object[] params);
}
