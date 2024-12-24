package bean.vo;

import lombok.Data;

import java.sql.Date;

//物资联查分类表
@Data
public class GoodsVo {
    private long goodsId;
    private String goodsName;
    private double goodsPrice;
    private long goodsNumber;
    private long goodsInDepot;
    private String goodsProvider;
    private Date goodsStartDate;
    private long classifyId;
    private String classifyName;
}
