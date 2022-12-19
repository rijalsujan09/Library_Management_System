package library_Management_System;

import java.util.Objects;

public class Student {
	int studentid;
	String firstname;
	String lastname;
	String email;
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student( int studentid, String firstname, String lastname, String email ) {
		super();
		this.studentid=studentid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash( studentid, firstname, lastname,email);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname) && studentid == other.studentid;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + "]";
	}
	
	
	
	

}
