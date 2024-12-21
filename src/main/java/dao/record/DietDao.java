package dao.record;

import bean.pojo.Diet;

import java.util.List;

public interface DietDao {
    Long listCount(Object[] params);

    List<Diet> list(Object[] params);

    int update(Object[] params);

    int create(Object[] params);

    int delete(Integer dietId);
}
