package service;

import bean.dto.equit.EquipCreateDto;
import bean.dto.equit.EquipUpdateDto;
import bean.dto.goods.GoodsCreateDto;
import bean.dto.goods.GoodsUpdateDto;
import bean.pojo.Equip;
import bean.pojo.Goods;
import bean.vo.GoodsVo;

import java.util.List;

public interface GoodsService {
    List<GoodsVo> getList(Object[] obj);

    boolean delete(Integer goodsId);

    boolean create(GoodsCreateDto goodsCreateDto);

    boolean update(GoodsUpdateDto goodsUpdateDto);
}
