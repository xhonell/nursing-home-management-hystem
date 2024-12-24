package service.impl;

import bean.dto.ClassifyDto.ClassifyCreateDto;
import bean.dto.ClassifyDto.ClassifyUpdateDto;
import bean.pojo.Classify;
import dao.ClassifyDao;
import dao.impl.ClassifyDaoImpl;
import service.ClassifyService;

import java.util.List;

public class ClassifyServiceImpl implements ClassifyService {
    ClassifyDao classifyDao = new ClassifyDaoImpl();
    public List<Classify> getList(Object[] obj) {
        return classifyDao.getList(obj);
    }
    public boolean delete(Integer classifyId) {
        return classifyDao.delete(classifyId) > 0;
    }
    public boolean create(ClassifyCreateDto classifyCreateDto) {
        Object [] params = {classifyCreateDto.getClassifyName()};
        return classifyDao.create(params) > 0;
    }
    public boolean update(ClassifyUpdateDto classifyUpdateDto) {
        Object [] params = {
                classifyUpdateDto.getClassifyName(),
                classifyUpdateDto.getClassifyId()
        };
        return classifyDao.update(params) > 0;
    }
}
