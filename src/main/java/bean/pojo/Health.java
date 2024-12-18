package bean.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class Health {

  private long healthId;
  private String healthState;
  private double healthHeight;
  private double healthWeight;
  private double healthBlood;
  private double healthHeart;
  private Date healthTime;
  private long olderId;
  private String doctorName;
  private String olderName;
  private long doctorId;


}
