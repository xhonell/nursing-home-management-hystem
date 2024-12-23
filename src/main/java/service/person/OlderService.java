package service.person;

import bean.dto.OlderFindByPage;
import bean.pojo.Older;
import bean.vo.OlderHealthList;
import bean.vo.OlderList;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public interface OlderService {
    Long findTotal(OlderFindByPage olderFindByPage);

    List<OlderList> findByPage(OlderFindByPage olderFindByPage);

    Boolean addOlder(Older older);

    Boolean updateOlder(Older older);

    Boolean deleteOlder(Older older);

    List<OlderHealthList> findAllOlderHealthList();
}
