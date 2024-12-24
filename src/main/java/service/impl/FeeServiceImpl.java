package service.impl;

import bean.dto.fee.FeeCreateDto;
import bean.dto.fee.FeeQueryDto;
import bean.dto.fee.FeeUpdateDto;
import bean.pojo.Fee;
import bean.vo.FeeQueryVo;
import dao.FeeDao;
import dao.impl.FeeDaoImpl;
import service.FeeService;

import java.util.ArrayList;
import java.util.List;

/**
 * service.impl
 * User: hrj
 * Date: 2024/12/23 11:19
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public class FeeServiceImpl implements FeeService {
    private final FeeDao feeDao = new FeeDaoImpl();

    /**
     * 插入新的费用记录
     *
     * @param feeCreateDto 费用创建对象
     * @return 是否插入成功
     */
    @Override
    public boolean create(FeeCreateDto feeCreateDto) {
        Object[] fee = {
                feeCreateDto.getFeeName(),
                feeCreateDto.getFeePrice(),
                feeCreateDto.getFeeState(),
                feeCreateDto.getOlderId()
        };
        return feeDao.insertFee(fee) > 0;
    }

    /**
     * 更新现有的费用记录
     *
     * @param feeUpdateDto 费用更新对象
     * @return 是否更新成功
     */
    @Override
    public boolean update(FeeUpdateDto feeUpdateDto) {
        Object[] fee = {
                feeUpdateDto.getFeeName(),
                feeUpdateDto.getFeePrice(),
                feeUpdateDto.getFeeState(),
                feeUpdateDto.getFeeTime(),
                feeUpdateDto.getOlderId(),
                feeUpdateDto.getFeeId(),
        };
        return feeDao.updateFee(fee) > 0;
    }
    /**
     * 分页查询费用记录
     *
     * @param feeQueryDto 查询条件对象
     * @return FeeQueryVo 对象，包含费用记录的计数和列表
     */
    @Override
    public FeeQueryVo list(FeeQueryDto feeQueryDto) {
        if (feeQueryDto == null) {
            throw new IllegalArgumentException("feeQueryDto cannot be null");
        }

        // 构建查询参数
        Object[] params = {
                feeQueryDto.getFeeName(),
                feeQueryDto.getFeeState(),
                feeQueryDto.getOlderId(),
                (feeQueryDto.getPage() - 1) * feeQueryDto.getLimit(),
                feeQueryDto.getLimit()
        };

        // 查询费用记录列表
        List<Fee> feeList = feeDao.list(params);
        if (feeList == null) {
            feeList = new ArrayList<>();
        }

        // 查询费用记录的总数
        Long count = feeDao.listCount(params);
        if (count == null) {
            count = 0L;
        }

        // 创建并返回FeeQueryVo对象
        FeeQueryVo feeQueryVo = new FeeQueryVo();
        feeQueryVo.setList(feeList);
        feeQueryVo.setCount(count);
        return feeQueryVo;
    }
}
