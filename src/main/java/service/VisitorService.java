package service;

import bean.dto.visitor.VisitorCreateDto;
import bean.dto.visitor.VisitorQueryDto;
import bean.dto.visitor.VisitorUpdateDto;
import bean.vo.VisitorQueryVo;

/**
 * service
 * User: hrj
 * Date: 2024/12/19 10:06
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public interface VisitorService {
    VisitorQueryVo list(VisitorQueryDto visitorQueryDto);
    boolean update(VisitorUpdateDto visitorUpdateDto);
    boolean create(VisitorCreateDto visitorCreateDto);
    boolean delete(Long visitorId);
}
