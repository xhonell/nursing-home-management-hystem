package service.record;

import bean.dto.care.CareCreateDto;
import bean.dto.care.CareQueryDto;
import bean.dto.care.CareUpdateDto;
import bean.vo.CareQueryVo;

/**
 * program: nursing-home-management-system
 * ClassName CareService
 * description:
 * author: xhonell
 * create: 2024年12月18日15时15分
 * Version 1.0
 **/
public interface CareService {
    CareQueryVo getlist(CareQueryDto careQueryDto);

    boolean update(CareUpdateDto careUpdateDto);

    boolean create(CareCreateDto careCreateDto);

    boolean delete(Integer careId);
}
