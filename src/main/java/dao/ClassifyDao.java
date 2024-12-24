package dao;

import bean.pojo.Classify;

import java.util.List;

public interface ClassifyDao {
    public List<Classify> getList(Object[] obj);
    public int delete(long id);
    public int create(Object[] params);
    public int update(Object[] params);
}
