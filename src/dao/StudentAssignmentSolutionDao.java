package dao;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.StudentAssignmentSolutionBean;
import bean.StudentBean;
import connectionmanager.SessionHelper;

public class StudentAssignmentSolutionDao {
	
	StudentAssignmentSolutionBean studentassignmentsoln ;

	public StudentAssignmentSolutionDao(StudentAssignmentSolutionBean studentassignmentsoln) {
		super();
		this.studentassignmentsoln = studentassignmentsoln;
	}
	public boolean createStudentAssignmentSolution()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		
		session.save(studentassignmentsoln);
		transaction.commit();
		session.close();
		return true;
	}
	public StudentAssignmentSolutionBean readStudentAssignmentSolution()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		studentassignmentsoln = (StudentAssignmentSolutionBean) session.get(studentassignmentsoln.getClass(),studentassignmentsoln); 
	
		transaction.commit();
		session.close();
		return studentassignmentsoln;
	}
}
