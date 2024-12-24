package service;

import bean.dto.GoodsOut.GoodsOutCreateDto;
import bean.dto.GoodsOut.GoodsOutUpdateDto;
import bean.dto.goods.GoodsCreateDto;
import bean.dto.goods.GoodsUpdateDto;
import bean.vo.GoodsOutVo;

import java.util.List;

public interface GoodsOutService {
    List<GoodsOutVo> getList(Object[] obj);

    boolean delete(Integer goodsOutId);

    boolean create(GoodsOutCreateDto goodsOutCreateDto);

    boolean update(GoodsOutUpdateDto goodsOutUpdateDto);
}
