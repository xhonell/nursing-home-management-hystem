package dao;

import bean.pojo.Care;

import java.util.List;

/**
 * program: nursing-home-management-system
 * ClassName CareDao
 * description:
 * author: xhonell
 * create: 2024年12月18日15时17分
 * Version 1.0
 **/
public interface CareDao{
    List<Care> getlist(Object[] obj);

    Long queryTotal(Object[] obj);

    int update(Object[] params);

    int create(Object[] params);

    int delete(Integer careId);
}
