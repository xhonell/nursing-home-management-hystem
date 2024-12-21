package bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private long roleId;
  private String rolePrivileges;
  private String roleName;
  private String roleSex;
  private long roleAge;
  private long rolePhone;
  private String roleEmail;
  private String rolePassword;
  private String roleImage;
}
