package bean.vo;

import java.util.List;

/**
 * bean.vo
 * User: hrj
 * Date: 2024/12/19 10:18
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public class VisitorQueryVo {
    private List<?> list;
    private Long count;

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
