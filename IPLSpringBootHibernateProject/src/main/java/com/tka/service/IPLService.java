package com.tka.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tka.dao.IPLDao;
import com.tka.entity.Player;

@Service
public class IPLService {

	@Autowired
	private IPLDao ipldao;

	public Player InsertOnePlayer(Player player) {

		return ipldao.InsertOnePlayer(player);

	}

	public List<Player> InsertAllPlayers(List<Player> playerList) {

		return ipldao.InsertAllPlayers(playerList);

	}

	public Player getOnePlayer(int p_id) {

		return ipldao.getOnePlayer(p_id);
	}

	public List<Player> getAllPlayers() {

		return ipldao.getAllPlayers();
	}

	public Player updateOnePlayerPut(Player player) {

		return ipldao.updateOnePlayerPut(player);

	}

	public List<Player> updateManyPlayersPut(List<Player> playerList) {

		return ipldao.updateManyPlayersPut(playerList);
	}

	public Player updaeOnePlayerPatch(Player player) {

		return ipldao.updateOnePlayerPatch(player);
	}

	public List<Player> updateManyPlayersPatch(List<Player> playerList) {

		return ipldao.updateManyPlayersPatch(playerList);
	}

	public Player deleteOnePlayer(int p_id) {

		return ipldao.deleteOnePlayer(p_id);
	}

	public List<Integer> deleteManyPlayers(List<Integer> p_id) {

		return ipldao.deleteManyPlayers(p_id);
	}

}
