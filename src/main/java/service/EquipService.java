package service;

import bean.dto.diet.DietCreateDto;
import bean.dto.diet.DietUpdateDto;
import bean.dto.equit.EquipCreateDto;
import bean.dto.equit.EquipUpdateDto;
import bean.pojo.Equip;

import java.util.List;

public interface EquipService {
    List<Equip> getList(Object[] obj);

    boolean delete(Integer equipId);

    boolean create(EquipCreateDto equipCreateDto);

    boolean update(EquipUpdateDto equipUpdateDto);
}
