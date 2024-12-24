package servlet.echars;

import bean.vo.EcharsAgeVo;
import commons.BaseServlet;
import commons.Write;
import service.echars.EcharsService;
import service.impl.echars.EcharsServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName EcharsServlet
 * description:
 * author: xhonell
 * create: 2024年12月21日23时40分
 * Version 1.0
 **/
@WebServlet("/echars/*")
public class EcharsServlet extends BaseServlet {
    EcharsService echarsService = new EcharsServiceImpl();
    public void getEcharsAge(HttpServletRequest request, HttpServletResponse response){
        List<EcharsAgeVo> echarsAge = echarsService.getEcharsAge();
        if (echarsAge.size() > 0){
            Write.writeSuccess(response, echarsAge);
        } else {
            Write.writeFail(response, "暂无数据");
        }
    }
}

