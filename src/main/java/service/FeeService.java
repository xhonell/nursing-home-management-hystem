package service;

import bean.dto.fee.FeeCreateDto;
import bean.dto.fee.FeeQueryDto;
import bean.dto.fee.FeeUpdateDto;
import bean.dto.visitor.VisitorCreateDto;
import bean.dto.visitor.VisitorQueryDto;
import bean.dto.visitor.VisitorUpdateDto;
import bean.pojo.Fee;
import bean.vo.FeeQueryVo;
import bean.vo.VisitorQueryVo;

/**
 * service
 * User: hrj
 * Date: 2024/12/23 11:16
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public interface FeeService {
    FeeQueryVo list(FeeQueryDto feeQueryDto);
    boolean update(FeeUpdateDto feeUpdateDto);
    boolean create(FeeCreateDto feeCreateDto);
}
