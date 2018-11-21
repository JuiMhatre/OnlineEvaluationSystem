package bean;

import java.sql.Blob;
import java.sql.Date;

public class AssignmentBean {
	private String assignmentid;
	private String questionarename;
	private Blob questionare;
	private float totalmarks;
	private Date lastdateofsubmission;
	public String getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(String assignmentid) {
		this.assignmentid = assignmentid;
	}
	public String getQuestionarename() {
		return questionarename;
	}
	public void setQuestionarename(String questionare_name) {
		this.questionarename = questionare_name;
	}
	public Blob getQuestionare() {
		return questionare;
	}
	public void setQuestionare(Blob questionare) {
		this.questionare = questionare;
	}
	public float getTotalmarks() {
		return totalmarks;
	}
	public void setTotalmarks(float total_marks) {
		this.totalmarks = total_marks;
	}
	public Date getLastdateofsubmission() {
		return lastdateofsubmission;
	}
	public void setLastdateofsubmission(Date lastdateofsubmission) {
		this.lastdateofsubmission = lastdateofsubmission;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignmentid == null) ? 0 : assignmentid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignmentBean other = (AssignmentBean) obj;
		
		if (assignmentid == null) {
			if (other.assignmentid != null)
				return false;
		} else if (!assignmentid.equals(other.assignmentid))
			return false;
		return true;
	}
	
	
}
