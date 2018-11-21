package bean;

import java.util.HashSet;
import java.util.Set;

public class StudentBean extends UserBean {
	private String studentclass;
	private Set<SubjectBean> subjects;
	private Set<StudentAssignmentSolutionBean> studentassignsolu = new HashSet<StudentAssignmentSolutionBean>()  ;
	
	public String getStudentclass() {
		return studentclass;
	}
	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}
	public Set<SubjectBean> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<SubjectBean> subjects) {
		this.subjects = subjects;
	}
	public Set<StudentAssignmentSolutionBean> getStudentassignsolu() {
		return studentassignsolu;
	}
	public void setStudentassignsolu(Set<StudentAssignmentSolutionBean> studentassignsolu) {
		this.studentassignsolu = studentassignsolu;
	}
	
	
	
}
