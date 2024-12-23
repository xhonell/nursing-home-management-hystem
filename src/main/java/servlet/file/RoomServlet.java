package servlet.file;

import bean.vo.RoomVo;
import commons.BaseServlet;
import commons.Write;
import service.file.RoomService;
import service.impl.file.RoomServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@WebServlet("/room/*")
public class RoomServlet extends BaseServlet {
    RoomService roomService=new RoomServiceImpl();
public void list(HttpServletRequest request, HttpServletResponse response){
    String page = request.getParameter("page");
    String limit = request.getParameter("limit");
    String roomName = request.getParameter("roomName");
    String doctorName = request.getParameter("doctorName");
    String olderName = request.getParameter("olderName");
    Object [] obj={
            roomName,
            doctorName,
            olderName,
            (Integer.parseInt(page)-1)*Integer.parseInt(limit),
            Integer.parseInt(limit)
    };
    List<RoomVo> list = roomService.getlist(obj);
    if(list!=null) {
        Write.writeSuccess(response,list,"获取房间列表成功");
    }else {
        Write.writeFail(response,"获取房间列表失败");
    }
}
public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String roomId = request.getParameter("roomId");
    Boolean isSuccess = roomService.delete(Long.parseLong(roomId));
    if (isSuccess) {
        Write.writeSuccess(response,"删除成功");
    }else {
        Write.writeFail(response,"删除房间失败");
    }

}
public void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String roomName = request.getParameter("roomName");
    String doctorId = request.getParameter("doctorId");
    String olderId = request.getParameter("olderId");
    Object[] obj = {
            roomName,
            doctorId,
            olderId
    };
    Boolean isSuccess = roomService.insert(obj);
    if (isSuccess) {
        Write.writeSuccess(response,"添加房间成功");
    }else {
        Write.writeFail(response,"添加房间失败");
    }
    }
public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String roomName = request.getParameter("roomName");
    String doctorId = request.getParameter("doctorId");
    String olderId = request.getParameter("olderId");
    String roomId = request.getParameter("roomId");
    Object[] obj = {
            roomName,
            doctorId,
            olderId,
            roomId
    };
    Boolean isSuccess = roomService.update(obj);
    if (isSuccess) {
        Write.writeSuccess(response,"修改房间成功");
    }else {
        Write.writeFail(response,"修改房间失败");
    }
    }
}
