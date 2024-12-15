package servlet;

import bean.pojo.User;
import commons.BaseServlet;
import commons.FileUtils;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * program: nursing-home-management-system
 * ClassName UserServlet
 * description:
 * author: xhonell
 * create: 2024年12月15日13时41分
 * Version 1.0
 **/
@MultipartConfig
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();
    /**
     * 上传用户头像
     *
     * @param req  HttpServletRequest 对象
     * @param resp HttpServletResponse 对象
     * @throws ServletException 如果处理请求时发生错误
     * @throws IOException 如果发生输入输出错误
     */
    public void uploadAvatar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        String realPath = req.getServletContext().getRealPath("/img/avatar");
        File avatar = new File(realPath);
        if (!avatar.exists()){
            avatar.mkdirs();
        }
        Part file = req.getPart("file");
        String submittedFileName = file.getSubmittedFileName();
        String suffix = FileUtils.getSuffix(submittedFileName);
        String newName = (UUID.randomUUID().toString().replaceAll("-","") + suffix);
        String newPath = realPath +"/" + newName;
        String ServerPath = "http://127.0.0.1:8080/img/avatar/" + newName;

        boolean isSuccess = userService.updateAvatar(user.getRoleId(), ServerPath);

        if (isSuccess){
            file.write(newPath);
            Write.writeSuccess(resp,null,"上传成功");
        } else {
            Write.writeFail(resp,"上传失败");
        }
    }

    /**
     * 重置用户信息
     *
     * @param req  HttpServletRequest 对象
     * @param resp HttpServletResponse 对象
     */
    public void resetUser(HttpServletRequest req, HttpServletResponse resp){
        User user = GetJsonParamsUtils.receiveJsonToPojo(req, User.class);
        User newUser = userService.updateUser(user);
        if (newUser == null){
            Write.writeFail(resp,"更新失败");
        } else{
            req.getSession().setAttribute("user",newUser);
            Write.writeSuccess(resp,newUser,"更新成功");
        }
    }
}
