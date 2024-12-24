package dao.impl;

import bean.pojo.Classify;
import bean.pojo.Goods;
import bean.vo.GoodsOutVo;
import bean.vo.GoodsVo;
import commons.DataSourceUtil;
import dao.GoodsOutDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodsOutDaoImpl implements GoodsOutDao {
    @Override

    //用于用拼接sql语句（模糊）查询，返回查询结果。

    //创建一个盛放查询结果的数组，先检测前端是否有对应的参数，如有，则拼接对应参数的sql查询语句
    //使用DataSourceUtil的queryToBeanListHandler方法处理查询结果，将查询结果封装到List集合中，返回。

    public List<GoodsOutVo> getList(Object[] obj) {
        //创建一个List集合，用于存储查询结果
        List<Object> list = new ArrayList<>();
        //创建一个StringBuilder对象，用于拼接sql语句
        StringBuilder sql = new StringBuilder("select * from goods,goodsout" +
                " where goods.goodsId=goodsout.goodsId");
        //判断第一个参数是否为空，不为空则拼接sql语句
        if (obj[0] != null && !(String.valueOf(obj[0]).trim().isEmpty())){
            sql.append(" and goods.goodsName like concat('%',?,'%')");
            list.add(String.valueOf(obj[0]));
        }
        //拼接限制页数sql语句
        sql.append(" order by goodsout.goodsOutId limit ?,? ");
        list.add(obj[1]);
        list.add(obj[2]);

        //调用DataSourceUtil的queryToBeanListHandler方法，返回查询结果(sql语句，)
        return DataSourceUtil.queryToBeanListHandler(sql.toString(), GoodsOutVo.class, list.toArray());
    }
    @Override
    public int delete(long id) {
        String sql = "delete from goodsOut where goodsOutId = ?";
        return DataSourceUtil.update(sql, id);
    }
    @Override
    public int create(Object[] params) {
        String sql0 = "select goodsId from goods where goodsName = ?";
        Goods goods = DataSourceUtil.queryToBeanHandler(sql0, Goods.class, params[3]);
        if (goods == null) {
            return 0;
        }
        params[2]=goods.getGoodsId();
        Object[] objects = Arrays.copyOf(params, 3);
        String sql = "insert into goodsOut(goodsOutNumber,goodsOutTime,goodsId) values (?,?,?)";
        return DataSourceUtil.update(sql, objects);
    }

    @Override
    public int update(Object[] params) {

        String sql0 = "select goodsId from goods where goodsName = ?";

        Goods goods = DataSourceUtil.queryToBeanHandler(sql0, Goods.class, params[4] );
        if (goods == null) {
            return 0;
        }
        params[2]=goods.getGoodsId();
        Object[] objects = Arrays.copyOf(params, 4);
        String sql = "update goodsout set goodsOutNumber = ? ," +
                "goodsOutTime = ? , goodsId = ? where goodsOutId = ?";
        return DataSourceUtil.update(sql, objects);
    }
}
