package dao.impl.service;

import bean.dto.service.FindQuestion;
import bean.dto.service.FindService;
import bean.pojo.Service;
import commons.DBHelper;
import commons.JDBCUtils;
import dao.service.ServiceDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: zhongjing
 * Date: 2024/12/23
 * Description:
 * Version: V1.0
 */
public class ServiceDaoImpl implements ServiceDao {
    JDBCUtils jdbcUtils=new JDBCUtils();
    DBHelper dbHelper=new DBHelper();
    @Override
    public Long findTotal(FindService findService) {
        StringBuffer sql=new StringBuffer("select count(serviceId) total from service where 1=1 ");
        List<Object> parameters=new ArrayList<>();
        if (findService.getServiceIsOk()!=null){
            sql.append("and serviceIsOk=? ");
            parameters.add(findService.getServiceIsOk());
        }
        if (findService.getServiceIsAgree()!=null){
            sql.append("and serviceIsAgree=? ");
            parameters.add(findService.getServiceIsAgree());
        }
        List<Map<String, Object>> list = jdbcUtils.select(sql.toString(), parameters.toArray());
        Long totalNumber=0L;
        if (list.size()>0){
            totalNumber=(Long) list.get(0).get("total");
        }
        return totalNumber;
    }

    @Override
    public List<Service> findService(FindService findService) {
        StringBuffer sql=new StringBuffer("select serviceId,serviceContent,serviceSolution,serviceIsOk,serviceIsAgree from service where 1=1 ");
        List<Object> parameters=new ArrayList<>();
        if (findService.getServiceIsOk()!=null){
            sql.append("and serviceIsOk=? ");
            parameters.add(findService.getServiceIsOk());
        }
        if (findService.getServiceIsAgree()!=null){
            sql.append("and serviceIsAgree=? ");
            parameters.add(findService.getServiceIsAgree());
        }
        sql.append("order by serviceId limit "+(findService.getPage()-1)*findService.getLimit()+","+findService.getLimit());
        List<Service> serviceList = dbHelper.getBeanList(Service.class, sql.toString(), parameters.toArray());
        return serviceList;
    }

    @Override
    public Boolean updateService(Service service) {
        String sql="update service set serviceSolution=?,serviceIsOk=? where serviceId=?";
        Object[] parameters={service.getServiceSolution(),service.getServiceIsOk(),service.getServiceId()};
        int row = dbHelper.update(sql, parameters);
        return row>0?true:false;
    }

    @Override
    public Long findTotalQuestion(FindQuestion findQuestion) {
        String sql="select count(serviceId) total from service where relationId=?";
        Object[] parameters={findQuestion.getRelationId()};
        List<Map<String, Object>> list = jdbcUtils.select(sql.toString(), parameters);
        Long totalNumber=0L;
        if (list.size()>0){
            totalNumber=(Long) list.get(0).get("total");
        }
        return totalNumber;
    }

    @Override
    public List<Service> findQuestion(FindQuestion findQuestion) {
        String sql="select serviceId,serviceContent,serviceSolution,serviceIsAgree,relationId from service where relationId=?";
        List<Service> list = dbHelper.getBeanList(Service.class, sql, findQuestion.getRelationId());
        return list;
    }

    @Override
    public Boolean addQuestion(Service service) {
        String sql="insert into service(serviceContent,relationId) values(?,?)";
        Object[] parameters={service.getServiceContent(),service.getRelationId()};
        int row = dbHelper.update(sql, parameters);
        return row>0?true:false;
    }

    @Override
    public Boolean updateQuestion(Service service) {
        String sql="update service set serviceContent=?,serviceIsAgree=? where relationId=?";
        Object[] parameters={service.getServiceContent(),service.getServiceIsAgree(),service.getRelationId()};
        int row = dbHelper.update(sql, parameters);
        return row>0?true:false;
    }
}
