package service;

import bean.dto.look.LookCreateDto;
import bean.dto.look.LookQueryDto;
import bean.dto.look.LookUpdateDto;
import bean.vo.LookQueryVo;

/**
 * service
 * User: hrj
 * Date: 2024/12/20 14:11
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public interface LookService {

    /**
     * 查询探望记录
     *
     * @param lookQueryDto 查询条件
     * @return 查询结果
     */
    LookQueryVo list(LookQueryDto lookQueryDto);

    /**
     * 更新探望记录
     *
     * @param lookUpdateDto 更新信息
     * @return 是否更新成功
     */
    boolean update(LookUpdateDto lookUpdateDto);

    /**
     * 创建新的探望记录
     *
     * @param lookCreateDto 新增信息
     * @return 是否创建成功
     */
    boolean create(LookCreateDto lookCreateDto);

    /**
     * 删除探望记录
     *
     * @param lookId 记录ID
     * @return 是否删除成功
     */
    boolean delete(Long lookId);
}