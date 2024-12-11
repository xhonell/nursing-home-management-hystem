package bean.vo;

import bean.pojo.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>Project:Nursing Home Management System - SelectVo
 * <p>POWER by xhonell on 2024-12-11 09:32
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectVo {
    private Integer total;
    private List<Player> items;
}
