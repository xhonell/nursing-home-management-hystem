package dao.echars;

import bean.pojo.Fee;
import bean.vo.EcharsAgeVo;

import java.util.List;

public interface EcharsDao {
    List<EcharsAgeVo> getEcharsAge();

    Fee getArrears(Integer relationId);

    int setArrears(Integer relationId);
}
