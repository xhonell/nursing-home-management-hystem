package servlet.person; /**
 * User: zhongjing
 * Date: 2024/12/18
 * Description:
 * Version: V1.0
 */

import bean.dto.OlderFindByPage;
import bean.pojo.Older;
import bean.vo.OlderHealthList;
import bean.vo.OlderList;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import commons.BaseServlet;
import commons.MyFormatUtils;
import commons.R;
import service.impl.person.OlderServiceImpl;
import service.person.OlderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@WebServlet("/older/*")
public class OlderServlet extends BaseServlet {
    /**
     * 查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String olderName = MyFormatUtils.trim(request.getParameter("olderName"));
        String olderSex = MyFormatUtils.trim(request.getParameter("olderSex"));
        Integer olderAge = MyFormatUtils.toInteger(request.getParameter("olderAge"));
        Date olderBirth = MyFormatUtils.toDate(request.getParameter("olderBirth"));
        String olderHealth = MyFormatUtils.trim(request.getParameter("olderHealth"));
        LocalDateTime olderStartTime = MyFormatUtils.toDateTime(request.getParameter("olderStartTime"));
        LocalDateTime olderEndTime = MyFormatUtils.toDateTime(request.getParameter("olderEndTime"));
        Integer gradeId = MyFormatUtils.toInteger(request.getParameter("gradeId"));
        Integer page = MyFormatUtils.toInteger(request.getParameter("page"));
        Integer limit = MyFormatUtils.toInteger(request.getParameter("limit"));
        OlderFindByPage olderFindByPage=new OlderFindByPage();
        olderFindByPage.setOlderName(olderName);
        olderFindByPage.setOlderSex(olderSex);
        olderFindByPage.setOlderAge(olderAge);
        olderFindByPage.setOlderBirth(olderBirth);
        olderFindByPage.setOlderHealth(olderHealth);
        olderFindByPage.setOlderStartTime(olderStartTime);
        olderFindByPage.setOlderEndTime(olderEndTime);
        olderFindByPage.setGradeId(gradeId);
        olderFindByPage.setPage(page);
        olderFindByPage.setLimit(limit);
        OlderService olderService=new OlderServiceImpl();
        Long total=olderService.findTotal(olderFindByPage);
        List<OlderList> olderList=null;
        if (total>0){
            olderList=olderService.findByPage(olderFindByPage);
        }
        R r=R.ok().addData("total",total).addData("olderList",olderList);
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void addOlder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader reader = request.getReader();
        String str="";
        str=reader.readLine();
        Older older = JSONObject.parseObject(str, Older.class);
        OlderService olderService=new OlderServiceImpl();
        Boolean t=olderService.addOlder(older);
        R r=t?R.ok():R.error("添加失败");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void updateOlder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader reader = request.getReader();
        String str="";
        str=reader.readLine();
        Older older = JSONObject.parseObject(str, Older.class);
        OlderService olderService=new OlderServiceImpl();
        Boolean t=olderService.updateOlder(older);
        R r=t?R.ok():R.error("修改失败");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void deleteOlder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer olderId = MyFormatUtils.toInteger(request.getParameter("olderId"));
        Older older=new Older();
        older.setOlderId(olderId);
        OlderService olderService=new OlderServiceImpl();
        Boolean t=olderService.deleteOlder(older);
        R r=t?R.ok():R.error("删除失败");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void findAllOlderHealthList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        OlderService olderService=new OlderServiceImpl();
        List<OlderHealthList> olderHealthList=olderService.findAllOlderHealthList();
        R r=olderHealthList.size()>0?R.ok().addData("olderHealthList",olderHealthList):R.error("没有任何健康信息");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }
}
