package bean.dto.service;

import bean.dto.Page;
import lombok.Data;

/**
 * User: zhongjing
 * Date: 2024/12/21
 * Description:
 * Version: V1.0
 */
@Data
public class FindService extends Page {
    private String serviceIsOk;
    private String serviceIsAgree;
}
