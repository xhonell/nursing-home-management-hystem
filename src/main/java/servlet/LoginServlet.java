package servlet;


import bean.pojo.Player;
import bean.vo.PlayerVo;
import bean.vo.RouterVo;
import commons.BaseServlet;
import commons.WebParameterUtils;
import commons.Write;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * <p>Project:java_maven_project - LoginServlet
 * <p>POWER by xhonell on 2024-12-09 14:57
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
@WebServlet("/user/*")
public class LoginServlet extends BaseServlet {
    LoginService loginService = new LoginServiceImpl();
    public void login(HttpServletRequest request, HttpServletResponse response){
        Player player = WebParameterUtils.receiveJsonToPojo(request, Player.class);
        PlayerVo playerVo = loginService.login(player);
        if(playerVo != null){
            String id = request.getSession().getId();
            playerVo.setToken(id);
            request.getSession().setAttribute("token", id);
            request.getSession().setAttribute("user", playerVo);
            Write.writeSuccess(response, playerVo);
        }
    }
    public void info(HttpServletRequest request, HttpServletResponse response){
        String token = request.getParameter("token");
        String userTaken = String.valueOf(request.getSession().getAttribute("token"));
        if(Objects.equals(userTaken, token)){
            Object user = request.getSession().getAttribute("user");
            Write.writeSuccess(response,user);
        }else{
            Write.writeFail(response,"登录信息已过期，请重新登陆！");
        }
    }

    public void getPageUrl(HttpServletRequest request, HttpServletResponse response){
        String roles = request.getParameter("roles");
        List<RouterVo> routerVos =  loginService.getPageUrl(roles);
        if(routerVos != null){
            Write.writeSuccess(response,routerVos);
        }
    }
}
