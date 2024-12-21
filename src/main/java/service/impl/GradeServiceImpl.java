package service.impl;

import bean.dto.grade.GradeCreateDto;
import bean.dto.grade.GradeUpdateDto;
import bean.pojo.Grade;
import dao.GradeDao;
import dao.impl.GradeDaoImpl;
import service.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {
    GradeDao gradeDao = new GradeDaoImpl();
    @Override
    public List<Grade> getList(Object[] obj) {
        GradeDao gradeDao = new GradeDaoImpl();
        return gradeDao.getList(obj);
    }
    @Override
    public boolean delete(Integer gradeId){
        GradeDao gradeDao = new GradeDaoImpl();
        //判断返回行数是否大于1，是则返回true
        return gradeDao.delete(gradeId) > 0;
    }
    @Override
    public boolean create(GradeCreateDto gradeCreateDto){
        Object[] params = {
                gradeCreateDto.getGradeName(),
                gradeCreateDto.getGradeContent(),
                gradeCreateDto.getGradeCharge()
        };
        return gradeDao.create(params) > 0;
    }

    @Override
    public boolean update(GradeUpdateDto gradeUpdateDto) {
        Object[] params = {
                gradeUpdateDto.getGradeName(),
                gradeUpdateDto.getGradeContent(),
                gradeUpdateDto.getGradeCharge(),
                gradeUpdateDto.getGradeId()
        };
        return gradeDao.update(params) > 0;
    }
}
