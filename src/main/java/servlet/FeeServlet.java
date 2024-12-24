package servlet;

import bean.dto.fee.FeeCreateDto;
import bean.dto.fee.FeeQueryDto;
import bean.dto.fee.FeeUpdateDto;
import bean.dto.visitor.VisitorQueryDto;
import bean.pojo.Fee;
import bean.vo.FeeQueryVo;
import bean.vo.VisitorQueryVo;
import com.alibaba.fastjson.JSONObject;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import dao.FeeDao;
import dao.impl.FeeDaoImpl;
import service.FeeService;
import service.impl.FeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Timestamp;

/**
 * servlet
 * User: hrj
 * Date: 2024/12/21 16:04
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
@WebServlet("/fee/*")
public class FeeServlet extends BaseServlet {
    private final FeeService feeService = new FeeServiceImpl();

    /**
     * 插入新的费用记录
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void create(HttpServletRequest req, HttpServletResponse resp) {
        try {
            FeeCreateDto feeCreateDto = GetJsonParamsUtils.receiveJsonToPojo(req, FeeCreateDto.class);
            boolean isSuccess = feeService.create(feeCreateDto);
            if (isSuccess) {
                Write.writeSuccess(resp, null, "费用插入成功");
            } else {
                Write.writeFail(resp, "费用插入失败");
            }
        } catch (Exception e) {
            Write.writeFail(resp, "费用插入失败: " + e.getMessage());
        }
    }

    /**
     * 更新现有的费用记录
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void update(HttpServletRequest req, HttpServletResponse resp) {
        try {
            FeeUpdateDto feeUpdateDto = GetJsonParamsUtils.receiveJsonToPojo(req, FeeUpdateDto.class);
            boolean isSuccess = feeService.update(feeUpdateDto);
            if (isSuccess) {
                Write.writeSuccess(resp, null, "费用更新成功");
            } else {
                Write.writeFail(resp, "费用更新失败");
            }
        } catch (Exception e) {
            Write.writeFail(resp, "费用更新失败: " + e.getMessage());
        }
    }


    /**
     * 列出费用记录
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String params = req.getParameter("params");
            FeeQueryDto feeQueryDto = JSONObject.parseObject(params, FeeQueryDto.class);
            FeeQueryVo feeQueryVo = feeService.list(feeQueryDto);

            if (feeQueryVo != null) {
                Write.writeSuccess(resp, feeQueryVo);
            } else {
                Write.writeSuccess(resp, "当前没有数据");
            }
        } catch (Exception e) {
            Write.writeFail(resp, "查询失败: " + e.getMessage());
        }
    }
}
