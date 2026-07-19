package com.tka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tka.entity.Leaves;
import com.tka.entity.Student;
import com.tka.utility.DBUtility;

public class LeaveDao {

	private String selectQuery = "SELECT * FROM leave_student";
	private String addQuery = "INSERT INTO leave_student VALUES(?,?,?,?,?)";
	private String updateQuery = "UPDATE leave_student SET l_id = ?, start = ?, end = ?, reason = ? WHERE rollNo = ?";
	private String deleteQuery = "DELETE FROM leave_student WHERE rollNo = ?";
	private String findQuery = "SELECT * FROM leave_student WHERE rollNo = ?";

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Leaves obj = null;
	
	private List<Leaves> allLeaves = null;
	private List<Leaves> findLeaves = null;

	public List<Leaves> getAllLeaves() {

		try {

			con = DBUtility.getConnection();

			ps = con.prepareStatement(selectQuery);

			rs = ps.executeQuery();

			allLeaves = new ArrayList<Leaves>();

			while (rs.next()) {

				obj = new Leaves(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));

				allLeaves.add(obj);

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

		return allLeaves;
	}

	public boolean addLeaves(Leaves l1) {

		try {

			con = DBUtility.getConnection();

			ps = con.prepareStatement(addQuery);

			ps.setInt(1, l1.getL_id());
			ps.setString(2, l1.getStart());
			ps.setString(3, l1.getEnd());
			ps.setString(4, l1.getReason());
			ps.setInt(5, l1.getRollNo());

			int leave_ack = ps.executeUpdate();
			if (leave_ack > 0) {
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

	public boolean updateLeaves(Leaves l1) {

		try {

			con = DBUtility.getConnection();

			ps = con.prepareStatement(updateQuery);

			ps.setInt(1, l1.getL_id());
			ps.setString(2, l1.getStart());
			ps.setString(3, l1.getEnd());
			ps.setString(4, l1.getReason());
			ps.setInt(5, l1.getRollNo());

			int leave_ack = ps.executeUpdate();
			if (leave_ack > 0) {
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

	public boolean deleteLeaves(Leaves l1) {

		try {

			con = DBUtility.getConnection();

			ps = con.prepareStatement(deleteQuery);

			ps.setInt(1, l1.getRollNo());

			int leave_ack = ps.executeUpdate();
			if (leave_ack > 0) {
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

	public boolean deleteLeaves(Student s1, Connection con) {

		try {

			ps = con.prepareStatement(deleteQuery);

			ps.setInt(1, s1.getRollNo());

			int leave_ack = ps.executeUpdate();

			if (leave_ack > 0) {
				return true;
			} else {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

	}

	public List<Leaves> findLeave(Leaves l1) {
		
		try {

			con = DBUtility.getConnection();

			ps = con.prepareStatement(findQuery);

			ps.setInt(1, l1.getRollNo());

			rs = ps.executeQuery();

			findLeaves = new ArrayList<Leaves>();

			while (rs.next()) {

				obj = new Leaves();
				
				obj.setL_id(rs.getInt(1));
				obj.setStart(rs.getString(2));
				obj.setEnd(rs.getString(3));
				obj.setReason(rs.getString(4));
				obj.setRollNo(rs.getInt(5));

				findLeaves.add(obj);

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
		
		return findLeaves;
	}

}
