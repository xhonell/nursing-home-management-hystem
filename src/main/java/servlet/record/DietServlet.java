package servlet.record;

import bean.dto.diet.DietCreateDto;
import bean.dto.diet.DietQueryDto;
import bean.dto.diet.DietUpdateDto;
import bean.vo.DietQueryVo;
import com.alibaba.fastjson.JSONObject;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.record.DietService;
import service.impl.record.DietServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * program: nursing-home-management-system
 * ClassName DietServlet
 * description:
 * author: xhonell
 * create: 2024年12月16日14时44分
 * Version 1.0
 **/
@WebServlet("/diet/*")
public class DietServlet extends BaseServlet {
    DietService dietService = new DietServiceImpl();
    /**
     * 处理饮食查询请求
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) {
        String params = req.getParameter("params");
        DietQueryDto dietQueryDto = JSONObject.parseObject(params, DietQueryDto.class);
        DietQueryVo dietQueryVo = dietService.list(dietQueryDto);

        if (dietQueryVo != null) {
            Write.writeSuccess(resp, dietQueryVo);
        } else {
            Write.writeSuccess(resp,"当前没有数据");
        }
    }

    /**
     * 更新饮食信息
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void update(HttpServletRequest req, HttpServletResponse resp) {
        DietUpdateDto dietUpdateDto = GetJsonParamsUtils.receiveJsonToPojo(req, DietUpdateDto.class);
        boolean update = dietService.update(dietUpdateDto);
        if (update) {
            Write.writeSuccess(resp,null,"更新成功");
        } else {
            Write.writeFail(resp,"更新失败");
        }
    }

    /**
     * 创建新的饮食记录
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void create(HttpServletRequest req, HttpServletResponse resp) {
        DietCreateDto dietCreateDto = GetJsonParamsUtils.receiveJsonToPojo(req, DietCreateDto.class);
        boolean isSuccess = dietService.create(dietCreateDto);
        if (isSuccess) {
            Write.writeSuccess(resp,null,"创建成功");
        } else {
            Write.writeFail(resp,"创建失败");
        }
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) {
        Integer dietId = Integer.parseInt(req.getParameter("dietId"));
        boolean isSuccess = dietService.delete(dietId);
        if (isSuccess) {
            Write.writeSuccess(resp,null,"删除成功");
        } else {
            Write.writeFail(resp,"删除失败");
        }
    }
}
