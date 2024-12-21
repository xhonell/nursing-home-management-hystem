package service.person;

import bean.dto.RelationAndOlder;
import bean.dto.RelationFindByPage;
import bean.pojo.Relation;
import bean.vo.RelationList;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public interface RelationService {
    Long findTotal(RelationFindByPage relationFindByPage);

    List<RelationList> findByPage(RelationFindByPage relationFindByPage);

    List<Relation> findAllRelationship();

    Boolean addRelation(RelationAndOlder relationAndOlder);

    Boolean updateRelation(RelationAndOlder relationAndOlder);

    Boolean deleteRelation(Integer relationId);
}
