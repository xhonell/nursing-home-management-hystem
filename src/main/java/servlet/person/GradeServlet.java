package servlet.person; /**
 * User: zhongjing
 * Date: 2024/12/19
 * Description:
 * Version: V1.0
 */

import bean.vo.GradeList;
import com.alibaba.fastjson.JSON;
import commons.BaseServlet;
import commons.R;
import service.impl.person.GradeServiceImpl;
import service.person.GradeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/grade/*")
public class GradeServlet extends BaseServlet {
    public void findAllGradeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GradeService gradeService=new GradeServiceImpl();
        List<GradeList> gradeList=gradeService.findAllGradeList();
        R r=gradeList.size()>0? R.ok().addData("gradeList",gradeList):R.error("没有任何医护等级信息");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }
}
