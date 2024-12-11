package service;

import bean.dto.PlayerDto;
import bean.dto.SelectDto;
import bean.pojo.Player;

import java.util.List;

/**
 * <p>Project:Nursing Home Management System - PlayerService
 * <p>POWER by xhonell on 2024-12-11 09:13
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public interface PlayerService {
    List<Player> list(SelectDto selectDto);

    boolean insert(PlayerDto playerDto);

    boolean update(PlayerDto playerDto);

    boolean delete(Integer playerId);
}
