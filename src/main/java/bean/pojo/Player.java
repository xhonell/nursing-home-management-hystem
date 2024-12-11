package bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

  private long player_id;
  private String player_nickName;
  private String player_Password;
  private Date player_birthday;
  private String player_sex;
  private long player_phone;
  private String player_Img;
  private String player_email;
  private String roles;

}
