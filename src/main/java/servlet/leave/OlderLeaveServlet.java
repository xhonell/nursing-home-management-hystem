package servlet.leave;

import bean.dto.leave.RequestOlderDto;
import bean.pojo.OlderLeave;
import bean.vo.OlderInformationVo;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.impl.leave.OlderLeaveServiceImpl;
import service.leave.OlderLeaveService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName OlderLeaveServlet
 * description:
 * author: xhonell
 * create: 2024年12月21日10时00分
 * Version 1.0
 **/
@WebServlet("/olderLeave/*")
public class OlderLeaveServlet  extends BaseServlet {
    OlderLeaveService olderLeaveService = new OlderLeaveServiceImpl();
    public void olderInformation(HttpServletRequest req, HttpServletResponse resp){
        Integer relationId = Integer.parseInt(req.getParameter("relationId"));
        OlderInformationVo olderInformationVo = olderLeaveService.olderInformation(relationId);
        if (olderInformationVo != null) {
            Write.writeSuccess(resp, olderInformationVo);
        } else {
            Write.writeFail(resp, "当前用户无权限");
        }
    }

    public void request(HttpServletRequest req, HttpServletResponse resp){
        RequestOlderDto requestOlderDto = GetJsonParamsUtils.receiveJsonToPojo(req, RequestOlderDto.class);
        boolean isSuccess = olderLeaveService.request(requestOlderDto);
        if (isSuccess) {
            Write.writeSuccess(resp,null,"请耐心等待审核！");
        } else {
            Write.writeFail(resp,"年纪太大，无法请假！");
        }

    }

    public void requestInformation(HttpServletRequest req, HttpServletResponse resp){
        String relationIdStr = req.getParameter("relationId");
        Integer relationId = 0;
        if (relationIdStr != null) {
            relationId = Integer.parseInt(relationIdStr);
        }
         List<OlderLeave> olderLeaves = olderLeaveService.requestInformation(relationId);
        if (olderLeaves != null) {
            Write.writeSuccess(resp,olderLeaves);
        } else {
            Write.writeFail(resp,"当前用户无权限");
        }
    }

}
