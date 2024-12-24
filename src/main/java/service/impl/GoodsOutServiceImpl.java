package service.impl;

import bean.dto.GoodsOut.GoodsOutCreateDto;
import bean.dto.GoodsOut.GoodsOutUpdateDto;
import bean.dto.goods.GoodsCreateDto;
import bean.dto.goods.GoodsUpdateDto;
import bean.vo.GoodsOutVo;
import bean.vo.GoodsVo;
import dao.GoodsDao;
import dao.GoodsOutDao;
import dao.impl.GoodsDaoImpl;
import dao.impl.GoodsOutDaoImpl;
import service.GoodsOutService;

import java.util.List;

public class GoodsOutServiceImpl implements GoodsOutService {
    GoodsOutDao goodsOutDao = new GoodsOutDaoImpl();
    @Override
    public List<GoodsOutVo> getList(Object[] obj) {
        GoodsOutDao goodsOutDao = new GoodsOutDaoImpl();
        return goodsOutDao.getList(obj);
    }
    @Override
    public boolean delete(Integer goodsOutId){
        //判断返回行数是否大于1，是则返回true
        return goodsOutDao.delete(goodsOutId) > 0;
    }
    @Override
    public boolean create(GoodsOutCreateDto goodsOutCreateDto){
        Object[] params = {
                goodsOutCreateDto.getGoodsOutNumber(),
                goodsOutCreateDto.getGoodsOutTime(),
                goodsOutCreateDto.getGoodsId(),
                goodsOutCreateDto.getGoodsName()
        };
        return goodsOutDao.create(params) > 0;
    }

    @Override
    public boolean update(GoodsOutUpdateDto goodsOutUpdateDto) {
        Object[] params = {
                goodsOutUpdateDto.getGoodsOutNumber(),
                goodsOutUpdateDto.getGoodsOutTime(),
                goodsOutUpdateDto.getGoodsId(),
                goodsOutUpdateDto.getGoodsOutId(),
                goodsOutUpdateDto.getGoodsName()
        };
        return goodsOutDao.update(params) > 0;
    }
}
