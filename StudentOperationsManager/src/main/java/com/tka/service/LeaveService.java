package com.tka.service;

import java.util.List;
import com.tka.dao.LeaveDao;
import com.tka.entity.Leaves;

public class LeaveService {
	
	private LeaveDao leavedao = new LeaveDao();

	public List<Leaves> getAllLeaves() {
		
		List<Leaves> allLeaves = leavedao.getAllLeaves();
		return allLeaves;
	}

	
	public boolean addLeaves(Leaves l1) {
		
		if(l1.getL_id() < 0 || l1.getRollNo() < 0 || l1.getRollNo() > 500) {
			return false;
		} else {
			boolean leave_ack = leavedao.addLeaves(l1);
			return leave_ack;
		}
		
	}

	public boolean updateLeaves(Leaves l1) {
		
		if(l1.getL_id() < 0 || l1.getRollNo() < 0 || l1.getRollNo() > 500) {
			return false;
		} else {
			boolean leave_ack = leavedao.updateLeaves(l1);
			return leave_ack;
		}
		
	}

	public boolean deleteLeaves(Leaves l1) {
		
		if(l1.getRollNo() < 0 || l1.getRollNo() > 500) {
			return false;
		} else {
			boolean leave_ack = leavedao.deleteLeaves(l1);
			return leave_ack;
		}
		
	}


	public List<Leaves> findLeaves(Leaves l1) {
		
		List<Leaves> findLeaves = leavedao.findLeave(l1);
		return findLeaves;
		
	}
		
}
