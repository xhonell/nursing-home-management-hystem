package servlet;

import bean.dto.care.CareCreateDto;
import bean.dto.care.CareQueryDto;
import bean.dto.care.CareUpdateDto;
import bean.vo.CareQueryVo;
import com.alibaba.fastjson.JSONObject;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.CareService;
import service.impl.CareServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * program: nursing-home-management-system
 * ClassName CareServlet
 * description:
 * author: xhonell
 * create: 2024年12月18日14时49分
 * Version 1.0
 **/
@WebServlet("/care/*")
public class CareServlet extends BaseServlet {
    CareService careService=new CareServiceImpl();
    /**
     * 处理列表请求
     *
     * @param request  HttpServletRequest 对象，用于获取请求参数
     * @param response HttpServletResponse 对象，用于向客户端发送响应
     */
    public void list(HttpServletRequest request, HttpServletResponse response){
        String params = request.getParameter("params");
        CareQueryDto careQueryDto = JSONObject.parseObject(params, CareQueryDto.class);

        CareQueryVo getList = careService.getlist(careQueryDto);
        if (getList != null){
            Write.writeSuccess(response, getList);
        } else {
            Write.writeFail(response, "查询失败");
        }
    }

    /**
     * 更新护理信息
     *
     * @param request   HttpServletRequest对象，包含请求信息
     * @param response  HttpServletResponse对象，用于向客户端发送响应
     */
    public void update(HttpServletRequest request, HttpServletResponse response){
        CareUpdateDto careUpdateDto = GetJsonParamsUtils.receiveJsonToPojo(request, CareUpdateDto.class);
        boolean isSuccess = careService.update(careUpdateDto);
        if (isSuccess){
            Write.writeSuccess(response,null,"更新成功");
        } else {
            Write.writeFail(response,"更新失败");
        }
    }

    /**
     * 创建护理信息
     *
     * @param request   HttpServletRequest对象，包含请求信息
     * @param response  HttpServletResponse对象，用于向客户端发送响应
     * @throws Exception 抛出异常
     */
    public void create(HttpServletRequest request, HttpServletResponse response){
        CareCreateDto careCreateDto = GetJsonParamsUtils.receiveJsonToPojo(request, CareCreateDto.class);
        boolean isSuccess = careService.create(careCreateDto);
        if (isSuccess){
            Write.writeSuccess(response,null,"创建成功");
        } else {
            Write.writeFail(response,"创建失败");
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response){
        Integer careId = Integer.parseInt(request.getParameter("careId"));
        boolean isSuccess = careService.delete(careId);
        if (isSuccess){
            Write.writeSuccess(response,null,"删除成功");
        } else {
            Write.writeFail(response,"删除失败");
        }
    }

}
