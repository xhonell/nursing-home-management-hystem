package servlet.person; /**
 * User: zhongjing
 * Date: 2024/12/18
 * Description:
 * Version: V1.0
 */

import commons.BaseServlet;
import commons.MyFormatUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/older/*")
public class OlderServlet extends BaseServlet {
    public void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String olderName = MyFormatUtils.trim(request.getParameter("olderName"));
        String olderSex = MyFormatUtils.trim(request.getParameter("olderSex"));
        Integer olderAge = MyFormatUtils.toInteger(request.getParameter("olderAge"));
        Date olderBirth = MyFormatUtils.toDate(request.getParameter("olderBirth"));
        String olderHealth = MyFormatUtils.trim(request.getParameter("olderHealth"));
        Date olderStartTime = MyFormatUtils.toDate("olderStartTime");
    }
}
