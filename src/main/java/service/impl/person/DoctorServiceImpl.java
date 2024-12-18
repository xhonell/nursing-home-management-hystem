package service.impl.person;

import bean.dto.DoctorFindByPage;
import bean.pojo.Doctor;
import bean.vo.DoctorList;
import dao.impl.person.DoctorDaoImpl;
import dao.person.DoctorDao;
import service.person.DoctorService;

import java.util.List;

/**
 * User: zhongjing
 * Date: 2024/12/17
 * Description:
 * Version: V1.0
 */
public class DoctorServiceImpl implements DoctorService {
    private DoctorDao doctorDao=new DoctorDaoImpl();

    @Override
    public Long findTotal(DoctorFindByPage doctorFindByPage) {
        return doctorDao.findTotal(doctorFindByPage);
    }

    @Override
    public List<DoctorList> findByPage(DoctorFindByPage doctorFindByPage) {
        return doctorDao.findByPage(doctorFindByPage);
    }

    @Override
    public Boolean addDoctor(Doctor doctor) {
        return doctorDao.addDoctor(doctor);
    }

    @Override
    public Boolean updateDoctor(Doctor doctor) {
        return doctorDao.updateDoctor(doctor);
    }

    @Override
    public Boolean deleteDoctor(Doctor doctor) {
        return doctorDao.deleteDoctor(doctor);
    }
}
