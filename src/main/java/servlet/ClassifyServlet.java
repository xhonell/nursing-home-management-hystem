package servlet;

import bean.dto.ClassifyDto.ClassifyCreateDto;
import bean.dto.ClassifyDto.ClassifyUpdateDto;
import bean.dto.goods.GoodsCreateDto;
import bean.pojo.Classify;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.ClassifyService;
import service.impl.ClassifyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/classify/*")
public class ClassifyServlet extends BaseServlet {
    ClassifyService classifyService = new ClassifyServiceImpl();
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String classifyName = request.getParameter("classifyName");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        Object [] obj = {
                classifyName,
                (Integer.parseInt(page)-1)*Integer.parseInt(limit),
                Integer.parseInt(limit)
        };
        List<Classify> list = classifyService.getList(obj);
        if (list!=null){
            Write.writeSuccess(response,list,"查询成功");
        }else{
            Write.writeFail(response,"当前无数据");
        }
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer classifyId = Integer.parseInt(request.getParameter("classifyId"));
        boolean isSuccess = classifyService.delete(classifyId);
        if (isSuccess) {
            Write.writeSuccess(response,null,"删除成功");
        } else {
            Write.writeFail(response,"删除失败");
        }
    }
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClassifyCreateDto classifyCreateDto = GetJsonParamsUtils.receiveJsonToPojo(req, ClassifyCreateDto.class);
        boolean isSuccess = classifyService.create(classifyCreateDto);
        if (isSuccess) {
            Write.writeSuccess(resp,null,"创建成功");
        } else {
            Write.writeFail(resp,"创建失败");
        }
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClassifyUpdateDto classifyUpdateDto = GetJsonParamsUtils.receiveJsonToPojo(req, ClassifyUpdateDto.class);
        boolean isSuccess = classifyService.update(classifyUpdateDto);
        if (isSuccess) {
            Write.writeSuccess(resp,null,"更新成功");
        } else {
            Write.writeFail(resp,"更新失败");
        }
    }
}
