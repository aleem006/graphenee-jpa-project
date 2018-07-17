package jpa.graphenee.project.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import io.graphenee.vaadin.domain.DashboardUser;

@NamedQuery(name="Student.authenticate", query = "Select s from Student s where studentName = :studentName AND password = :password")
@Entity
@Table(name = "student")
public class Student implements DashboardUser {
 
	@Id
	@Column(name = "student_id")
	private int studentid;
 
	@Column(name = "student_name")
	private String studentName;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "password")
	private String password;
//	
//	@Column(name = "gender")
//	private GenderEnum gender;

//	@ManyToOne
//	@JoinColumn(name = "id_teacher")
//	private Teacher teacher;
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Student() {
	}
 
	public Student(int id, String name) {
		this.studentid = id;
		this.studentName = name;
	}

	@Override
	public String toString() {
		return String.format("Student[studnetId=%d, studentName='%s']", studentid, studentName);
	}

	public int getStudentId() {
		return studentid;
	}

	public void setStudentId(int studentid) {
		this.studentid = studentid;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String getUsername() {
		return studentName;
	}

	@Override
	public void setUsername(String username) {
		this.studentName = username;
	}

	@Override
	public GenderEnum getGender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGender(GenderEnum gender) {
		// TODO Auto-generated method stub
		
	}

//	public String getTeacher() {
//		return teacher.getTeacherName();
//	}
//
//	public void setTeacher(Teacher teacher) {
//		this.teacher = teacher;
//	}
	
}