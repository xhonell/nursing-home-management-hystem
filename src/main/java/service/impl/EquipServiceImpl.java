package service.impl;

import bean.dto.equit.EquipCreateDto;
import bean.dto.equit.EquipUpdateDto;
import bean.pojo.Equip;
import dao.EquipDao;
import dao.impl.EquipDaoImpl;
import service.EquipService;

import java.util.List;

public class EquipServiceImpl implements EquipService {
    EquipDao equipDao = new EquipDaoImpl();
    @Override
    public List<Equip> getList(Object[] obj) {
        EquipDao equipDao = new EquipDaoImpl();
        return equipDao.getList(obj);
    }
    @Override
    public boolean delete(Integer equipId){
        EquipDao equipDao = new EquipDaoImpl();
        //判断返回行数是否大于1，是则返回true
        return equipDao.delete(equipId) > 0;
    }
    @Override
    public boolean create(EquipCreateDto equipCreateDto){
        Object[] params = {
                equipCreateDto.getEquipName(),
                equipCreateDto.getEquipPosition(),
                equipCreateDto.getEquipState()
        };
        return equipDao.create(params) > 0;
    }

    @Override
    public boolean update(EquipUpdateDto equipUpdateDto) {
        Object[] params = {
                equipUpdateDto.getEquipName(),
                equipUpdateDto.getEquipPosition(),
                equipUpdateDto.getEquipState(),
                equipUpdateDto.getEquipId()
        };
        return equipDao.update(params) > 0;
    }
}
