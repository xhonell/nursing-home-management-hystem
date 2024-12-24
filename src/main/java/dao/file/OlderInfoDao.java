package dao.file;

import bean.vo.OlderInfoVo;

import java.util.List;

public interface OlderInfoDao {
    OlderInfoVo getInfo(Integer obj);
    int updateInfo(Object [] obj);
}
