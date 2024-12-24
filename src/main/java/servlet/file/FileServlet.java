package servlet.file;

import bean.pojo.File;
import bean.vo.FileVo;
import commons.BaseServlet;
import commons.GetJsonParamsUtils;
import commons.Write;
import service.file.FileService;
import service.impl.file.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/file/*")
public class    FileServlet extends BaseServlet {
    FileService fileService=new FileServiceImpl();

    /**
     * 查询档案信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public  void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String fileExam = request.getParameter("fileExam");
        String doctorName = request.getParameter("doctorName");
        Object [] obj={
                fileExam,
                doctorName,
                (Integer.parseInt(page)-1)*Integer.parseInt(limit),
                Integer.parseInt(limit)
        };
            List<FileVo> list=fileService.getlist(obj);
            if (list!=null){
                Write.writeSuccess(response,list,"查询成功");
            }else {
                Write.writeFail(response,"查询失败");
        };
    }

    /**
     * 档案信息删除按钮
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileId = request.getParameter("fileId");
        Boolean isSuccess = fileService.delete(Long.parseLong(fileId));
        if (isSuccess){
            Write.writeSuccess(response,"删除成功");
        }else {
            Write.writeFail(response,"删除失败");

        }
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      File file = GetJsonParamsUtils.receiveJsonToPojo(request, File.class);
        Long fileId = Long.parseLong(request.getParameter("fileId")) ;
        String fileExperience = request.getParameter("fileExperience");
        String fileStudy = request.getParameter("fileStudy");
        String fileExam = request.getParameter("fileExam");
        String doctorId = request.getParameter("doctorId") ;
        Object [] obj= {
                fileExperience,
                fileStudy,
                fileExam,
                doctorId,
                fileId
        };
        Boolean isSuccess = fileService.update(obj);
        if (isSuccess){
            Write.writeSuccess(response,"修改成功");
        }else {
            Write.writeFail(response,"修改失败");
        }
    }
    public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileExperience = request.getParameter("fileExperience");
        String fileStudy = request.getParameter("fileStudy");
        String fileExam = request.getParameter("fileExam");
        String doctorId = request.getParameter("doctorId") ;
        Object [] obj= {
                fileExperience,
                fileStudy,
                fileExam,
                Integer.parseInt(doctorId)
        };
        Boolean isSuccess = fileService.insert(obj);
        if (isSuccess){
            Write.writeSuccess(response,"创建成功");
        }else {
            Write.writeFail(response,"创建失败");
        }
    }
}
