package servlet;

import bean.dto.PlayerDto;
import bean.dto.SelectDto;
import bean.pojo.Player;
import bean.vo.SelectVo;
import commons.BaseServlet;
import commons.MyFormatUtils;
import commons.WebParameterUtils;
import commons.Write;
import service.PlayerService;
import service.impl.PlayerServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>Project:Nursing Home Management System - PlayerServlet
 * <p>POWER by xhonell on 2024-12-11 08:54
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
@WebServlet("/player/*")
public class PlayerServlet extends BaseServlet {
    PlayerService playerService = new PlayerServiceImpl();

    /**
     * 获取玩家列表信息
     *
     * @param req  HttpServletRequest对象，包含前端传递的请求参数
     * @param resp HttpServletResponse对象，用于向客户端返回响应
     * @throws Exception 如果处理过程中出现异常，则抛出该异常
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        /*获取前端传递参数*/
        SelectDto selectDto = new SelectDto();
        Integer page = MyFormatUtils.toInteger(req.getParameter("page"));
        if (page == null){
            page = 1;
        }
        selectDto.setPage(page);
        Integer limit = MyFormatUtils.toInteger(req.getParameter("limit"));
        if (limit == null){
            limit = 10;
        }
        selectDto.setLimit(limit);
        selectDto.setPlayer_nickName(req.getParameter("player_nickName"));
        selectDto.setPlayer_sex(req.getParameter("player_sex"));
        /*与数据库交互*/
        List<Player> list = playerService.list(selectDto);
        /*返回数据*/
        SelectVo selectVo = new SelectVo();
        selectVo.setItems(list);
        selectVo.setTotal(list.size());
        if (selectVo.getTotal() != 0) {
            Write.writeSuccess(resp, selectVo);
        } else {
            Write.writeSuccess(resp, "暂无数据");
        }
    }

    public void insert(HttpServletRequest req, HttpServletResponse resp) {
        PlayerDto playerDto = WebParameterUtils.receiveJsonToPojo(req, PlayerDto.class);
        boolean ans = playerService.insert(playerDto);
        if (ans) {
            Write.writeSuccess(resp, "注册成功");
        } else {
            Write.writeSuccess(resp, "注册失败");
        }

    }
    public void update(HttpServletRequest req, HttpServletResponse resp) {
        PlayerDto playerDto = WebParameterUtils.receiveJsonToPojo(req, PlayerDto.class);
        boolean ans = playerService.update(playerDto);
        if (ans) {
            Write.writeSuccess(resp, "修改成功");
        } else {
            Write.writeFail(resp, "修改失败");
        }
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) {
        Integer playerId = Integer.parseInt(req.getParameter("player_id"));
        boolean ans = playerService.delete(playerId);
        if (ans) {
            Write.writeSuccess(resp, "删除成功");
        } else {
            Write.writeFail(resp, "删除失败");
        }
    }
}
