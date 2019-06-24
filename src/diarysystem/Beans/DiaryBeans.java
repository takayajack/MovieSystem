package diarysystem.Beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class DiaryBeans implements Serializable {
	private String classcode;
	private Timestamp insertDate;
	private String student;
	private String studentname;
	private String goodpoint;
	private String badpoint;
	private String comment;



	public String getClasscode() {
		return classcode;
	}
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
	public Timestamp getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Timestamp InsertDate) {
		this.insertDate = InsertDate;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getGoodpoint() {
		return goodpoint;
	}
	public void setGoodpoint(String goodpoint) {
		this.goodpoint = goodpoint;
	}
	public String getBadpoint() {
		return badpoint;
	}
	public void setBadpoint(String badpoint) {
		this.badpoint = badpoint;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}


}
