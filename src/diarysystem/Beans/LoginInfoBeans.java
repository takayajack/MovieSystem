 package diarysystem.Beans;

import java.io.Serializable;

public class LoginInfoBeans implements Serializable {

	private String name;
	private String ID;
	private String classcode;
	private String courscode;
	private String coursname;
	private int grade;

	public String getClasscode() {
		return classcode;
	}
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
	public String getCoursecode() {
		return courscode;
	}
	public void setCoursecode(String coursename) {
		this.courscode = coursename;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getCoursname() {
		return coursname;
	}
	public void setCoursname(String coursname) {
		this.coursname = coursname;
	}
}
