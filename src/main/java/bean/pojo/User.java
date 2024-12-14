package bean.pojo;

import lombok.Data;

@Data
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
