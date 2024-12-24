package service.impl.person;

import bean.dto.DetailFindByPage;
import bean.dto.DoctorFindByPage;
import bean.pojo.Doctor;
import bean.vo.DetailList;
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

    @Override
    public Boolean deleteDoctors(Object[] object) {
        return doctorDao.deleteDoctors(object);
    }

    @Override
    public Long findDetailTotal(DetailFindByPage detailFindByPage) {
        return doctorDao.findDetailTotal(detailFindByPage);
    }

    @Override
    public List<DetailList> detailByPage(DetailFindByPage detailFindByPage) {
        return doctorDao.detailByPage(detailFindByPage);
    }

    @Override
    public Boolean updateDetail(Doctor doctor) {
        return doctorDao.updateDetail(doctor);
    }
}
