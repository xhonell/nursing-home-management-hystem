package servlet.file;

import bean.dto.UpdateOlderDto;
import bean.vo.OlderInfoVo;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.UrlUtils;
import commons.Write;
import service.file.OlderInfoService;
import service.impl.file.OlderInfoServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/olderInfo/*")
public class OlderInfoServlet extends BaseServlet {
    OlderInfoService olderInfoService=new OlderInfoServiceImpl();

    public void getInfo(HttpServletRequest request, HttpServletResponse response){
        Integer relationId = Integer.parseInt(request.getParameter("relationId"));

        OlderInfoVo olderInfoVo = olderInfoService.getInfo(relationId);
        if (olderInfoVo!=null){
            Write.writeSuccess(response,olderInfoVo,"获取成功");
        }else {
            Write.writeFail(response,"获取失败");
        }
    }

    public void updateInfo(HttpServletRequest request, HttpServletResponse response){
        UpdateOlderDto updateOlderDto = GetJsonParamsUtils.receiveJsonToPojo(request, UpdateOlderDto.class);
        boolean updateInfo = olderInfoService.updateInfo(updateOlderDto);
        if (updateInfo){
            Write.writeSuccess(response,"更新成功");
        }else {
            Write.writeFail(response,"更新失败");
        }
    }
}
