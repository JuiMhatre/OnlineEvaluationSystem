package bean;

import java.sql.Blob;
import java.util.Set;

public class SubjectBean {
	private String subjectname;
	private String notesname;
	private Blob notespdf;
	private Set<AssignmentBean> assignments;
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getNotesname() {
		return notesname;
	}
	public void setNotesname(String notesname) {
		this.notesname = notesname;
	}
	public Blob getNotespdf() {
		return notespdf;
	}
	public void setNotespdf(Blob notespdf) {
		this.notespdf = notespdf;
	}
	public Set<AssignmentBean> getAssignments() {
		return assignments;
	}
	public void setAssignments(Set<AssignmentBean> assignments) {
		this.assignments = assignments;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subjectname == null) ? 0 : subjectname.hashCode());
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
		SubjectBean other = (SubjectBean) obj;
		if (subjectname == null) {
			if (other.subjectname != null)
				return false;
		} else if (!subjectname.equals(other.subjectname))
			return false;
		return true;
	}
	
	

}
