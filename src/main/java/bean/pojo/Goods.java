package bean.pojo;

import lombok.Data;

@Data
public class Goods {

  private long goodsId;
  private String goodsName;
  private double goodsPrice;
  private long goodsNumber;
  private long goodsInDepot;
  private String goodsProvider;
  private java.sql.Date goodsStartDate;
  private long classifyId;

}
