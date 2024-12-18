package dao.impl.person;

import bean.pojo.Department;
import commons.DBHelper;
import dao.person.DepartmentDao;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public class DepartmentDaoImpl implements DepartmentDao {
    DBHelper dbHelper=new DBHelper();
    @Override
    public List<Department> findAllDepartmentList() {
        String sql="select departmentId,departmentName from department";
        return dbHelper.getBeanList(Department.class, sql);
    }
}
