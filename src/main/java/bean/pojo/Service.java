package bean.pojo;

import lombok.Data;

@Data
public class Service {
  private Integer serviceId;
  private String serviceContent;
  private String serviceSolution;
  private String serviceIsOk;
  private String serviceIsAgree;
  private Integer doctorId;
  private Integer relationId;
}
