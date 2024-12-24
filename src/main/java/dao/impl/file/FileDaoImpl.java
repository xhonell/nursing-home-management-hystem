package dao.impl.file;

import bean.pojo.File;
import bean.vo.FileVo;
import commons.DataSourceUtil;
import dao.file.FileDao;

import java.util.ArrayList;
import java.util.List;

public class FileDaoImpl implements FileDao {
    @Override
    public List<FileVo> getlist(Object[] obj) {
      List<Object>list = new ArrayList<>();
      StringBuilder sql=new StringBuilder("select d.doctorId, f.fileId,f.fileExperience,f.fileStudy,f.fileExam,d.doctorName from file f  " +
              "JOIN doctor d ON f.doctorId=d.doctorId where 1=1");
      if (obj[0]!=null&& !(String.valueOf(obj[0]).trim().isEmpty()) ){
          sql.append(" and f.fileExam=?");
          list.add(String.valueOf(obj[0]));
        }
      if (obj[1]!=null&& !(String.valueOf(obj[1]).trim().isEmpty()) ){
          sql.append(" and d.doctorName like concat('%',?,'%')");
          list.add(String.valueOf(obj[1]));
        }
      sql.append(" limit ?,?");
      list.add(obj[2]);
      list.add(obj[3]);
      return DataSourceUtil.queryToBeanListHandler(sql.toString(),FileVo.class,list.toArray());
    }

    @Override
    public long delete(Long fileId) {
        String sql = "delete from file where fileId = ?";
        return DataSourceUtil.update(sql,fileId);
    }

    @Override
    public  int update(Object[] obj) {
        String sql = "update file set fileExperience=?,fileStudy=?,fileExam=?,doctorId=? where fileId=?";
        return DataSourceUtil.update(sql,obj);
    }

    @Override
    public int insert(Object[] obj) {
        String sql = "insert into file(fileExperience,fileStudy,fileExam,doctorId) values (?,?,?,?)";
        return DataSourceUtil.update(sql,obj);
    }

}
