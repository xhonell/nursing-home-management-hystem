package bean.pojo;

import lombok.Data;

@Data
public class Grade {
  private Integer gradeId;
  private String gradeName;
  private String gradeContent;
  private double gradeCharge;
}
