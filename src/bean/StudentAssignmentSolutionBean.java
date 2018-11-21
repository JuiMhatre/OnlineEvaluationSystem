package bean;

import java.io.Serializable;

public class StudentAssignmentSolutionBean  implements Serializable{
	private StudentBean student;
	private AssignmentBean assignment;
	private SolutionBean solution;
	private float marksobtained;
	public StudentBean getStudent() {
		return student;
	}
	public void setStudent(StudentBean student) {
		this.student = student;
	}
	public AssignmentBean getAssignment() {
		return assignment;
	}
	public void setAssignment(AssignmentBean assignment) {
		this.assignment = assignment;
	}
	public SolutionBean getSolution() {
		return solution;
	}
	public void setSolution(SolutionBean solution) {
		this.solution = solution;
	}
	public float getMarksobtained() {
		return marksobtained;
	}
	public void setMarksobtained(float marksobtained) {
		this.marksobtained = marksobtained;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignment == null) ? 0 : assignment.hashCode());
		result = prime * result + ((solution == null) ? 0 : solution.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		StudentAssignmentSolutionBean other = (StudentAssignmentSolutionBean) obj;
		if (assignment == null) {
			if (other.assignment != null)
				return false;
		} else if (!assignment.equals(other.assignment))
			return false;
		if (solution == null) {
			if (other.solution != null)
				return false;
		} else if (!solution.equals(other.solution))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}
	

}
