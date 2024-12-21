package servlet;

import bean.dto.diet.DietCreateDto;
import bean.dto.diet.DietUpdateDto;
import bean.dto.equit.EquipCreateDto;
import bean.dto.equit.EquipUpdateDto;
import bean.pojo.Equip;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.DietService;
import service.EquipService;
import service.impl.DietServiceImpl;
import service.impl.EquipServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/equip/*")
public class EquipServlet extends BaseServlet {
    EquipService equipService = new EquipServiceImpl();
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String equipName = request.getParameter("equipName");
        String equipState = request.getParameter("equipState");
        Object [] obj = {
            equipName,
            equipState,
            // 当前页数-1*条数 （当前页之前的条数）
            (Integer.parseInt(page)-1) * Integer.parseInt(limit),
            Integer.parseInt(limit)
        };
        //实例化
        EquipService equipService = new EquipServiceImpl();
        List<Equip> list = equipService.getList(obj);
        if (list!=null){
            Write.writeSuccess(response,list,"查询成功");
        }else{
            Write.writeFail(response,"当前无数据");
        }
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer equipId = Integer.parseInt(request.getParameter("equipId"));
        //实例化
        EquipService equipService = new EquipServiceImpl();
        boolean isSuccess = equipService.delete(equipId);
        if (isSuccess) {
            Write.writeSuccess(response,null,"删除成功");
        } else {
            Write.writeFail(response,"删除失败");
        }
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) {
        // 将请求中的JSON数据转换为EquipCreateDto对象
        EquipCreateDto equipCreateDto = GetJsonParamsUtils.receiveJsonToPojo(req, EquipCreateDto.class);
        boolean isSuccess = equipService.create(equipCreateDto);
        if (isSuccess) {
            Write.writeSuccess(resp,null,"创建成功");
        } else {
            Write.writeFail(resp,"创建失败");
        }
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) {
        EquipUpdateDto equipUpdateDto = GetJsonParamsUtils.receiveJsonToPojo(req, EquipUpdateDto.class);
        boolean update = equipService.update(equipUpdateDto);
        if (update) {
            Write.writeSuccess(resp,null,"更新成功");
        } else {
            Write.writeFail(resp,"更新失败");
        }
    }

}

