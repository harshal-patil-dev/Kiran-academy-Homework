package com.tka.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Player;
import com.tka.service.IPLService;

@RestController
@RequestMapping("/ipl")
public class IPLController {

	@Autowired
	private IPLService iplservice;

	// Insert One Player
	@PostMapping("/insert-one-player")
	public Player InsertOnePlayer(@RequestBody Player player) {

		Player p = iplservice.InsertOnePlayer(player);
		return p;
	}

	// Insert All Players
	@PostMapping("/insert-all-players")
	public List<Player> InsertAllPlayer(@RequestBody List<Player> playerList) {

		List<Player> p = iplservice.InsertAllPlayers(playerList);
		return p;
	}

	// Get One Player
	@GetMapping("/get-one-player/{p_id}")
	public Player getOnePlayer(@PathVariable int p_id) {

		Player p = iplservice.getOnePlayer(p_id);
		return p;

	}

	// Get All Players
	@GetMapping("/get-all-players")
	public List<Player> getAllPlayers() {

		List<Player> players = iplservice.getAllPlayers();
		return players;
	}

	// Update One Player Using : PUT
	@PutMapping("/update-one-player")
	public Player updateOnePlayerPut(@RequestBody Player player) {

		Player p = iplservice.updateOnePlayerPut(player);
		return p;

	}

	// Update Many Players Using : PUT
	@PutMapping("/update-many-players")
	public List<Player> updateManyPlayersPut(@RequestBody List<Player> playerList) {

		List<Player> p = iplservice.updateManyPlayersPut(playerList);
		return p;

	}

	// Update One Player Using : PATCH
	@PatchMapping("/update-one-players")
	public Player updateOnePlayerPatch(@RequestBody Player player) {

		Player p = iplservice.updaeOnePlayerPatch(player);
		return p;

	}

	// Update Many Players Using : PATCH
	@PatchMapping("/update-many-players")
	public List<Player> updateManyPlayersPatch(@RequestBody List<Player> playerList) {

		List<Player> p = iplservice.updateManyPlayersPatch(playerList);
		return p;

	}

	// Delete One Player Using : DELETE
	@DeleteMapping("/delete-one-player")
	public Player deleteOnePlayer(@RequestParam int p_id) {

		Player p = iplservice.deleteOnePlayer(p_id);
		return p;

	}

	// Delete Many Player Using : DELETE
	@DeleteMapping("/delete-many-players")
	public List<Integer> deleteManyPlayers(@RequestParam List<Integer> p_id) {

		List<Integer> p = iplservice.deleteManyPlayers(p_id);
		return p;

	}

}
