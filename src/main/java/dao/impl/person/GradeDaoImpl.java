package dao.impl.person;

import bean.vo.GradeList;
import commons.DBHelper;
import dao.person.GradeDao;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/19
 * Description:
 * Version: V1.0
 */
public class GradeDaoImpl implements GradeDao {
    DBHelper dbHelper=new DBHelper();
    @Override
    public List<GradeList> findAllGradeList() {
        String sql="select distinct gradeId,gradeName from grade";
        return dbHelper.getBeanList(GradeList.class,sql);
    }
}
