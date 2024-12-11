package service.impl;

import bean.dto.PlayerDto;
import bean.dto.SelectDto;
import bean.pojo.Player;
import dao.PlayerDao;
import service.PlayerService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project:Nursing Home Management System - PlayerServiceImpl
 * <p>POWER by xhonell on 2024-12-11 09:14
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class PlayerServiceImpl implements PlayerService {
    PlayerDao playerDao = new PlayerDao();
    @Override
    public List<Player> list(SelectDto selectDto) {
        /*调用dao层方法*/
        return playerDao.list(selectDto);
    }

    @Override
    public boolean insert(PlayerDto playerDto) {
        List<Object> list = new ArrayList<>();
        list.add(playerDto.getPlayer_nickName());
        list.add(playerDto.getPlayer_birthday());
        list.add(playerDto.getPlayer_sex());
        list.add(playerDto.getPlayer_phone());
        list.add(playerDto.getPlayer_email());


        /*调用dao层方法*/
        return playerDao.insert(list.toArray()) > 0;
    }

    @Override
    public boolean update(PlayerDto playerDto) {
        List<Object> list = new ArrayList<>();
        list.add(playerDto.getPlayer_nickName());
        list.add(playerDto.getPlayer_birthday());
        list.add(playerDto.getPlayer_sex());
        list.add(playerDto.getPlayer_phone());
        list.add(playerDto.getPlayer_email());
        list.add(playerDto.getPlayer_id());
        return playerDao.update(list.toArray()) > 0;
    }

    @Override
    public boolean delete(Integer playerId) {
        return playerDao.delete(playerId) > 0;
    }
}
