package servlet.person; /**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */

import bean.dto.DoctorFindByPage;
import bean.pojo.Doctor;
import bean.vo.DoctorList;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import commons.BaseServlet;
import commons.MyFormatUtils;
import commons.R;
import service.impl.person.DoctorServiceImpl;
import service.person.DoctorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/doctor/*")
public class DoctorServlet extends BaseServlet {
    /**
     * 查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public  void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String doctorName = MyFormatUtils.trim(request.getParameter("doctorName"));
        String doctorSex = MyFormatUtils.trim(request.getParameter("doctorSex"));
        Integer doctorAge = MyFormatUtils.toInteger(request.getParameter("doctorAge"));
        Integer departmentId = MyFormatUtils.toInteger(request.getParameter("departmentId"));
        Integer positionId = MyFormatUtils.toInteger(request.getParameter("positionId"));
        String doctorPopularity = MyFormatUtils.trim(request.getParameter("doctorPopularity"));
        Date doctorStartTime = MyFormatUtils.toDate(request.getParameter("doctorStartTime"));
        Date doctorEndTime = MyFormatUtils.toDate(request.getParameter("doctorEndTime"));
        Integer page=MyFormatUtils.toInteger(request.getParameter("page"));
        Integer limit=MyFormatUtils.toInteger(request.getParameter("limit"));
        DoctorFindByPage doctorFindByPage=new DoctorFindByPage();
        doctorFindByPage.setDoctorName(doctorName);
        doctorFindByPage.setDoctorSex(doctorSex);
        doctorFindByPage.setDoctorAge(doctorAge);
        doctorFindByPage.setDepartmentId(departmentId);
        doctorFindByPage.setPositionId(positionId);
        doctorFindByPage.setDoctorPopularity(doctorPopularity);
        doctorFindByPage.setDoctorStartTime(doctorStartTime);
        doctorFindByPage.setDoctorEndTime(doctorEndTime);
        doctorFindByPage.setPage(page);
        doctorFindByPage.setLimit(limit);
        DoctorService doctorService=new DoctorServiceImpl();
        Long total=doctorService.findTotal(doctorFindByPage);
        List<DoctorList> doctorList=null;
        if (total>0){
            doctorList=doctorService.findByPage(doctorFindByPage);
        }
        R r= R.ok().addData("total",total).addData("doctorList",doctorList);
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void addDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader reader = request.getReader();
        String str="";
        str=reader.readLine();
        Doctor doctor = JSONObject.parseObject(str, Doctor.class);
        DoctorService doctorService=new DoctorServiceImpl();
        Boolean t=doctorService.addDoctor(doctor);
        R r=t?R.ok():R.error("添加失败");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void updateDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader reader = request.getReader();
        String str="";
        str=reader.readLine();
        Doctor doctor = JSONObject.parseObject(str, Doctor.class);
        DoctorService doctorService=new DoctorServiceImpl();
        Boolean t=doctorService.updateDoctor(doctor);
        R r=t?R.ok():R.error("修改失败");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public void deleteDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer doctorId = MyFormatUtils.toInteger(request.getParameter("doctorId"));
        Doctor doctor=new Doctor();
        doctor.setDoctorId(doctorId);
        DoctorService doctorService=new DoctorServiceImpl();
        Boolean t=doctorService.deleteDoctor(doctor);
        R r=t?R.ok():R.error("删除失败");
        String result = JSON.toJSONString(r);
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }
}