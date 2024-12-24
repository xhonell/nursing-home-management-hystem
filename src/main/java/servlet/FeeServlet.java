package servlet;

import bean.pojo.Fee;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import dao.FeeDao;
import dao.impl.FeeDaoImpl;

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
    private FeeDao feeDao = new FeeDaoImpl();

    /**
     * 插入新的费用记录
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void insert(HttpServletRequest req, HttpServletResponse resp) {
        Fee fee = GetJsonParamsUtils.receiveJsonToPojo(req, Fee.class);
        feeDao.insertFee(fee);

        Write.writeSuccess(resp, null, "费用插入成功");
    }

    /**
     * 更新现有的费用记录
     *
     * @param req  HttpServletRequest 对象，包含请求信息
     * @param resp HttpServletResponse 对象，用于向客户端发送响应
     */
    public void update(HttpServletRequest req, HttpServletResponse resp) {
        Fee fee = GetJsonParamsUtils.receiveJsonToPojo(req, Fee.class);
        feeDao.updateFee(fee);

        Write.writeSuccess(resp, null, "费用更新成功");
    }
}