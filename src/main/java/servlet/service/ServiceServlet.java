package servlet.service; /**
 * User: zhongjing
 * Date: 2024/12/21
 * Description:
 * Version: V1.0
 */

import bean.dto.service.FindQuestion;
import bean.dto.service.FindService;
import bean.pojo.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import commons.BaseServlet;
import commons.MyFormatUtils;
import commons.R;
import service.impl.service.ServiceServiceImpl;
import service.service.ServiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/service/*")
public class ServiceServlet extends BaseServlet {
    public void findService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceIsOk = MyFormatUtils.trim(request.getParameter("serviceIsOk"));
        String serviceIsAgree = MyFormatUtils.trim(request.getParameter("serviceIsAgree"));
        Integer page = MyFormatUtils.toInteger(request.getParameter("page"));
        Integer limit = MyFormatUtils.toInteger(request.getParameter("limit"));
        FindService findService=new FindService();
        findService.setServiceIsOk(serviceIsOk);
        findService.setServiceIsAgree(serviceIsAgree);
        findService.setPage(page);
        findService.setLimit(limit);
        ServiceService serviceService=new ServiceServiceImpl();
        Long total=serviceService.findTotal(findService);
        List<Service> serviceList=null;
        if (total>0){
            serviceList=serviceService.findService(findService);
        }
        R r= R.ok().addData("total",total).addData("serviceList",serviceList);
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void updateService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String str="";
        str=reader.readLine();
        Service service = JSONObject.parseObject(str, Service.class);
        ServiceService serviceService=new ServiceServiceImpl();
        Boolean t=serviceService.updateService(service);
        R r=t?R.ok():R.error("修改失败");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void findQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer relationId = MyFormatUtils.toInteger(request.getParameter("relationId"));
        Integer page = MyFormatUtils.toInteger(request.getParameter("page"));
        Integer limit = MyFormatUtils.toInteger(request.getParameter("limit"));
        FindQuestion findQuestion=new FindQuestion();
        findQuestion.setRelationId(relationId);
        findQuestion.setPage(page);
        findQuestion.setLimit(limit);
        ServiceService serviceService=new ServiceServiceImpl();
        Long total=serviceService.findTotalQuestion(findQuestion);
        List<Service> questionList=null;
        if (total>0){
            questionList=serviceService.findQuestion(findQuestion);
        }
        R r= R.ok().addData("total",total).addData("questionList",questionList);
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void addQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String str="";
        str=reader.readLine();
        Service service = JSONObject.parseObject(str, Service.class);
        ServiceService serviceService=new ServiceServiceImpl();
        Boolean t=serviceService.addQuestion(service);
        R r=t?R.ok():R.error("添加失败");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void updateQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String str="";
        str=reader.readLine();
        Service service = JSONObject.parseObject(str, Service.class);
        ServiceService serviceService=new ServiceServiceImpl();
        Boolean t=serviceService.updateQuestion(service);
        R r=t?R.ok():R.error("修改失败");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }
}
