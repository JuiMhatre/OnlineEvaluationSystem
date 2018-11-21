package dao;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.AssignmentBean;
import connectionmanager.SessionHelper;

public class AssignmentDao {
	private AssignmentBean assignment;

	public AssignmentDao(AssignmentBean assignment) {
		super();
		this.assignment= assignment;
	}
	public boolean createAssignment()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		session.save(assignment);
		transaction.commit();
		session.close();
		return true;
	}
	public AssignmentBean readAssignment()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		assignment= (AssignmentBean) session.get(assignment.getClass(), assignment.getAssignmentid());
		transaction.commit();
		session.close();
		return assignment;
	}
	public boolean deleteAssignment()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		assignment=readAssignment();
		if(assignment== null)
		{
			return false;
		}
		session.delete(assignment);
		transaction.commit();
		session.close();
		return true;
	}


}
