package com.tka.controller;

import java.util.List;
import java.util.Scanner;

import com.tka.entity.Leaves;
import com.tka.service.LeaveService;

public class LeaveController {
	
    Scanner scanner = new Scanner(System.in);
    
	private LeaveService leaveService = null;

	public List<Leaves> getAllLeaves() {

		leaveService = new LeaveService();
		List<Leaves> allLeaves = leaveService.getAllLeaves();
		return allLeaves;
	}

	public boolean addLeaves() {

		leaveService = new LeaveService();

		Leaves l1 = new Leaves();

		int l_id = 108;
		String start = "2026-7-19";
		String end = "2026-7-20";
		String reason = "Family emergency";
		int rollNo = 3;

		l1.setL_id(l_id);
		l1.setStart(start);
		l1.setEnd(end);
		l1.setReason(reason);
		l1.setRollNo(rollNo);

		boolean leave_ack = LeaveService.addLeaves(l1);
		if(leave_ack) {		
			System.out.println("Leave Added Succesfully");
	    } else {
			System.out.println("invalid data Please Try Again");
	        }
		return false;
	}

	public boolean updateLeaves() {
        
		leaveService = new LeaveService();

		Leaves l1 = new Leaves();

		int l_id = 101;
		String start = "2026-7-19";
		String end = "2026-7-20";
		String reason = "Family emergency";
		int rollNo = 1;

		l1.setL_id(l_id);
		l1.setStart(start);
		l1.setEnd(end);
		l1.setReason(reason);
		l1.setRollNo(rollNo);

		boolean leave_ack = LeaveService.updateLeaves(l1);
		if (leave_ack) {
		System.out.println("Leaves Updated Succesfully");
	    } else {
		System.out.println("invalid data Please Try Again");
	    }
		return false;
	}


	public boolean deleteLeaves() {

		Leaves l1 = new Leaves();
		
		int rollNo = 3;
		l1.setRollNo(rollNo);
		
		boolean leave_ack = LeaveService.deleteLeaves(l1);
		if(leave_ack) {
		System.out.println("Leave Deleted Succesfully");
	    } else {
	   	System.out.println("invalid data Please Try Again");
	}
		return false;
	}

}
