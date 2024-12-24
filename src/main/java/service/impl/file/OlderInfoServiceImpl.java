package service.impl.file;

import bean.dto.UpdateOlderDto;
import bean.vo.OlderInfoVo;
import dao.file.OlderInfoDao;
import dao.impl.file.OlderInfoDaoImpl;
import service.file.OlderInfoService;

import java.util.List;

public class OlderInfoServiceImpl implements OlderInfoService {
    @Override
    public OlderInfoVo getInfo(Integer obj) {
        OlderInfoDao olderInfoDao=new OlderInfoDaoImpl();
        return olderInfoDao.getInfo(obj);
    }
    public boolean updateInfo(UpdateOlderDto updateOlderDto) {
        OlderInfoDao olderInfoDao=new OlderInfoDaoImpl();
        Object[] obj = {
                updateOlderDto.getOlderName(),
                updateOlderDto.getOlderAge(),
                updateOlderDto.getOlderPhone(),
                updateOlderDto.getOlderHealth(),
                updateOlderDto.getOlderHistory(),
                updateOlderDto.getOlderRemark(),
                updateOlderDto.getOlderId()

        };
        return olderInfoDao.updateInfo(obj) > 0;
    }
}
