package service.impl.person;

import bean.dto.RelationAndOlder;
import bean.dto.RelationFindByPage;
import bean.pojo.Relation;
import bean.vo.RelationList;
import dao.impl.person.RelationDaoImpl;
import dao.person.RelationDao;
import service.person.RelationService;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public class RelationServiceImpl implements RelationService {
    private RelationDao relationDao=new RelationDaoImpl();
    @Override
    public Long findTotal(RelationFindByPage relationFindByPage) {
        return relationDao.findTotal(relationFindByPage);
    }

    @Override
    public List<RelationList> findByPage(RelationFindByPage relationFindByPage) {
        return relationDao.findByPage(relationFindByPage);
    }

    @Override
    public List<Relation> findAllRelationship() {
        return relationDao.findAllRelationship();
    }

    @Override
    public Boolean addRelation(RelationAndOlder relationAndOlder) {
        return relationDao.addRelation(relationAndOlder);
    }

    @Override
    public Boolean updateRelation(RelationAndOlder relationAndOlder) {
        return relationDao.updateRelation(relationAndOlder);
    }

    @Override
    public Boolean deleteRelation(Integer relationId) {
        return relationDao.deleteRelation(relationId);
    }
}
