package dao.file;

import bean.pojo.Risk;
import bean.vo.RiskVo;

import java.util.List;

public interface RiskDao {
    List<RiskVo> getlist(Object [] obj);

    long delete(Long riskId);

    int insert(Object[] obj);

    int update(Object[] obj);
}
