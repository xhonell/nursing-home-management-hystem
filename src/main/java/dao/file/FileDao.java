package dao.file;

import bean.pojo.File;
import bean.vo.FileVo;

import java.util.List;

public interface FileDao {

    List<FileVo> getlist(Object[] obj);
    long delete(Long fileId);
    int update(Object [] obj);
    int insert(Object[]obj);
}
