package servlet.file;

import bean.vo.RiskVo;
import commons.BaseServlet;
import commons.Write;
import service.file.RiskService;
import service.impl.file.RiskServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/risk/*")
public class RiskServlet  extends BaseServlet {
    RiskService riskService=new RiskServiceImpl();
    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String riskLevel = request.getParameter("riskLevel");
        String olderName = request.getParameter("olderName");
        Object [] obj={
                riskLevel,
                olderName,
                (Integer.parseInt(page)-1)*Integer.parseInt(limit),
                Integer.parseInt(limit)
        };
        List<RiskVo>list=riskService.getlist(obj);
        if (list!=null){
            Write.writeSuccess(response,list,"查询成功");
        }else {
            Write.writeFail(response,"查询失败");
        }
        }
        public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
            String riskId = request.getParameter("riskId");
            Boolean isSuccess = riskService.delete(Long.parseLong(riskId));
            if (isSuccess) {
                Write.writeSuccess(response,"删除成功");
            }else {
                Write.writeFail(response,"删除失败");
            }
        }
        public void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
            String riskLevel = request.getParameter("riskLevel");
            String riskWarn = request.getParameter("riskWarn");
            String riskPlan = request.getParameter("riskPlan");
            String olderId = request.getParameter("olderId");
            Object [] obj={
                    riskLevel,
                    riskWarn,
                    riskPlan,
                    olderId
            };
            Boolean isSuccess = riskService.insert(obj);
            if (isSuccess) {
                Write.writeSuccess(response,"添加成功");
            }else {
                Write.writeFail(response,"添加失败");
            }
        }
        public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
            String riskLevel = request.getParameter("riskLevel");
            String riskWarn = request.getParameter("riskWarn");
            String riskPlan = request.getParameter("riskPlan");
            String olderId = request.getParameter("olderId");
            String riskId = request.getParameter("riskId");
            Object [] obj={
                    riskLevel,
                    riskWarn,
                    riskPlan,
                    olderId,
                    riskId
            };
            Boolean isSuccess = riskService.update(obj);
            if (isSuccess) {
                Write.writeSuccess(response,"修改成功");
            }else {
                Write.writeFail(response,"修改失败");
            }
        }
}

