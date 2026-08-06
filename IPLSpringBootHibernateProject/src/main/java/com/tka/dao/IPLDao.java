package com.tka.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tka.entity.Player;

@Repository
public class IPLDao {

	@Autowired
	private SessionFactory sessionfactory;

	// Using persist() method
	public Player InsertOnePlayer(Player player) {

		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.persist(player);
		session.getTransaction().commit();
		session.close();
		return player;
	}

	// Using persist() method
	public List<Player> InsertAllPlayers(List<Player> playerList) {

		Session session = sessionfactory.openSession();
		session.beginTransaction();
		for (Player players : playerList) {
			session.persist(players);
		}
		session.getTransaction().commit();
		session.close();
		return playerList;
	}

	// Using find() method
	public Player getOnePlayer(int p_id) {

		Session session = sessionfactory.openSession();
		Player obj = session.find(Player.class, p_id);
		session.close();
		return obj;
	}

	// Using HQL Query
	public List<Player> getAllPlayers() {

		Session session = sessionfactory.openSession();
		Query<Player> query = session.createQuery("FROM Player", Player.class);
		List<Player> players = query.getResultList();
		session.close();
		return players;
	}

	// Using marge() method
	public Player updateOnePlayerPut(Player player) {

		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Player p = session.merge(player);
		session.getTransaction().commit();
		session.close();
		return p;
	}

	// Using marge() method
	public List<Player> updateManyPlayersPut(List<Player> playerList) {

		Session session = sessionfactory.openSession();
		session.beginTransaction();
		for (Player players : playerList) {
			session.merge(players);
		}
		session.getTransaction().commit();
		session.close();
		return playerList;
	}

	// Using marge() method
	public Player updateOnePlayerPatch(Player player) {

		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Player p = session.merge(player);
		session.getTransaction().commit();
		session.close();
		return p;
	}

	// Using marge() method
	public List<Player> updateManyPlayersPatch(List<Player> playerList) {

		Session session = sessionfactory.openSession();
		session.beginTransaction();
		for (Player players : playerList) {
			session.merge(players);
		}
		session.getTransaction().commit();
		session.close();
		return playerList;
	}

	// Using remove() method
	public Player deleteOnePlayer(int p_id) {

		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Player obj = session.find(Player.class, p_id);
		if (obj != null) {
			session.remove(obj);
		}
		session.getTransaction().commit();
		return obj;
	}

	// Using remove() method
	public List<Integer> deleteManyPlayers(List<Integer> p_id) {

		Session session = sessionfactory.openSession();
		session.beginTransaction();	
		for(Integer pid : p_id) {
			Player obj = session.find(Player.class, pid);
			if(obj != null) {
				session.remove(obj);
			}
		}
		session.getTransaction().commit();
		session.close();
		return p_id;
	}
}
