package service.file;

import bean.pojo.File;
import bean.vo.FileVo;

import java.util.List;

public interface FileService {
    List<FileVo>getlist(Object [] obj);
    boolean delete(long fileId);

    boolean update(Object [] obj);
    boolean insert(Object [] obj);
}
