package servlet;

import bean.dto.look.LookCreateDto;
import bean.dto.look.LookQueryDto;
import bean.dto.look.LookUpdateDto;
import bean.vo.LookQueryVo;
import com.alibaba.fastjson.JSONObject;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.LookService;
import service.impl.LookServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet
 * User: hrj
 * Date: 2024/12/20 11:41
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@WebServlet("/look/*")
public class LookServlet extends BaseServlet {
    private final LookService lookService = new LookServiceImpl();

    /**
     * 查询探望记录
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String params = req.getParameter("params");
            LookQueryDto lookQueryDto = JSONObject.parseObject(params, LookQueryDto.class);
            LookQueryVo lookQueryVo = lookService.list(lookQueryDto);

            if (lookQueryVo != null) {
                Write.writeSuccess(resp, lookQueryVo);
            } else {
                Write.writeSuccess(resp, "当前没有数据");
            }
        } catch (Exception e) {
            Write.writeFail(resp, "查询失败: " + e.getMessage());
        }
    }

    /**
     * 更新探望记录
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void update(HttpServletRequest req, HttpServletResponse resp) {
        try {
            LookUpdateDto lookUpdateDto = GetJsonParamsUtils.receiveJsonToPojo(req, LookUpdateDto.class);
            boolean update = lookService.update(lookUpdateDto);
            if (update) {
                Write.writeSuccess(resp, null, "更新成功");
            } else {
                Write.writeFail(resp, "更新失败");
            }
        } catch (Exception e) {
            Write.writeFail(resp, "更新失败: " + e.getMessage());
        }
    }

    /**
     * 创建新的探望记录
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void create(HttpServletRequest req, HttpServletResponse resp) {
        try {
            LookCreateDto lookCreateDto = GetJsonParamsUtils.receiveJsonToPojo(req, LookCreateDto.class);
            boolean isSuccess = lookService.create(lookCreateDto);
            if (isSuccess) {
                Write.writeSuccess(resp, null, "创建成功");
            } else {
                Write.writeFail(resp, "创建失败");
            }
        } catch (Exception e) {
            Write.writeFail(resp, "创建失败: " + e.getMessage());
        }
    }

    /**
     * 删除探望记录
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void delete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Long lookId = Long.parseLong(req.getParameter("lookId"));
            boolean isSuccess = lookService.delete(lookId);
            if (isSuccess) {
                Write.writeSuccess(resp, null, "删除成功");
            } else {
                Write.writeFail(resp, "删除失败");
            }
        } catch (NumberFormatException e) {
            Write.writeFail(resp, "无效的探望ID: " + e.getMessage());
        } catch (Exception e) {
            Write.writeFail(resp, "删除失败: " + e.getMessage());
        }
    }
}
