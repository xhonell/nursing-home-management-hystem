package service.impl;

import bean.dto.visitor.VisitorCreateDto;
import bean.dto.visitor.VisitorQueryDto;
import bean.dto.visitor.VisitorUpdateDto;
import bean.pojo.Visitor;
import bean.vo.VisitorQueryVo;
import dao.VisitorDao;
import dao.impl.VisitorDaoImpl;
import service.VisitorService;

/**
 * service.impl
 * User: hrj
 * Date: 2024/12/19 10:08
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public class VisitorServiceImpl implements VisitorService {
    private final VisitorDao visitorDao = new VisitorDaoImpl();

    /**
     * 根据访客查询条件获取访客信息列表和总数
     *
     * @param visitorQueryDto 包含访客查询条件的对象
     * @return 包含访客信息列表和总数的VisitorQueryVo对象
     */
    @Override
    public VisitorQueryVo list(VisitorQueryDto visitorQueryDto) {
        VisitorQueryVo visitorQueryVo = new VisitorQueryVo();
        Object[] params = {
                visitorQueryDto.getVisitorName(),
                visitorQueryDto.getVisitTime(),
                (visitorQueryDto.getPage() - 1) * visitorQueryDto.getLimit(),
                visitorQueryDto.getLimit()
        };
        Long count = visitorDao.listCount(params);
        visitorQueryVo.setCount(count);
        if (count != 0) {
            visitorQueryVo.setList(visitorDao.list(params));
        }
        return visitorQueryVo;
    }

    /**
     * 更新访客信息
     *
     * @param visitorUpdateDto 包含访客更新信息的对象
     * @return 如果更新成功，则返回true；否则返回false
     */
    @Override
    public boolean update(VisitorUpdateDto visitorUpdateDto) {
        Visitor visitor = new Visitor(
                visitorUpdateDto.getVisitorId(),
                visitorUpdateDto.getVisitorName(),
                visitorUpdateDto.getVisitorCard(),
                visitorUpdateDto.getVisitTime(),
                visitorUpdateDto.getVisitorReason()
        );
        return visitorDao.updateVisitor(visitor) > 0;
    }

    /**
     * 创建新的访客记录
     *
     * @param visitorCreateDto 包含创建访客记录所需信息的对象
     * @return 如果创建成功，则返回true；否则返回false
     */
    @Override
    public boolean create(VisitorCreateDto visitorCreateDto) {
        Visitor visitor = new Visitor(
                null, // visitorId is typically auto-generated in the database
                visitorCreateDto.getVisitorName(),
                visitorCreateDto.getVisitorCard(),
                visitorCreateDto.getVisitTime(),
                visitorCreateDto.getVisitorReason()
        );
        return visitorDao.insertVisitor(visitor) > 0;
    }

    /**
     * 根据访客ID删除对应的访客记录
     *
     * @param visitorId 访客记录的ID
     * @return 如果删除成功，则返回true；否则返回false
     */
    @Override
    public boolean delete(Long visitorId) {
        return visitorDao.deleteVisitor(visitorId) > 0;
    }
}