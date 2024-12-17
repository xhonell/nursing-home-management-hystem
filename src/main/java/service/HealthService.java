package service;

import bean.dto.health.HealthCreateDto;
import bean.dto.health.HealthQueryDto;
import bean.dto.health.HealthUpdateDto;
import bean.vo.HealthVo;
import bean.vo.OlderVo;

/**
 * program: nursing-home-management-system
 * ClassName HealthService
 * description:
 * author: xhonell
 * create: 2024年12月17日11时28分
 * Version 1.0
 **/
public interface HealthService {
    HealthVo list(HealthQueryDto healthQueryDto);

    boolean update(HealthUpdateDto healthUpdateDto);

    OlderVo getOlderName();

    boolean create(HealthCreateDto healthCreateDto);

    boolean delete(long l);
}
