package servlet;

import bean.dto.visitor.VisitorCreateDto;
import bean.dto.visitor.VisitorQueryDto;
import bean.dto.visitor.VisitorUpdateDto;
import bean.pojo.Visitor;
import bean.vo.VisitorQueryVo;
import com.alibaba.fastjson.JSONObject;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import dao.impl.VisitorDaoImpl;
import service.VisitorService;
import service.impl.VisitorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * servlet
 * User: hrj
 * Date: 2024/12/19 9:51
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@WebServlet("/visitor/*")
public class VisitorServlet extends BaseServlet {
    private final VisitorService visitorService = new VisitorServiceImpl();

    /**
     * 查询访客信息
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String params = req.getParameter("params");
            VisitorQueryDto visitorQueryDto = JSONObject.parseObject(params, VisitorQueryDto.class);
            VisitorQueryVo visitorQueryVo = visitorService.list(visitorQueryDto);

            if (visitorQueryVo != null) {
                Write.writeSuccess(resp, visitorQueryVo);
            } else {
                Write.writeSuccess(resp, "当前没有数据");
            }
        } catch (Exception e) {
            Write.writeFail(resp, "查询失败: " + e.getMessage());
        }
    }

    /**
     * 更新访客信息
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void update(HttpServletRequest req, HttpServletResponse resp) {
        try {
            VisitorUpdateDto visitorUpdateDto = GetJsonParamsUtils.receiveJsonToPojo(req, VisitorUpdateDto.class);
            boolean update = visitorService.update(visitorUpdateDto);
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
     * 创建新的访客记录
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void create(HttpServletRequest req, HttpServletResponse resp) {
        try {
            VisitorCreateDto visitorCreateDto = GetJsonParamsUtils.receiveJsonToPojo(req, VisitorCreateDto.class);
            boolean isSuccess = visitorService.create(visitorCreateDto);
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
     * 删除访客记录
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void delete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Long visitorId = Long.parseLong(req.getParameter("visitorId"));
            boolean isSuccess = visitorService.delete(visitorId);
            if (isSuccess) {
                Write.writeSuccess(resp, null, "删除成功");
            } else {
                Write.writeFail(resp, "删除失败");
            }
        } catch (NumberFormatException e) {
            Write.writeFail(resp, "无效的访客ID: " + e.getMessage());
        } catch (Exception e) {
            Write.writeFail(resp, "删除失败: " + e.getMessage());
        }
    }}