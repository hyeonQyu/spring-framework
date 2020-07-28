package com.nextwin.ex;

public class StudentInfo {
	
	private Student student;
	
	public StudentInfo(Student student) {
		this.student = student;
	}
	
	public void getStudentInfo() {
		System.out.println(student.getName() + " " + student.getAge() + " " + student.getGradeNum() + " " + student.getClassNum());
	}

}
