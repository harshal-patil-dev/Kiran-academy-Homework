package com.tka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tka.entity.Players;
import com.tka.utility.PlayersDB;

public class PlayerDao {

	private String selectQuery = "SELECT * FROM Players";
	private String findQuery = "SELECT * FROM Players WHERE playerjn = ? AND team = ?";
	private String addQuery = "INSERT INTO Players VALUES(?,?,?,?,?,?,?,?)";
	private String updateQuery = "UPDATE Players SET playerName = ?, role = ?, matches = ?, runs = ?, wickets = ?, price = ? WHERE playerjn = ? AND team = ?";
	private String deleteQuery = "DELETE FROM Players WHERE playerjn = ? AND team = ?";

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	private List<Players> findPlayers = null;
	private List<Players> allPlayers = null;
	private Players players = null;

	public List<Players> getAllPlayers() {

		try {

			con = PlayersDB.getConnection();

			ps = con.prepareStatement(selectQuery);

			rs = ps.executeQuery();

			allPlayers = new ArrayList<Players>();

			while (rs.next()) {

				players = new Players();
				players.setPlayerJn(rs.getInt(1));
				players.setPlayerName(rs.getString(2));
				players.setTeam(rs.getString(3));
				players.setRole(rs.getString(4));
				players.setMatches(rs.getInt(5));
				players.setRuns(rs.getInt(6));
				players.setWickets(rs.getInt(7));
				players.setPrice(rs.getInt(8));

				allPlayers.add(players);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return allPlayers;
	}

	public List<Players> findPlayers(Players p1) {

		try {

			con = PlayersDB.getConnection();

			ps = con.prepareStatement(findQuery);

			ps.setInt(1, p1.getPlayerJn());
			ps.setString(2, p1.getTeam());

			rs = ps.executeQuery();

			findPlayers = new ArrayList<Players>();

			while (rs.next()) {

				players = new Players();
				players.setPlayerJn(rs.getInt(1));
				players.setPlayerName(rs.getString(2));
				players.setTeam(rs.getString(3));
				players.setRole(rs.getString(4));
				players.setMatches(rs.getInt(5));
				players.setRuns(rs.getInt(6));
				players.setWickets(rs.getInt(7));
				players.setPrice(rs.getInt(8));

				findPlayers.add(players);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return findPlayers;
	}

	public boolean addPlayers(Players p1) {

		try {

			con = PlayersDB.getConnection();

			ps = con.prepareStatement(addQuery);

			ps.setInt(1, p1.getPlayerJn());
			ps.setString(2, p1.getPlayerName());
			ps.setString(3, p1.getTeam());
			ps.setString(4, p1.getRole());
			ps.setInt(5, p1.getMatches());
			ps.setInt(6, p1.getRuns());
			ps.setInt(7, p1.getWickets());
			ps.setInt(8, p1.getPrice());

			int addplayers = ps.executeUpdate();
			if (addplayers > 0) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public boolean updatePlayers(Players p1) {

		try {

			con = PlayersDB.getConnection();

			ps = con.prepareStatement(updateQuery);

			ps.setString(1, p1.getPlayerName());
			ps.setString(2, p1.getRole());
			ps.setInt(3, p1.getMatches());
			ps.setInt(4, p1.getRuns());
			ps.setInt(5, p1.getWickets());
			ps.setInt(6, p1.getPrice());

			ps.setInt(7, p1.getPlayerJn());
			ps.setString(8, p1.getTeam());

			int updateplayers = ps.executeUpdate();
			if (updateplayers > 0) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public boolean deletePlayers(Players p1) {

		try {

			con = PlayersDB.getConnection();

			ps = con.prepareStatement(deleteQuery);

			ps.setInt(1, p1.getPlayerJn());
			ps.setString(2, p1.getTeam());

			int updateplayers = ps.executeUpdate();
			if (updateplayers > 0) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
