package bean.dto.goods;

import lombok.Data;

import java.sql.Date;

@Data
public class GoodsUpdateDto {
    private String goodsName;
    private double goodsPrice;
    private long goodsNumber;
    private long goodsInDepot;
    private String goodsProvider;
    private Date goodsStartDate;
    private long classifyId;
    private String classifyName;
    private long goodsId;
}
