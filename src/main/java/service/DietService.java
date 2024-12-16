package service;

import bean.dto.diet.DietCreateDto;
import bean.dto.diet.DietQueryDto;
import bean.dto.diet.DietUpdateDto;
import bean.vo.DietQueryVo;

/**
 * program: nursing-home-management-system
 * ClassName DietService
 * description:
 * author: xhonell
 * create: 2024年12月16日15时21分
 * Version 1.0
 **/
public interface DietService {
    DietQueryVo list(DietQueryDto dietQueryDto);

    boolean update(DietUpdateDto dietUpdateDto);

    boolean create(DietCreateDto dietCreateDto);

    boolean delete(Integer dietId);
}
