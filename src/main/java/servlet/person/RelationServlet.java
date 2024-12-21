package servlet.person; /**
 * User: zhongjing
 * Date: 2024/12/18
 * Description:
 * Version: V1.0
 */

import bean.dto.RelationAndOlder;
import bean.dto.RelationFindByPage;
import bean.pojo.Relation;
import bean.vo.RelationList;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import commons.BaseServlet;
import commons.MyFormatUtils;
import commons.R;
import service.impl.person.RelationServiceImpl;
import service.person.RelationService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/relation/*")
public class RelationServlet extends BaseServlet {
    public void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String relationName = MyFormatUtils.trim(request.getParameter("relationName"));
        String olderName = MyFormatUtils.trim(request.getParameter("olderName"));
        String relationship = MyFormatUtils.trim(request.getParameter("relationship"));
        Integer page = MyFormatUtils.toInteger(request.getParameter("page"));
        Integer limit = MyFormatUtils.toInteger(request.getParameter("limit"));
        RelationFindByPage relationFindByPage=new RelationFindByPage();
        relationFindByPage.setRelationName(relationName);
        relationFindByPage.setOlderName(olderName);
        relationFindByPage.setRelationship(relationship);
        relationFindByPage.setPage(page);
        relationFindByPage.setLimit(limit);
        RelationService relationService=new RelationServiceImpl();
        Long total=relationService.findTotal(relationFindByPage);
        List<RelationList> relationList=null;
        if (total>0){
            relationList=relationService.findByPage(relationFindByPage);
        }
        R r= R.ok().addData("total",total).addData("relationList",relationList);
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void findAllRelationship(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RelationService relationService=new RelationServiceImpl();
        List<Relation> relationshipList=relationService.findAllRelationship();
        R r=relationshipList.size()>0?R.ok().addData("relationshipList",relationshipList):R.error("没有任何关系信息");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void addRelation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String str="";
        str=reader.readLine();
        RelationAndOlder relationAndOlder= JSONObject.parseObject(str, RelationAndOlder.class);
        RelationService relationService=new RelationServiceImpl();
        Boolean t=relationService.addRelation(relationAndOlder);
        R r=t?R.ok():R.error("不存在该老人");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void updateRelation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String str="";
        str=reader.readLine();
        RelationAndOlder relationAndOlder= JSONObject.parseObject(str, RelationAndOlder.class);
        RelationService relationService=new RelationServiceImpl();
        Boolean t=relationService.updateRelation(relationAndOlder);
        R r=t?R.ok():R.error("不存在该老人");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void deleteRelation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer relationId = MyFormatUtils.toInteger(request.getParameter("relationId"));
        RelationService relationService=new RelationServiceImpl();
        Boolean t=relationService.deleteRelation(relationId);
        R r=t?R.ok():R.error("删除失败");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }
}
