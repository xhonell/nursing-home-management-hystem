package dao.impl.person;

import bean.dto.DoctorFindByPage;
import bean.pojo.Doctor;
import bean.vo.DoctorList;
import commons.DBHelper;
import commons.JDBCUtils;
import dao.person.DoctorDao;
import dao.person.OlderDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public class DoctorDaoImpl implements DoctorDao {
    DBHelper dbHelper=new DBHelper();
    JDBCUtils jdbcUtils=new JDBCUtils();

    @Override
    public Long findTotal(DoctorFindByPage doctorFindByPage) {
        StringBuffer sql=new StringBuffer("select count(d.doctorId) total from doctor d " +
                "left join position p on p.positionId=d.positionId " +
                "left join department de on de.departmentId=p.departmentId where 1=1 ");
        List<Object> parameters=new ArrayList<>();
        if (doctorFindByPage.getDoctorName()!=null){
            sql.append("and d.doctorName like concat('%',?,'%') ");
            parameters.add(doctorFindByPage.getDoctorName());
        }
        if (doctorFindByPage.getDoctorSex()!=null){
            sql.append("and d.doctorSex=? ");
            parameters.add(doctorFindByPage.getDoctorSex());
        }
        if (doctorFindByPage.getDoctorAge()!=null){
            sql.append("and d.doctorAge=? ");
            parameters.add(doctorFindByPage.getDoctorAge());
        }
        if (doctorFindByPage.getDepartmentId()!=null){
            sql.append("and de.departmentId=? ");
            parameters.add(doctorFindByPage.getDepartmentId());
        }
        if (doctorFindByPage.getPositionId()!=null){
            sql.append("and p.positionId=? ");
            parameters.add(doctorFindByPage.getPositionId());
        }
        if (doctorFindByPage.getDoctorPopularity()!=null){
            sql.append("and d.doctorPopularity=? ");
            parameters.add(doctorFindByPage.getDoctorPopularity());
        }
        if (doctorFindByPage.getDoctorStartTime()!=null){
            sql.append("and d.doctorStartTime<=? ");
            parameters.add(doctorFindByPage.getDoctorStartTime());
        }
        if (doctorFindByPage.getDoctorEndTime()!=null){
            sql.append("and d.doctorEndTime>=? ");
            parameters.add(doctorFindByPage.getDoctorEndTime());
        }
        List<Map<String, Object>> list = jdbcUtils.select(sql.toString(), parameters.toArray());
        Long totalNumber=0L;
        if (list.size()>0){
            totalNumber=(Long) list.get(0).get("total");
        }
        return totalNumber;
    }

    @Override
    public List<DoctorList> findByPage(DoctorFindByPage doctorFindByPage) {
        StringBuffer sql=new StringBuffer("select d.doctorId,d.doctorName,d.doctorSex,d.doctorAge,d.doctorPhone,"+
                "d.doctorEmail,de.departmentName,p.positionName,d.doctorJob,d.doctorIntroduction,d.doctorExperience,"+
                "d.doctorStartTime,d.doctorEndTime,d.doctorPopularity from doctor d " +
                "left join position p on p.positionId=d.positionId " +
                "left join department de on de.departmentId=p.departmentId where 1=1 ");
        List<Object> parameters=new ArrayList<>();
        if (doctorFindByPage.getDoctorName()!=null){
            sql.append("and d.doctorName like concat('%',?,'%') ");
            parameters.add(doctorFindByPage.getDoctorName());
        }
        if (doctorFindByPage.getDoctorSex()!=null){
            sql.append("and d.doctorSex=? ");
            parameters.add(doctorFindByPage.getDoctorSex());
        }
        if (doctorFindByPage.getDoctorAge()!=null){
            sql.append("and d.doctorAge=? ");
            parameters.add(doctorFindByPage.getDoctorAge());
        }
        if (doctorFindByPage.getDepartmentId()!=null){
            sql.append("and de.departmentId=? ");
            parameters.add(doctorFindByPage.getDepartmentId());
        }
        if (doctorFindByPage.getPositionId()!=null){
            sql.append("and p.positionId=? ");
            parameters.add(doctorFindByPage.getPositionId());
        }
        if (doctorFindByPage.getDoctorPopularity()!=null){
            sql.append("and d.doctorPopularity=? ");
            parameters.add(doctorFindByPage.getDoctorPopularity());
        }
        if (doctorFindByPage.getDoctorStartTime()!=null){
            sql.append("and d.doctorStartTime<=? ");
            parameters.add(doctorFindByPage.getDoctorStartTime());
        }
        if (doctorFindByPage.getDoctorEndTime()!=null){
            sql.append("and d.doctorEndTime>=? ");
            parameters.add(doctorFindByPage.getDoctorEndTime());
        }
        sql.append("order by d.doctorId limit "+(doctorFindByPage.getPage()-1)*doctorFindByPage.getLimit()+","+doctorFindByPage.getLimit());
        return dbHelper.getBeanList(DoctorList.class,sql.toString(),parameters.toArray());
    }

    @Override
    public Boolean addDoctor(Doctor doctor) {
        String sql="insert into doctor(doctorName,doctorSex,doctorAge,doctorPhone,doctorEmail,doctorJob,doctorIntroduction,"+
                "doctorExperience,doctorStartTime,doctorEndTime,doctorPopularity,positionId) value(?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] parameters={doctor.getDoctorName(),doctor.getDoctorSex(),doctor.getDoctorAge(),doctor.getDoctorPhone(),doctor.getDoctorEmail(),doctor.getDoctorJob(),doctor.getDoctorIntroduction(),doctor.getDoctorExperience(),doctor.getDoctorStartTime(),doctor.getDoctorEndTime(),doctor.getDoctorPopularity(),doctor.getPositionId()};
        int row = dbHelper.update(sql, parameters);
        return row>0?true:false;
    }

    @Override
    public Boolean updateDoctor(Doctor doctor) {
        String sql="update doctor set doctorName=?,doctorSex=?,doctorAge=?,doctorPhone=?,doctorEmail=?,doctorJob=?,"+
                "doctorIntroduction=?,doctorExperience=?,doctorStartTime=?,doctorEndTime=?,doctorPopularity=?,positionId=? "+
                "where doctorId=?";
        Object[] parameters={doctor.getDoctorName(),doctor.getDoctorSex(),doctor.getDoctorAge(),doctor.getDoctorPhone(),doctor.getDoctorEmail(),doctor.getDoctorJob(),doctor.getDoctorIntroduction(),doctor.getDoctorExperience(),doctor.getDoctorStartTime(),doctor.getDoctorEndTime(),doctor.getDoctorPopularity(),doctor.getPositionId(),doctor.getDoctorId()};
        int row = dbHelper.update(sql, parameters);
        return row>0?true:false;
    }

    @Override
    public Boolean deleteDoctor(Doctor doctor) {
        String sql="delete from doctor where doctorId=?";
        int row = dbHelper.update(sql, doctor.getDoctorId());
        return row>0?true:false;
    }
}
