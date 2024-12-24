package service;

import bean.dto.equit.EquipCreateDto;
import bean.dto.equit.EquipUpdateDto;
import bean.dto.grade.GradeCreateDto;
import bean.dto.grade.GradeUpdateDto;
import bean.pojo.Grade;

import java.util.List;

public interface GradeService {

    List<Grade> getList(Object[] obj);

    boolean delete(Integer equipId);

    boolean update(GradeUpdateDto gradeUpdateDto);

    boolean create(GradeCreateDto gradeCreateDto);
}
