package service.file;

import bean.dto.UpdateOlderDto;
import bean.vo.OlderInfoVo;

import java.util.List;

public interface OlderInfoService {
    OlderInfoVo getInfo(Integer obj);
    boolean updateInfo(UpdateOlderDto updateOlderDto);
}
