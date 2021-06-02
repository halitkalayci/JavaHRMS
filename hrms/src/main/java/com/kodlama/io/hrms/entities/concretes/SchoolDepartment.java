package com.kodlama.io.hrms.entities.concretes;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="school_departments")
public class SchoolDepartment {
	   @Id()
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "id")
	   private int id;
	   
	   
	   @Column(name = "department",nullable = false)
	   private String department;
	   
	   @ManyToOne()
	   @JoinColumn(name =  "school_id")
	   @JsonIgnore
	   private School school;
	   
	   @OneToMany(mappedBy="schoolDepartment")
	   @JsonIgnore
	   Set<EmployeeSchoolDepartment> employeeSchoolDepartments;
	   

}
