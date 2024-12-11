package dao;

import bean.dto.SelectDto;
import bean.pojo.Player;
import commons.DataSourceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project:Nursing Home Management System - PlayerDao
 * <p>POWER by xhonell on 2024-12-11 09:16
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class PlayerDao {
    public List<Player> list(SelectDto selectDto) {
        List<Object> params = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from player where 1=1 ");
        if (selectDto.getPlayer_nickName() != null && !selectDto.getPlayer_nickName().isEmpty()) {
            sql.append(" and player_nickName like concat('%',?,'%') ");
            params.add(selectDto.getPlayer_nickName());
        }
        if (selectDto.getPlayer_sex() != null && !selectDto.getPlayer_sex().isEmpty()) {
            sql.append(" and player_sex = ?");
            params.add(selectDto.getPlayer_sex());
        }
        sql.append("limit ?,?");
        params.add((selectDto.getPage() - 1) * selectDto.getLimit());
        params.add(selectDto.getLimit());
        return DataSourceUtil.queryToBeanListHandler(sql.toString(), Player.class, params.toArray());
    }

    public int insert(Object... objects) {
        String sql = "insert into player(player_nickName,player_birthday,player_sex,player_phone,player_email) " +
                "values (?,?,?,?,?)";
        return DataSourceUtil.update(sql, objects);
    }

    public int update(Object... objects) {
        String sql = "update player set player_nickName=?,player_birthday=?,player_sex=?,player_phone=?,player_email=? where player_id=?" ;
        return DataSourceUtil.update(sql, objects);
    }

    public int delete(Integer playerId) {
        String sql = "delete from player where player_id=?";
        return DataSourceUtil.update(sql, playerId);
    }
}
