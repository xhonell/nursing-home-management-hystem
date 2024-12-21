package service.impl;

import bean.dto.look.LookCreateDto;
import bean.dto.look.LookQueryDto;
import bean.dto.look.LookUpdateDto;
import bean.vo.LookQueryVo;
import dao.LookDao;
import dao.impl.LookDaoImpl;
import service.LookService;

/**
 * service.impl
 * User: hrj
 * Date: 2024/12/20 14:13
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public class LookServiceImpl implements LookService {
    private final LookDao lookDao = new LookDaoImpl();

    /**
     * 根据探望查询条件获取探望信息列表和总数
     *
     * @param lookQueryDto 包含探望查询条件的对象
     * @return 包含探望信息列表和总数的LookQueryVo对象
     */
    @Override
    public LookQueryVo list(LookQueryDto lookQueryDto) {
        LookQueryVo lookQueryVo = new LookQueryVo();
        Object[] params = {
                lookQueryDto.getOlderId(),
                lookQueryDto.getRelationId(),
                lookQueryDto.getStartTime(),
                lookQueryDto.getEndTime(),
                (lookQueryDto.getPage() - 1) * lookQueryDto.getLimit(),
                lookQueryDto.getLimit()
        };
        Long count = lookDao.listCount(params);
        lookQueryVo.setCount(count);
        if (count != 0) {
            lookQueryVo.setList(lookDao.list(params));
        }
        return lookQueryVo;
    }

    /**
     * 更新探望信息
     *
     * @param lookUpdateDto 包含探望更新信息的对象
     * @return 如果更新成功，则返回true；否则返回false
     */
    @Override
    public boolean update(LookUpdateDto lookUpdateDto) {
        Object[] params = {
                lookUpdateDto.getLookTime(),
                lookUpdateDto.getOlderId(),
                lookUpdateDto.getRelationId(),
                lookUpdateDto.getLookId(),
        };
        return lookDao.update(params) > 0;
    }

    /**
     * 创建新的探望记录
     *
     * @param lookCreateDto 包含创建探望记录所需信息的对象
     * @return 如果创建成功，则返回true；否则返回false
     */
    @Override
    public boolean create(LookCreateDto lookCreateDto) {
        Object[] params = {
                lookCreateDto.getLookTime(),
                lookCreateDto.getOlderId(),
                lookCreateDto.getRelationId(),

        };
        return lookDao.create(params) > 0;
    }

    /**
     * 根据探望ID删除对应的探望记录
     *
     * @param lookId 探望记录的ID
     * @return 如果删除成功，则返回true；否则返回false
     */
    @Override
    public boolean delete(Long lookId) {
        return lookDao.delete(lookId.intValue()) > 0;
    }
}