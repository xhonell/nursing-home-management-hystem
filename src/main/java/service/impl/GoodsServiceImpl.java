package service.impl;

import bean.dto.equit.EquipCreateDto;
import bean.dto.equit.EquipUpdateDto;
import bean.dto.goods.GoodsCreateDto;
import bean.dto.goods.GoodsUpdateDto;
import bean.pojo.Equip;
import bean.pojo.Goods;
import bean.vo.GoodsVo;
import dao.EquipDao;
import dao.GoodsDao;
import dao.impl.EquipDaoImpl;
import dao.impl.GoodsDaoImpl;
import service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public List<GoodsVo> getList(Object[] obj) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        return goodsDao.getList(obj);
    }
    @Override
    public boolean delete(Integer goodsId){
        //判断返回行数是否大于1，是则返回true
        return goodsDao.delete(goodsId) > 0;
    }
    @Override
    public boolean create(GoodsCreateDto goodsCreateDto){
        Object[] params = {
                goodsCreateDto.getGoodsName(),
                goodsCreateDto.getGoodsPrice(),
                goodsCreateDto.getGoodsNumber(),
                goodsCreateDto.getGoodsInDepot(),
                goodsCreateDto.getGoodsProvider(),
                goodsCreateDto.getGoodsStartDate(),
                goodsCreateDto.getClassifyId(),
                goodsCreateDto.getClassifyName()
        };
        return goodsDao.create(params) > 0;
    }

    @Override
    public boolean update(GoodsUpdateDto goodsUpdateDto) {
        Object[] params = {
                goodsUpdateDto.getGoodsName(),
                goodsUpdateDto.getGoodsPrice(),
                goodsUpdateDto.getGoodsNumber(),
                goodsUpdateDto.getGoodsInDepot(),
                goodsUpdateDto.getGoodsProvider(),
                goodsUpdateDto.getGoodsStartDate(),
                goodsUpdateDto.getClassifyId(),
                goodsUpdateDto.getGoodsId(),
                goodsUpdateDto.getClassifyName()
        };
        return goodsDao.update(params) > 0;
    }
}
