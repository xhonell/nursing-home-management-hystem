package service.impl.leave;

import bean.dto.leave.RequestOlderDto;
import bean.pojo.OlderLeave;
import bean.vo.OlderInformationVo;
import dao.impl.leave.OlderLeaveDaoImpl;
import dao.leave.OlderLeaveDao;
import service.leave.OlderLeaveService;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName OlderLeaveServiceImpl
 * description:
 * author: xhonell
 * create: 2024年12月21日10时07分
 * Version 1.0
 **/
public class OlderLeaveServiceImpl implements OlderLeaveService {
    OlderLeaveDao olderLeaveDao = new OlderLeaveDaoImpl();
    /**
     * 根据关系ID获取旧版信息
     *
     * @param relationId 关系ID，用于标识需要查询的旧版信息
     * @return OlderInformationVo 包含旧版信息的对象，如果未找到旧版信息则返回null
     */
    /**
     * 根据关系ID获取旧版信息
     *
     * @param relationId 关系ID
     * @return OlderInformationVo 包含旧版信息的对象
     */
    @Override
    public OlderInformationVo olderInformation(Integer relationId) {
        return olderLeaveDao.olderInformation(relationId);
    }

    /**
     * 请求旧版请假
     *
     * @param requestOlderDto 请求旧版请假的DTO对象，包含旧版ID、关系ID、请假开始时间、请假结束时间和请假原因等信息
     * @return 如果请求成功返回true，否则返回false
     */
    @Override
    public boolean request(RequestOlderDto requestOlderDto) {
        Object[] params = {
                requestOlderDto.getOlderId(),
                requestOlderDto.getRelationId(),
                requestOlderDto.getLeaveStartTime(),
                requestOlderDto.getLeaveEndTime(),
                requestOlderDto.getLeaveReason()
        };
        return olderLeaveDao.request(params) > 0;
    }

    @Override
    public List<OlderLeave> requestInformation(Integer relationId) {
        return olderLeaveDao.requestInformation(relationId);
    }
}
