package dao;

import bean.pojo.Equip;
import bean.pojo.Goods;
import bean.vo.GoodsVo;

import java.util.List;

public interface GoodsDao {
    List<GoodsVo> getList(Object[] obj);
}