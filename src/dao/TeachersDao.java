package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.SubjectBean;
import bean.TeachersBean;
import connectionmanager.SessionHelper;

public class TeachersDao {
	TeachersBean teacher;

	public TeachersDao(TeachersBean teacher) {
		super();
		this.teacher = teacher;
	}
	public boolean createTeacher()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		session.save(teacher);
		transaction.commit();
		session.close();
		return true;
	}
	public TeachersBean readTeacher()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		teacher = (TeachersBean) session.get(teacher.getClass(), teacher.getUserid());
		transaction.commit();
		session.close();
		return teacher;
	}
	public boolean updateTeacher(int index)
	{
		/*
		 * 1.password
		 * 2.subject 
		 * 
		 * 
		 * */
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		TeachersBean teachertemp = teacher;
		teacher = readTeacher();
		if(teacher == null)
		{
			return false;
		}
		switch(index)
		{
		case(1):{
			teacher.setPassword(teachertemp.getPassword());
			break;
		}
		case(2):{
			teacher.setSubject(teachertemp.getSubject());
			
			break;
		}
		default:{
			System.out.println("wrong option");
		}
		}
		session.update(teacher);
		transaction.commit();
		session.close();
		return true;
	}
	public boolean deleteTeacher()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		teacher=readTeacher();
		if(teacher == null)
		{
			return false;
		}
		session.delete(teacher);
		transaction.commit();
		session.close();
		return true;
	}
	public List<TeachersBean> getAllTeachers()
	{
		List<TeachersBean> allteachers=new ArrayList<TeachersBean>();
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		allteachers = session.createCriteria(TeachersBean.class).list();
		
		transaction.commit();
		session.close();
		return allteachers;
	}
}
