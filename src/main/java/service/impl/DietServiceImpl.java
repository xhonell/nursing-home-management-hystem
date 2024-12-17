package service.impl;

import bean.dto.diet.DietCreateDto;
import bean.dto.diet.DietQueryDto;
import bean.dto.diet.DietUpdateDto;
import bean.vo.DietQueryVo;
import dao.DietDao;
import dao.impl.DietDaoImpl;
import service.DietService;

/**
 * program: nursing-home-management-system
 * ClassName DietServiceImpl
 * description:
 * author: xhonell
 * create: 2024年12月16日15时21分
 * Version 1.0
 **/
public class DietServiceImpl implements DietService {
    DietDao dietDao = new DietDaoImpl();
    /**
     * 根据饮食查询条件获取饮食信息列表和总数
     *
     * @param dietQueryDto 包含饮食查询条件的对象
     * @return 包含饮食信息列表和总数的DietQueryVo对象
     */
    @Override
    public DietQueryVo list(DietQueryDto dietQueryDto) {
        DietQueryVo dietQueryVo = new DietQueryVo();
        Object[] params = {
                dietQueryDto.getDietFood(),
                dietQueryDto.getDietTime(),
                (dietQueryDto.getPage()-1)*dietQueryDto.getLimit(),
                dietQueryDto.getLimit()
        } ;
        Long count = dietDao.listCount(params);
        dietQueryVo.setCount(count);
        if (count != 0) {
            dietQueryVo.setList(dietDao.list(params));
        }
        return dietQueryVo;
    }

    /**
     * 更新饮食信息
     *
     * @param dietUpdateDto 包含饮食更新信息的对象
     * @return 如果更新成功，则返回true；否则返回false
     */
    @Override
    public boolean update(DietUpdateDto dietUpdateDto) {
        Object[] params = {
                dietUpdateDto.getDietFood(),
                dietUpdateDto.getDietTime(),
                dietUpdateDto.getDietId()
        };
        return dietDao.update(params) > 0;
    }

    /**
     * 创建新的饮食记录
     *
     * @param dietCreateDto 包含创建饮食记录所需信息的对象
     * @return 如果创建成功，则返回true；否则返回false
     */
    @Override
    public boolean create(DietCreateDto dietCreateDto) {
        Object[] params = {
                dietCreateDto.getDietFood(),
                dietCreateDto.getDietTime(),
                dietCreateDto.getDoctorId()
        };
        return dietDao.create(params) > 0;
    }

    /**
     * 根据饮食ID删除对应的饮食记录
     *
     * @param dietId 饮食记录的ID
     * @return 如果删除成功，则返回true；否则返回false
     */
    @Override
    public boolean delete(Integer dietId) {
        return dietDao.delete(dietId) > 0;

    }
}
