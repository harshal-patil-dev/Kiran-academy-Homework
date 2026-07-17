package com.tka.client;

import java.util.List;
import com.tka.controller.LeaveController;
import com.tka.controller.StudentController;
import com.tka.entity.Leaves;
import com.tka.entity.Student;
import com.tka.service.StudentService;

public class Test {

	static LeaveController leavecontroller = null;
	static StudentController studentcontroller = null;

	public static void main(String[] args) {
		
		// Students system
		
		studentcontroller = new StudentController();
		
//		List<Student> allStudents = studentcontroller.getAllStudent();
//      System.out.println(allStudents);
		
//		boolean addStudents = studentcontroller.addStudents();
		
//    	boolean updateStudents = studentcontroller.updateStudents();
		
//		boolean deleteStudents = studentcontroller.deleteStudents();
		
		// Leaves system
		leavecontroller = new LeaveController();

//		List<Leaves> allLeaves = leavecontroller.getAllLeaves();
//		System.out.println(allLeaves);
        
//    	boolean addLeaves = leavecontroller.addLeaves();

//		boolean updateLeaves = leavecontroller.updateLeaves();
		
//		boolean deleteLeaves = leavecontroller.deleteLeaves();

		
		

	}

}
