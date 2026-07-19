package com.tka.entity;

public class Leaves {
	
	private int l_id;
	private String start;
	private String end;
	private String reason;
	private int rollNo;
	
	public Leaves() {
		super();
	}

	public Leaves(int l_id, String start, String end, String reason, int rollNo) {
		super();
		this.l_id = l_id;
		this.start = start;
		this.end = end;
		this.reason = reason;
		this.rollNo = rollNo;
	}

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return "\n"
			 + "----------------------------" +
		       "\n" + "Leave_id : " + l_id + 
			   "\n" + "Start    : " + start + 
			   "\n" + "End      : " + end + 
			   "\n" + "Reason   : " + reason +
			   "\n" + "Roll No  : " + rollNo + "\n"
			 + "----------------------------";
	}
	
}
