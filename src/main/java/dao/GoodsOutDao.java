package dao;

import bean.vo.GoodsOutVo;
import bean.vo.GoodsVo;

import java.util.List;

public interface GoodsOutDao {
    List<GoodsOutVo> getList(Object[] obj);
    int delete(long id);
    int create(Object[] params);
    int update(Object[] params);
}
