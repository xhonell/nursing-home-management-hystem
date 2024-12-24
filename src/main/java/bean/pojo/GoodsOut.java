package bean.pojo;

import lombok.Data;

@Data
public class GoodsOut {
  private long goodsOutId;
  private long goodsOutNumber;
  private java.sql.Timestamp goodsOutTime;
  private long goodsId;
}
