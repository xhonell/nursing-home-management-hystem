package servlet;

import bean.dto.equit.EquipCreateDto;
import bean.dto.equit.EquipUpdateDto;
import bean.dto.goods.GoodsCreateDto;
import bean.dto.goods.GoodsUpdateDto;
import bean.pojo.Equip;
import bean.pojo.Goods;
import bean.vo.GoodsVo;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.EquipService;
import service.GoodsService;
import service.impl.EquipServiceImpl;
import service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/goods/*")
public class GoodsServlet extends BaseServlet {
    GoodsService goodsService = new GoodsServiceImpl();
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String goodsName = request.getParameter("goodsName");
        String classifyName = request.getParameter("classifyName");
        Object [] obj = {
                goodsName,
                classifyName,
                // 当前页数-1*条数 （当前页之前的条数）
                (Integer.parseInt(page)-1) * Integer.parseInt(limit),
                Integer.parseInt(limit)
        };
        //实例化
        List<GoodsVo> list = goodsService.getList(obj);
        if (list!=null){
            Write.writeSuccess(response,list,"查询成功");
        }else{
            Write.writeFail(response,"当前无数据");
        }
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));
        //实例化
        boolean isSuccess = goodsService.delete(goodsId);
        if (isSuccess) {
            Write.writeSuccess(response,null,"删除成功");
        } else {
            Write.writeFail(response,"删除失败");
        }
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) {
        // 将请求中的JSON数据转换为EquipCreateDto对象
        GoodsCreateDto goodsCreateDto = GetJsonParamsUtils.receiveJsonToPojo(req, GoodsCreateDto.class);
        boolean isSuccess = goodsService.create(goodsCreateDto);
        if (isSuccess) {
            Write.writeSuccess(resp,null,"创建成功");
        } else {
            Write.writeFail(resp,"创建失败");
        }
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) {
        GoodsUpdateDto goodsUpdateDto = GetJsonParamsUtils.receiveJsonToPojo(req, GoodsUpdateDto.class);
        boolean update = goodsService.update(goodsUpdateDto);
        if (update) {
            Write.writeSuccess(resp,null,"更新成功");
        } else {
            Write.writeFail(resp,"更新失败");
        }
    }
}
