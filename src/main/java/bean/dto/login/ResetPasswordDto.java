package bean.dto.login;

import lombok.Data;

/**
 * program: nursing-home-management-system
 * ClassName resetPasswordDto
 * description:
 * author: xhonell
 * create: 2024年12月15日19时02分
 * Version 1.0
 **/
@Data
public class ResetPasswordDto {
    private Long roleId;
    private String rolePassword;
    private String newRolePassword;
}
