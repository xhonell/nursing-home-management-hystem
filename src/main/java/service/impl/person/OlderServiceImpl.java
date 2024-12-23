package service.impl.person;

import bean.dto.OlderFindByPage;
import bean.pojo.Older;
import bean.vo.OlderHealthList;
import bean.vo.OlderList;
import dao.impl.person.OlderDaoImpl;
import dao.person.OlderDao;
import service.person.OlderService;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public class OlderServiceImpl implements OlderService {
    private OlderDao olderDao=new OlderDaoImpl();
    @Override
    public Long findTotal(OlderFindByPage olderFindByPage) {
        return olderDao.findTotal(olderFindByPage);
    }

    @Override
    public List<OlderList> findByPage(OlderFindByPage olderFindByPage) {
        return olderDao.findByPage(olderFindByPage);
    }

    @Override
    public Boolean addOlder(Older older) {
        return olderDao.addOlder(older);
    }

    @Override
    public Boolean updateOlder(Older older) {
        return olderDao.updateOlder(older);
    }

    @Override
    public Boolean deleteOlder(Older older) {
        return olderDao.deleteOlder(older);
    }

    @Override
    public List<OlderHealthList> findAllOlderHealthList() {
        return olderDao.findAllOlderHealthList();
    }
}
