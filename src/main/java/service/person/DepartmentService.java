package service.person;

import bean.pojo.Department;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public interface DepartmentService {
    List<Department> findAllDepartmentList();
}
