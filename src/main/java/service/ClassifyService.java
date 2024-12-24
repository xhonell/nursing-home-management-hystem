package service;

import bean.dto.ClassifyDto.ClassifyCreateDto;
import bean.dto.ClassifyDto.ClassifyUpdateDto;
import bean.pojo.Classify;

import java.util.List;

public interface ClassifyService {
    List<Classify> getList(Object[] obj);
    boolean delete(Integer classifyId);
    boolean create(ClassifyCreateDto classifyCreateDto);
    boolean update(ClassifyUpdateDto classifyUpdateDto);
}
