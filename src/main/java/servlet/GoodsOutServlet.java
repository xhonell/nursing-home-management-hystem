package servlet;


import bean.dto.GoodsOut.GoodsOutCreateDto;
import bean.dto.GoodsOut.GoodsOutUpdateDto;
import bean.dto.goods.GoodsCreateDto;
import bean.dto.goods.GoodsUpdateDto;
import bean.pojo.GoodsOut;
import bean.vo.GoodsOutVo;
import bean.vo.GoodsVo;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.GoodsOutService;
import service.GoodsService;
import service.impl.GoodsOutServiceImpl;
import service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/goodsout/*")
public class GoodsOutServlet extends BaseServlet {
    GoodsOutService goodsOutService = new GoodsOutServiceImpl();
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String goodsName = request.getParameter("goodsName");
        Object [] obj = {
                goodsName,
                // 当前页数-1*条数 （当前页之前的条数）
                (Integer.parseInt(page)-1) * Integer.parseInt(limit),
                Integer.parseInt(limit)
        };
        //实例化
        List<GoodsOutVo> list = goodsOutService.getList(obj);
        if (list!=null){
            Write.writeSuccess(response,list,"查询成功");
        }else{
            Write.writeFail(response,"当前无数据");
        }
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer goodsOutId = Integer.parseInt(request.getParameter("goodsOutId"));
        //实例化
        boolean isSuccess = goodsOutService.delete(goodsOutId);
        if (isSuccess) {
            Write.writeSuccess(response,null,"删除成功");
        } else {
            Write.writeFail(response,"删除失败");
        }
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) {
        // 将请求中的JSON数据转换为EquipCreateDto对象
        GoodsOutCreateDto goodsOutCreateDto = GetJsonParamsUtils.receiveJsonToPojo(req, GoodsOutCreateDto.class);
        boolean isSuccess = goodsOutService.create(goodsOutCreateDto);
        if (isSuccess) {
            Write.writeSuccess(resp,null,"创建成功");
        } else {
            Write.writeFail(resp,"创建失败");
        }
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) {
        GoodsOutUpdateDto goodsOutUpdateDto = GetJsonParamsUtils.receiveJsonToPojo(req, GoodsOutUpdateDto.class);
        boolean update = goodsOutService.update(goodsOutUpdateDto);
        if (update) {
            Write.writeSuccess(resp,null,"更新成功");
        } else {
            Write.writeFail(resp,"更新失败");
        }
    }
}
