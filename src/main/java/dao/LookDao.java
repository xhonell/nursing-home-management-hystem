package dao;

import bean.dto.look.LookCreateDto;
import bean.dto.look.LookUpdateDto;
import bean.pojo.Look;

import java.util.List;

/**
 * dao
 * User: hrj
 * Date: 2024/12/20 14:46
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public interface LookDao {
    Long listCount(Object[] params);

    List<Look> list(Object[] params);

    int update(Object[] params);

    int create(Object[] params);

    int delete(Integer lookId);
}