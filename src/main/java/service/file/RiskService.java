package service.file;

import bean.vo.RiskVo;

import java.util.List;

public interface RiskService {
    List<RiskVo> getlist(Object [] obj);

    Boolean delete(Long riskId);

    Boolean insert(Object[] obj);

    Boolean update(Object[] obj);
}
