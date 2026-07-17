package com.tka.service;

import java.util.List;

import com.tka.dao.LeaveDao;
import com.tka.entity.Leaves;
import com.tka.entity.Student;

public class LeaveService {
	
	private static LeaveDao leavedao = null;

	public List<Leaves> getAllLeaves() {
		
		leavedao = new LeaveDao();
		List<Leaves> allLeaves = leavedao.getAllLeaves();
		return allLeaves;
	}

	
	public static boolean addLeaves(Leaves l1) {
		
		leavedao = new LeaveDao();
		if(l1.getL_id() < 0 || l1.getRollNo() < 0 || l1.getRollNo() > 500) {
			return false;
		} else {
			boolean leave_ack = leavedao.addLeaves(l1);
			return leave_ack;
		}
		
	}

	public static boolean updateLeaves(Leaves l1) {
		
		leavedao = new LeaveDao();
		if(l1.getL_id() < 0 || l1.getRollNo() < 0 || l1.getRollNo() > 500) {
			return false;
		} else {
			boolean leave_ack = leavedao.updateLeaves(l1);
			return leave_ack;
		}
		
	}

	public static boolean deleteLeaves(Leaves l1) {
		
		leavedao = new LeaveDao();
		if(l1.getRollNo() < 0 || l1.getRollNo() > 500) {
			return false;
		} else {
			boolean leave_ack = leavedao.deleteLeaves(l1);
			return leave_ack;
		}
		
	}
		
}
