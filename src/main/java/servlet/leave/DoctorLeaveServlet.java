package servlet.leave;

import bean.dto.leave.RequestDto;
import bean.pojo.DoctorLeave;
import bean.vo.DoctorInformationVo;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.impl.leave.DoctorLeaveServiceImpl;
import service.leave.DoctorLeaveService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName DoctorLeave
 * description:
 * author: xhonell
 * create: 2024年12月19日14时18分
 * Version 1.0
 **/
@WebServlet("/doctorLeave/*")
public class DoctorLeaveServlet extends BaseServlet {
    DoctorLeaveService doctorLeaveService = new DoctorLeaveServiceImpl();
    /**
     * 获取医生信息
     *
     * @param req  HttpServletRequest对象，包含请求信息
     * @param resp HttpServletResponse对象，用于向客户端发送响应
     * @throws NumberFormatException 如果请求参数中的doctorId无法转换为整数，则抛出该异常
     */
    public void information(HttpServletRequest req, HttpServletResponse resp){
        int doctorId = Integer.parseInt(req.getParameter("doctorId"));
        DoctorInformationVo doctorInformationVo = doctorLeaveService.information(doctorId);
        if (doctorInformationVo != null) {
            Write.writeSuccess(resp, doctorInformationVo);
        } else {
            Write.writeFail(resp, "当前角色无权限！");
        }
    }

    /**
     * 处理请假请求
     *
     * @param req  HttpServletRequest对象，包含客户端发送的请求信息
     * @param resp HttpServletResponse对象，用于向客户端发送响应
     */
    public void request(HttpServletRequest req, HttpServletResponse resp){
        RequestDto requestDto = GetJsonParamsUtils.receiveJsonToPojo(req, RequestDto.class);
        boolean isSuccess = doctorLeaveService.request(requestDto);
        if (isSuccess) {
            Write.writeSuccess(resp,null,"请耐心等待审核");
        } else {
            Write.writeFail(resp, "牛马不配请假");
        }
    }

    public void requestInformation(HttpServletRequest req, HttpServletResponse resp){
        Integer doctorId = Integer.parseInt(req.getParameter("doctorId"));
        List<DoctorLeave> leaves = doctorLeaveService.requestInformation(doctorId);
        if (leaves.isEmpty()){
            Write.writeFail(resp,"暂无请假记录");
        } else {
            Write.writeSuccess(resp,leaves);
        }
    }
}
