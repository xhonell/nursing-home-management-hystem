package service.leave;

import bean.dto.leave.RequestOlderDto;
import bean.pojo.OlderLeave;
import bean.vo.OlderInformationVo;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName OlderLeaveService
 * description:
 * author: xhonell
 * create: 2024年12月21日10时06分
 * Version 1.0
 **/
public interface OlderLeaveService {
    OlderInformationVo olderInformation(Integer relationId);

    boolean request(RequestOlderDto requestOlderDto);

    List<OlderLeave> requestInformation(Integer relationId);
}
