package servlet.leave;

import bean.pojo.DoctorLeave;
import commons.BaseServlet;
import commons.Write;
import service.impl.leave.AdminHandleServiceImpl;
import service.leave.AdminHandleService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName AdminHandle
 * description:
 * author: xhonell
 * create: 2024年12月20日14时06分
 * Version 1.0
 **/
@WebServlet("/adminHandle/*")
public class AdminHandleServlet extends BaseServlet {
    AdminHandleService adminHandleService = new AdminHandleServiceImpl();

    /**
     * 显示医生请假请求
     *
     * @param request  HttpServletRequest对象，包含客户端发送的请求信息
     * @param response HttpServletResponse对象，用于向客户端发送响应
     * @throws IOException 如果写入响应时发生IO异常
     */
    public void handleDoctorLeave(HttpServletRequest request, HttpServletResponse response){
        List<DoctorLeave> doctorLeaves = adminHandleService.handleDoctorLeave();
        if (doctorLeaves.isEmpty()){
            Write.writeFail(response, "暂无请假信息");
        } else {
            Write.writeSuccess(response, doctorLeaves);
        }
    }

    /**
     * 更新医生请假状态
     *
     * @param req  HttpServletRequest对象，包含请求信息
     * @param resp HttpServletResponse对象，用于向客户端返回响应
     */
    public void updateDoctorLeave(HttpServletRequest req, HttpServletResponse resp){
        long leaveId = Integer.parseInt(req.getParameter("leaveId"));
        String leaveState = req.getParameter("leaveState");
        Object[] params = {leaveState, leaveId};
        boolean isSuccess = adminHandleService.updateDoctorLeave(params);

        if (isSuccess){
            Write.writeSuccess(resp, "操作成功");
        } else {
            Write.writeFail(resp, "操作失败");
        }
    }

    public void updateOlderLeave(HttpServletRequest req, HttpServletResponse resp){
        long leaveId = Integer.parseInt(req.getParameter("leaveId"));
        String leaveState = req.getParameter("leaveState");
        Object[] params = {leaveState, leaveId};
        boolean isSuccess = adminHandleService.updateOlderLeave(params);

        if (isSuccess){
            Write.writeSuccess(resp, null,"操作成功");
        } else {
            Write.writeFail(resp, "操作失败");
        }
    }
}
