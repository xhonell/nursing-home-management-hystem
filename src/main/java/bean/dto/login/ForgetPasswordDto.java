package bean.dto.login;

import lombok.Data;

/**
 * program: nursing-home-management-system
 * ClassName ForgetPasswordDto
 * description:
 * author: xhonell
 * create: 2024年12月17日20时13分
 * Version 1.0
 **/
@Data
public class ForgetPasswordDto {
    private String roleEmail;
    private String rolePassword;
    private Integer vCode;
}
