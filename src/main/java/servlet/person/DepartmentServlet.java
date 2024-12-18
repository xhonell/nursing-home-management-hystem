package servlet.person;
/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */

import bean.pojo.Department;
import com.alibaba.fastjson.JSON;
import commons.BaseServlet;
import commons.R;
import service.impl.person.DepartmentServiceImpl;
import service.person.DepartmentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/department/*")
public class DepartmentServlet extends BaseServlet {
    public void findAllDepartmentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentService departmentService=new DepartmentServiceImpl();
        List<Department> departmentList= departmentService.findAllDepartmentList();
        R r= departmentList.size()>0?R.ok().addData("departmentList",departmentList):R.error("没有任何部门信息");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }
}
