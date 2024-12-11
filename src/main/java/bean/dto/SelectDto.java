package bean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Project:Nursing Home Management System - SelectDto
 * <p>POWER by xhonell on 2024-12-10 20:25
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
public class SelectDto {
    private Integer page;
    private Integer limit;
    private String player_nickName;
    private String player_sex;
}
