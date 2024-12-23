package servlet.file;

import bean.pojo.Activity;
import bean.vo.ActivityVo;
import commons.BaseServlet;
import commons.MyFormatUtils;
import commons.Write;
import lombok.Data;
import service.file.ActivityService;

import service.impl.file.ActivityServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;

@WebServlet("/activity/*")
public class ActivityServlet extends BaseServlet {
ActivityService activityService = new ActivityServiceImpl();
    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String activityName = request.getParameter("activityName");
        String activityAddress = request.getParameter("activityAddress");
        String doctorName = request.getParameter("doctorName");
        Object [] arr={
                activityName,
                activityAddress,
                doctorName,
                (Integer.parseInt(page)-1)*Integer.parseInt(limit),
                Integer.parseInt(limit)
        };
        List<ActivityVo>list=activityService.getlist(arr);
        if (list!=null){
                Write.writeSuccess(response,list,"查询成功");
        }else {
            Write.writeFail(response,"查询失败");
        }
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String activityId = request.getParameter("activityId");
        Boolean isSuccess = activityService.delete(Long.parseLong(activityId));
        if (isSuccess){
            Write.writeSuccess(response,"删除成功");
        }else {
            Write.writeFail(response,"删除失败");

        }
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String activityName = request.getParameter("activityName");
        String activityTime = request.getParameter("activityTime");
        Long activityTimeL = Long.parseLong(activityTime);
        Date activityTime1 = new Date(activityTimeL);
        String activityAddress = request.getParameter("activityAddress");
        String activityContent = request.getParameter("activityContent");
        String doctorId = request.getParameter("doctorId");
        String doctorName = request.getParameter("doctorName");
        Object [] arr={
                activityName,
                activityTime1,
                activityAddress,
                activityContent,
                doctorId,
        };
        Boolean isSuccess = activityService.update(arr);
        if (isSuccess){
            Write.writeSuccess(response,"更新成功");
        }else {
            Write.writeFail(response,"更新失败");
        }
    }
    public void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String activityName = request.getParameter("activityName");
        String activityTime = request.getParameter("activityTime");
        Long activityTimeL = Long.parseLong(activityTime);
        Date activityTime1 = new Date(activityTimeL);
        String activityAddress = request.getParameter("activityAddress");
        String activityContent = request.getParameter("activityContent");
        String doctorId = request.getParameter("doctorId");
        Object [] arr={
                activityName,
                activityTime1,
                activityAddress,
                activityContent,
                doctorId,
        };
        Boolean isSuccess = activityService.insert(arr);
        if (isSuccess){
            Write.writeSuccess(response,"添加成功");
        }else {
            Write.writeFail(response,"添加失败");
        }
    }
    }
