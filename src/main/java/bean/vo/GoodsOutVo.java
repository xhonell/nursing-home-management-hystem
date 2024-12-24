package bean.vo;

import lombok.Data;

@Data
public class GoodsOutVo {
    private long goodsOutId;
    private long goodsOutNumber;
    private java.sql.Timestamp goodsOutTime;
    private long goodsId;
    private String goodsName;
}
