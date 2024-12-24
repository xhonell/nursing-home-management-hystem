package service.impl.file;

import bean.pojo.File;
import bean.vo.FileVo;
import dao.file.FileDao;
import dao.file.FileDao;
import dao.impl.file.FileDaoImpl;
import dao.impl.file.FileDaoImpl;
import service.file.FileService;

import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<FileVo> getlist(Object[] obj) {
        FileDao fileDao = new FileDaoImpl();
        return fileDao.getlist(obj);
    }

    @Override
    public boolean delete(long fileId) {
        FileDao fileDao = new FileDaoImpl();
        return fileDao.delete(fileId) > 0;
    }

    @Override
    public boolean update(Object[] obj) {
        FileDao fileDao = new FileDaoImpl();
        return fileDao.update (obj) > 0;
    }

    @Override
    public boolean insert(Object[] obj) {
        FileDao fileDao = new FileDaoImpl();
        return fileDao.insert (obj) > 0;
    }
}
