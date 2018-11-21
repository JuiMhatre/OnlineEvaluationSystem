package dao;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.SolutionBean;
import connectionmanager.SessionHelper;

public class SolutionDao {
	private SolutionBean solution;

	public SolutionDao(SolutionBean solution) {
		super();
		this.solution = solution;
	}
	public boolean createSolution()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		session.save(solution);
		transaction.commit();
		session.close();
		return true;
	}
	public SolutionBean readSolution()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		solution = (SolutionBean) session.get(solution.getClass(), solution.getSolutionid());
		transaction.commit();
		session.close();
		return solution;
	}
	public boolean deletesolution()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		solution=readSolution();
		if(solution == null)
		{
			return false;
		}
		session.delete(solution);
		transaction.commit();
		session.close();
		return true;
	}

}
