package dao.person;

import bean.dto.DoctorFindByPage;
import bean.pojo.Doctor;
import bean.vo.DoctorList;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public interface DoctorDao {
    Long findTotal(DoctorFindByPage doctorFindByPage);

    List<DoctorList> findByPage(DoctorFindByPage doctorFindByPage);

    Boolean addDoctor(Doctor doctor);

    Boolean updateDoctor(Doctor doctor);

    Boolean deleteDoctor(Doctor doctor);
}
