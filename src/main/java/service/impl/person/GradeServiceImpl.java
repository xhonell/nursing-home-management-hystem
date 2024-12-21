package service.impl.person;

import bean.vo.GradeList;
import dao.impl.person.GradeDaoImpl;
import dao.person.GradeDao;
import service.person.GradeService;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/19
 * Description:
 * Version: V1.0
 */
public class GradeServiceImpl implements GradeService {
    private GradeDao gradeDao=new GradeDaoImpl();
    @Override
    public List<GradeList> findAllGradeList() {
        return gradeDao.findAllGradeList();
    }
}
