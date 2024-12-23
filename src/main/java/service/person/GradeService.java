package service.person;

import bean.vo.GradeList;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/19
 * Description:
 * Version: V1.0
 */
public interface GradeService {
    List<GradeList> findAllGradeList();
}
