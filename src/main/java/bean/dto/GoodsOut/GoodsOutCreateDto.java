package bean.dto.GoodsOut;

import lombok.Data;

@Data
public class GoodsOutCreateDto {
    private long goodsOutNumber;
    private java.sql.Timestamp goodsOutTime;
    private long goodsId;
    private String goodsName;
}
