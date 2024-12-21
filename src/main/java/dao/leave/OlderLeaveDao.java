package dao.leave;

import bean.pojo.OlderLeave;
import bean.vo.OlderInformationVo;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName OlderLeaveDao
 * description:
 * author: xhonell
 * create: 2024年12月21日10时07分
 * Version 1.0
 **/
public interface OlderLeaveDao {
    OlderInformationVo olderInformation(Integer relationId);

    int request(Object[] params);

    List<OlderLeave> requestInformation(Integer relationId);
}
