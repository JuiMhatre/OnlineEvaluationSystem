package dao;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import bean.SubjectBean;
import connectionmanager.SessionHelper;

public class SubjectDao {
	SubjectBean subject ;

	public SubjectDao(SubjectBean subject) {
		super();
		this.subject = subject;
	}
	public boolean createSubject()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		session.save(subject);
		transaction.commit();
		session.close();
		return true;
	}
	public SubjectBean readSubject()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		subject = (SubjectBean) session.get(subject.getClass(), subject.getSubjectname());
		
		transaction.commit();
		session.close();
		return subject;
	}
	public boolean updateSubject(int index)
	{
		/*
		 * 1.notesname
		 * 2.notespdf 
		 * 3.addassignmetslist
		 * 
		 * */
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		SubjectBean subjecttemp = subject;
		subject = readSubject();
		if(subject == null)
		{
			return false;
		}
		switch(index)
		{
		case(1):{
			subject.setNotesname(subjecttemp.getNotesname());
			break;
		}
		case(2):{
			subject.setNotespdf(subjecttemp.getNotespdf());
			break;
		}
		case(3):{
			subject.setAssignments(subjecttemp.getAssignments());
		}
		default:{
			System.out.println("wrong option");
		}
		}
		session.update(subject);
		transaction.commit();
		session.close();
		return true;
	}
	public boolean deleteSubject()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		subject = readSubject();
		session.delete(subject);
		transaction.commit();
		session.close();		
		return true;
	}
	public List<SubjectBean> getAllSubjects()
	{
		List<SubjectBean> allsubjects=null;
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		allsubjects = session.createCriteria(SubjectBean.class).list();
		transaction.commit();
		session.close();
		return allsubjects;
	}
}
