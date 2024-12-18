package service.impl.person;

import bean.pojo.Department;
import dao.impl.person.DepartmentDaoImpl;
import dao.person.DepartmentDao;
import service.person.DepartmentService;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao=new DepartmentDaoImpl();
    @Override
    public List<Department> findAllDepartmentList() {
        return departmentDao.findAllDepartmentList();
    }
}
