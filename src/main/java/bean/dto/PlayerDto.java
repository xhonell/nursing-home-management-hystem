package bean.dto;

import commons.MyFormatUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * <p>Project:Nursing Home Management System - Player_dto
 * <p>POWER by xhonell on 2024-12-11 10:34
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    private Integer player_id;
    private String player_nickName;
    private String player_sex;
    private Date player_birthday;
    private String player_phone;
    private String player_email;

    public void setPlayer_birthday(String birthday) {
        String modifiedBirthday = birthday.replaceAll("\\(.*\\)", "").trim();
        // 修正格式，确保正确解析时区偏移
        if (modifiedBirthday.contains("-")) {
            this.player_birthday = MyFormatUtils.toDate(modifiedBirthday, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        }else{
            this.player_birthday = MyFormatUtils.toDate(modifiedBirthday, "EEE MMM dd yyyy HH:mm:ss 'GMT'Z");
        }
    }
}
