package dao;

import bean.pojo.Equip;

import java.util.List;

public interface EquipDao {
    List<Equip> getList(Object[] obj);
    int delete(long id);
    int create(Object[] params);
    int update(Object[] params);
}
