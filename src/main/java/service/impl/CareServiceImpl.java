package service.impl;

import bean.dto.care.CareCreateDto;
import bean.dto.care.CareQueryDto;
import bean.dto.care.CareUpdateDto;
import bean.pojo.Care;
import bean.vo.CareQueryVo;
import dao.CareDao;
import dao.impl.CareDaoImpl;
import service.CareService;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName CareServiceImpl
 * description:
 * author: xhonell
 * create: 2024年12月18日15时16分
 * Version 1.0
 **/
public class CareServiceImpl implements CareService {

    CareDao careDao = new CareDaoImpl();
    /**
     * 根据给定的查询条件，获取护理记录列表和总条数
     *
     * @param careQueryDto 查询条件，包含健康状态、老年人姓名、健康时间、分页起始位置、分页大小等参数
     * @return CareQueryVo 对象，包含查询到的护理记录列表和总条数
     */
    @Override
    public CareQueryVo getlist(CareQueryDto careQueryDto) {
        CareQueryVo careQueryVo = new CareQueryVo();
        Object [] obj={
                careQueryDto.getHealthState(),
                careQueryDto.getOlderName(),
                careQueryDto.getHealthTime(),
                (careQueryDto.getPage()-1)*careQueryDto.getLimit(),
                careQueryDto.getLimit(),
        };
        Long total = careDao.queryTotal(obj);
        careQueryVo.setTotal(total);
        if (total == 0) {
            return careQueryVo;
        }

        List<Care> getlist = careDao.getlist(obj);
        careQueryVo.setList(getlist);
        return careQueryVo;
    }

    /**
     * 更新护理记录
     *
     * @param careUpdateDto 包含要更新的护理记录信息的CareUpdateDto对象
     * @return 如果更新成功，则返回true；否则返回false
     */
    @Override
    public boolean update(CareUpdateDto careUpdateDto) {
        Object [] params={
                careUpdateDto.getCareContent(),
                careUpdateDto.getCareTime(),
                careUpdateDto.getDoctorId(),
                careUpdateDto.getOlderId(),
                careUpdateDto.getCareId(),
        };
        return careDao.update(params) > 0;
    }

    /**
     * 创建护理信息
     *
     * @param careCreateDto 包含护理信息的对象
     * @return 如果创建成功返回true，否则返回false
     */
    @Override
    public boolean create(CareCreateDto careCreateDto) {
        Object [] params={
                careCreateDto.getCareContent(),
                careCreateDto.getCareTime(),
                careCreateDto.getDoctorId(),
                careCreateDto.getOlderId(),
        };
        return careDao.create(params) >  0;
    }

    @Override
    public boolean delete(Integer careId) {
        return careDao.delete(careId) > 0;
    }
}
