package servlet;

import bean.dto.health.HealthCreateDto;
import bean.dto.health.HealthQueryDto;
import bean.dto.health.HealthUpdateDto;
import bean.vo.HealthVo;
import bean.vo.OlderVo;
import com.alibaba.fastjson.JSONObject;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.HealthService;
import service.impl.HealthServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * program: nursing-home-management-system
 * ClassName HealthServlet
 * description:
 * author: xhonell
 * create: 2024年12月17日11时20分
 * Version 1.0
 **/
@WebServlet("/health/*")
public class HealthServlet extends BaseServlet {
    HealthService healthService = new HealthServiceImpl();

    /**
     * 查询健康信息列表
     *
     * @param req HttpServletRequest对象，用于获取请求参数
     * @param resp HttpServletResponse对象，用于向客户端返回响应
     */
    public void list(HttpServletRequest req, HttpServletResponse resp){
        String params = req.getParameter("params");
        HealthQueryDto healthQueryDto = JSONObject.parseObject(params, HealthQueryDto.class);
        HealthVo list = healthService.list(healthQueryDto);
        if (list != null){
            Write.writeSuccess(resp, list, "查询成功");
        }else {
            Write.writeFail(resp, "当前无数据");
        }
    }

    /**
     * 更新健康信息
     *
     * @param req  HttpServletRequest对象，用于接收客户端请求
     * @param resp HttpServletResponse对象，用于向客户端返回响应
     */
    public void update(HttpServletRequest req, HttpServletResponse resp){
        HealthUpdateDto healthUpdateDto = GetJsonParamsUtils.receiveJsonToPojo(req, HealthUpdateDto.class);
        boolean isSuccess = healthService.update(healthUpdateDto);
        if (isSuccess){
            Write.writeSuccess(resp, "修改成功");
        } else {
            Write.writeFail(resp, "修改失败");
        }
    }

    /**
     * 获取老人姓名信息
     *
     * @param req  HttpServletRequest对象，用于接收客户端请求
     * @param resp HttpServletResponse对象，用于向客户端返回响应
     *
     * 此方法通过调用healthService的getOlderName方法来获取老人的姓名信息。
     * 如果成功获取到老人信息，则使用Write.writeSuccess方法将老人信息作为响应返回给客户端。
     * 如果未获取到老人信息（即older为null），则使用Write.writeSuccess方法返回"当前无数据"的提示信息给客户端。
     */
    public void getOlderName(HttpServletRequest req, HttpServletResponse resp){
        OlderVo older = healthService.getOlderName();
        if (older != null){
            Write.writeSuccess(resp, older);
        } else {
            Write.writeSuccess(resp, "当前无数据");
        }
    }

    /**
     * 创建健康记录
     *
     * @param req  HttpServletRequest对象，用于接收客户端的请求数据
     * @param resp HttpServletResponse对象，用于向客户端返回响应
     *
     * 此方法接收客户端发送的HTTP请求，从请求中获取JSON格式的健康记录创建数据，
     * 将JSON数据转换为HealthCreateDto对象。然后调用healthService的create方法尝试创建健康记录。
     * 如果创建成功，则通过Write.writeSuccess方法向客户端返回"添加成功"的响应；
     * 如果创建失败，则通过Write.writeFail方法向客户端返回"添加失败"的响应。
     */
    public void create(HttpServletRequest req, HttpServletResponse resp){
        HealthCreateDto healthCreateDto = GetJsonParamsUtils.receiveJsonToPojo(req, HealthCreateDto.class);
        boolean isSuccess = healthService.create(healthCreateDto);
        if (isSuccess){
            Write.writeSuccess(resp, "添加成功");
        } else {
            Write.writeFail(resp, "添加失败");
        }
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp){
        String healthId = req.getParameter("healthId");
        boolean isSuccess = healthService.delete(Long.parseLong(healthId));
        if (isSuccess){
            Write.writeSuccess(resp, "删除成功");
        } else {
            Write.writeFail(resp, "删除失败");
        }
    }
}
