package bean.pojo;

import lombok.Data;

@Data
public class Relation {
  private Integer relationId;
  private String relationName;
  private String relationship;
  private Long relationPhone;
  private String relationAddress;
  private String relationEmail;
  private Integer olderId;
  private Integer roleId;
}
