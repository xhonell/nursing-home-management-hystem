package servlet.person;
/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */

import bean.pojo.Position;
import com.alibaba.fastjson.JSON;
import commons.BaseServlet;
import commons.MyFormatUtils;
import commons.R;
import service.impl.person.PositionServiceImpl;
import service.person.PositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/position/*")
public class PositionServlet extends BaseServlet {
    public void findPositionByDepartmentIdList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer departmentId = MyFormatUtils.toInteger(request.getParameter("departmentId"));
        Position position=new Position();
        position.setDepartmentId(departmentId);
        PositionService positionService=new PositionServiceImpl();
        List<Position> positionList=positionService.findPositionByDepartmentIdList(position);
        R r=positionList.size()>0? R.ok().addData("positionList",positionList):R.error("没有任何职位信息");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void findPositionAllList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PositionService positionService=new PositionServiceImpl();
        List<Position> positionAllList=positionService.findPositionAllList();
        R r=positionAllList.size()>0? R.ok().addData("positionAllList",positionAllList):R.error("没有任何职位信息");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }
}
