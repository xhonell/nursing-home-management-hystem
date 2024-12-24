package bean.vo;

import bean.pojo.Fee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * bean.vo
 * User: hrj
 * Date: 2024/12/23 11:28
 * motto:
 * Description: 一寸光阴一寸金，寸金难买寸光阴
 * Version: V1.0
 */
public class FeeQueryVo {
    private List<Fee> list;
    private Long count;

    public List<Fee> getList() {
        return list;
    }

    public void setList(List<Fee> list) {
        this.list = list;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

