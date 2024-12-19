package service.impl.record;

import bean.dto.health.HealthCreateDto;
import bean.dto.health.HealthQueryDto;
import bean.dto.health.HealthUpdateDto;
import bean.pojo.Health;
import bean.vo.HealthVo;
import bean.vo.OlderVo;
import dao.record.HealthDao;
import dao.impl.record.HealthDaoImpl;
import service.record.HealthService;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName HealthServiceImpl
 * description:
 * author: xhonell
 * create: 2024年12月17日11时28分
 * Version 1.0
 **/
public class HealthServiceImpl implements HealthService {
    HealthDao healthDao = new HealthDaoImpl();
    /**
     * 查询健康信息列表
     *
     * @param healthQueryDto 查询条件对象
     * @return HealthVo对象，包含健康信息列表及总条数
     */
    @Override
    public HealthVo list(HealthQueryDto healthQueryDto) {
        HealthVo healthVo = new HealthVo();
        Object[] params = {
                healthQueryDto.getHealthState(),
                healthQueryDto.getOlderName(),
                healthQueryDto.getHealthTime(),
                (healthQueryDto.getPage()-1)*healthQueryDto.getLimit(),
                healthQueryDto.getLimit()
        };

        Long total = healthDao.queryTotal(params);
        healthVo.setTotal(total);
        if (total > 0){
            List<Health> list = healthDao.list(params);
            healthVo.setHealthList(list);
        }
        return healthVo;
    }

    /**
     * 更新健康信息
     *
     * @param healthUpdateDto 健康更新数据传输对象，包含需要更新的健康信息
     * @return boolean 如果更新成功，则返回true；否则返回false
     */
    @Override
    public boolean update(HealthUpdateDto healthUpdateDto) {
        Object[] params = {
                healthUpdateDto.getHealthState(),
                healthUpdateDto.getHealthHeight(),
                healthUpdateDto.getHealthWeight(),
                healthUpdateDto.getHealthBlood(),
                healthUpdateDto.getHealthHeart(),
                healthUpdateDto.getHealthTime(),
                healthUpdateDto.getOlderId(),
                healthUpdateDto.getDoctorId(),
                healthUpdateDto.getHealthId(),
        };
        return healthDao.update(params) > 0;
    }

    /**
     * 获取老人的姓名和ID信息
     *
     * @return OlderVo对象，包含老人的姓名和ID列表
     */
    @Override
    public OlderVo getOlderName() {
        OlderVo olderVo = new OlderVo();
        Object[] olderNames = healthDao.getOlderName().toArray();
        Object[] olderIds = healthDao.getOlderId().toArray();
        olderVo.setOlderIds(olderIds);
        olderVo.setOlderNames(olderNames);
        return olderVo;
    }

    @Override
    public boolean create(HealthCreateDto healthCreateDto) {
        Object[] params = {
                healthCreateDto.getHealthState(),
                healthCreateDto.getHealthHeight(),
                healthCreateDto.getHealthWeight(),
                healthCreateDto.getHealthBlood(),
                healthCreateDto.getHealthHeart(),
                healthCreateDto.getHealthTime(),
                healthCreateDto.getOlderId(),
                healthCreateDto.getDoctorId(),

        };
        return healthDao.create(params) > 0;
    }

    @Override
    public boolean delete(long id) {
        return healthDao.delete(id) > 0;
    }


}
