package jpa.graphenee.project.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {
 
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

//	@ManyToOne
//	@JoinColumn(name = "id_teacher")
//	private Teacher teacher;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

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
	
//	public String getTeacher() {
//		return teacher.getTeacherName();
//	}
//
//	public void setTeacher(Teacher teacher) {
//		this.teacher = teacher;
//	}
	
}