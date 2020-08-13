package com.example.test;



import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="Course")

public class Course {


	@Id
	@Column(name="CourseCode")
	private int CourseCode;
	@NotNull(message="thisfield cannot be null")
	@Column(name="CourseName")
	private String CourseName;
	@Range(min=7, max=14)
	@Column(name="Duration")
	private int Duration ;
	@Column(name="ProfessorName")
	private String ProfessorName;
	@Column(name="Semester")
	private String Semester;
	
	@Digits(integer = 6,fraction = 2, message = "has to be 2 fraction2 digit and 4 interger digit")
	@Column(name="CourseFee")
	private BigDecimal CourseFee;
	@Column(name="CreditHours")
	private int CreditHours;
	
	

	
	
	public Course() {
		super();
	}
	public Course(int CourseCode, String Coursename, int duration, String Semester,String professorName,BigDecimal CourseFee,int CreditHour) {
		super();
		this.CourseCode=CourseCode;
		this.CourseName=Coursename;
		this.Duration=duration;
		this.ProfessorName=professorName;
		this.Semester= Semester;
		this.CourseFee=CourseFee;
		this.CreditHours=CreditHour;
	}
	
	
	
	
	public int getCourseCode() {
		return CourseCode;
	}
	public void setCourseCode(int courseCode) {
		CourseCode = courseCode;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	public String getProfessorName() {
		return ProfessorName;
	}
	public void setProfessorName(String professorName) {
		ProfessorName = professorName;
	}
	public String getSemester() {
		return Semester;
	}
	public void setSemester(String semester) {
		Semester = semester;
	}
	public BigDecimal getCourseFee() {
		return CourseFee;
	}
	public void setCourseFee(BigDecimal courseFee) {
		CourseFee = courseFee;
	}
	public int getCreditHours() {
		return CreditHours;
	}
	public void setCreditHours(int creditHours) {
		CreditHours = creditHours;
	}
	
}
