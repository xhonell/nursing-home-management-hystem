//package dao.impl;
//
//import bean.pojo.Equip;
//import bean.pojo.Goods;
//import bean.vo.GoodsVo;
//import commons.DataSourceUtil;
//import dao.GoodsDao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GoodsDaoImpl implements GoodsDao {
//    public List<GoodsVo> getList(Object[] obj) {
//        //创建一个List集合，用于存储查询结果
//        List<Object> list = new ArrayList<>();
//        //创建一个StringBuilder对象，用于拼接sql语句
//        StringBuilder sql = new StringBuilder("select * from goods,classify where goods.classifyId=classify.classifyId");
//        //判断第一个参数是否为空，不为空则拼接sql语句
//        if (obj[0] != null && !(String.valueOf(obj[0]).trim().isEmpty())){
//            sql.append(" and goodsName like concat('%',?,'%')");
//            list.add(String.valueOf(obj[0]));
//        }
//        //判断第二个参数是否为空，不为空则拼接sql语句
//        if(obj[1] != null && !String.valueOf(obj[1]).trim().isEmpty()){
//            sql.append(" and classifyName = ?");
//            list.add(String.valueOf(obj[1]));
//        }
//        //拼接限制页数sql语句
//        sql.append(" limit ?,?");
//        list.add(obj[2]);
//        list.add(obj[3]);
//        //调用DataSourceUtil的queryToBeanListHandler方法，返回查询结果(sql语句，)
//        return DataSourceUtil.queryToBeanListHandler(sql.toString(), Goods.class, list.toArray());
//    }
//    @Override
//    public int delete(long id) {
//        String sql = "delete from goods where goodsId = ?";
//        return DataSourceUtil.update(sql, id);
//    }
//    @Override
//    public int create(Object[] params) {
//        String sql = "insert into goods(goodsName,goodsPosition,goodsState) values (?,?,?)";
//        return DataSourceUtil.update(sql, params);
//    }
//
//    @Override
//    public int update(Object[] params) {
//        String sql = "update equip set equipName = ? , equipPosition = ? , equipState = ? where equipId = ?";
//        return DataSourceUtil.update(sql, params);
//    }}
