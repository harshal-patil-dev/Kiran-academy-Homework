package com.tka.ManyToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee_table")
public class EmployeeMany {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Employee_id")
	private int e_id;
	
	@Column(name = "Name")
	private String ename;
	
	@Column(name = "Salary")
	private int salary;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Department")
	private DepartmentOne department;

}
