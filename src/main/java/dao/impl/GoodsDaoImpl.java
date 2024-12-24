package dao.impl;

import bean.pojo.Classify;
import bean.pojo.Equip;
import bean.pojo.Goods;
import bean.vo.GoodsVo;
import commons.DataSourceUtil;
import dao.GoodsDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override

    //用于用拼接sql语句（模糊）查询，返回查询结果。

    //创建一个盛放查询结果的数组，先检测前端是否有对应的参数，如有，则拼接对应参数的sql查询语句
    //使用DataSourceUtil的queryToBeanListHandler方法处理查询结果，将查询结果封装到List集合中，返回。

    public List<GoodsVo> getList(Object[] obj) {
        //创建一个List集合，用于存储查询结果
        List<Object> list = new ArrayList<>();
        //创建一个StringBuilder对象，用于拼接sql语句
        StringBuilder sql = new StringBuilder("select * from goods,classify where goods.classifyId=classify.classifyId");
        //判断第一个参数是否为空，不为空则拼接sql语句
        if (obj[0] != null && !(String.valueOf(obj[0]).trim().isEmpty())){
            sql.append(" and goods.goodsName like concat('%',?,'%')");
            list.add(String.valueOf(obj[0]));
        }
        //判断第二个参数
        if(obj[1] != null && !String.valueOf(obj[1]).trim().isEmpty()){
            sql.append(" and classify.classifyName like concat('%',?,'%')");
            list.add(String.valueOf(obj[1]));
        }
        //拼接限制页数sql语句
        sql.append(" order by goods.goodsId limit ?,? ");
        list.add(obj[2]);
        list.add(obj[3]);

        //调用DataSourceUtil的queryToBeanListHandler方法，返回查询结果(sql语句，)
        return DataSourceUtil.queryToBeanListHandler(sql.toString(), GoodsVo.class, list.toArray());
    }
    @Override
    public int delete(long id) {
        String sql = "delete from goods where goodsId = ?";
        return DataSourceUtil.update(sql, id);
    }
    @Override
    public int create(Object[] params) {
        String sql0 = "select classifyId from classify where classifyName = ?";
        Classify classify = DataSourceUtil.queryToBeanHandler(sql0, Classify.class, params[7] );
        if (classify == null) {
            return 0;
        }
        params[6]=classify.getClassifyId();
        Object[] objects = Arrays.copyOf(params, 7);
        String sql = "insert into goods(goodsName,goodsPrice,goodsNumber,goodsInDepot,goodsProvider," +
                "goodsStartDate,classifyId) values (?,?,?,?,?,?,?)";
        return DataSourceUtil.update(sql, objects);
    }

    @Override
    public int update(Object[] params) {

        String sql0 = "select classifyId from classify where classifyName = ?";

        Classify classify = DataSourceUtil.queryToBeanHandler(sql0, Classify.class, params[8] );
        if (classify == null) {
            return 0;
        }
        params[6]=classify.getClassifyId();
        Object[] objects = Arrays.copyOf(params, 8);
        String sql = "update goods set goodsName = ? ," +
                "goodsPrice = ? , goodsNumber = ? , goodsInDepot = ?, goodsProvider = ?," +
                "goodsStartDate=?, classifyId = ? where goodsId = ?";
        return DataSourceUtil.update(sql, objects);
    }
}
