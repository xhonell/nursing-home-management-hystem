package servlet;

import bean.dto.grade.GradeCreateDto;
import bean.dto.grade.GradeUpdateDto;
import bean.pojo.Grade;
import bean.vo.GradeList;
import com.alibaba.fastjson.JSON;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.R;
import commons.Write;
import service.GradeService;
import service.impl.GradeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/grade/*")
public class GradeServlet extends BaseServlet {
    GradeService gradeService = new GradeServiceImpl();
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String limit = request.  getParameter("limit");
        String gradeName = request.getParameter("gradeName");
        String gradeContent = request.getParameter("gradeContent");
        Object [] obj = {
                gradeName,
                gradeContent,
                // 当前页数-1*条数 （当前页之前的条数）
                (Integer.parseInt(page)-1) * Integer.parseInt(limit),
                Integer.parseInt(limit)
        };
        //实例化
        GradeService gradeService = new GradeServiceImpl();
        List<Grade> list = gradeService.getList(obj);
        if (list!=null){
            Write.writeSuccess(response,list,"查询成功");
        }else{
            Write.writeFail(response,"当前无数据");
        }
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer gradeId = Integer.parseInt(request.getParameter("gradeId"));
        //实例化
        GradeService gradeService = new GradeServiceImpl();
        boolean isSuccess = gradeService.delete(gradeId);
        if (isSuccess) {
            Write.writeSuccess(response,null,"删除成功");
        } else {
            Write.writeFail(response,"删除失败");
        }
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) {
        // 将请求中的JSON数据转换为EquipCreateDto对象
        GradeCreateDto gradeCreateDto = GetJsonParamsUtils.receiveJsonToPojo(req, GradeCreateDto.class);
        boolean isSuccess = gradeService.create(gradeCreateDto);
        if (isSuccess) {
            Write.writeSuccess(resp,null,"创建成功");
        } else {
            Write.writeFail(resp,"创建失败");
        }
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) {
        GradeUpdateDto gradeUpdateDto = GetJsonParamsUtils.receiveJsonToPojo(req, GradeUpdateDto.class);
        boolean update = gradeService.update(gradeUpdateDto);
        if (update) {
            Write.writeSuccess(resp,null,"更新成功");
        } else {
            Write.writeFail(resp,"更新失败");
        }
    }

    public void findAllGradeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service.person.GradeService gradeService=new service.impl.person.GradeServiceImpl();
        List<GradeList> gradeList=gradeService.findAllGradeList();
        R r=gradeList.size()>0? R.ok().addData("gradeList",gradeList):R.error("没有任何医护等级信息");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }
}
