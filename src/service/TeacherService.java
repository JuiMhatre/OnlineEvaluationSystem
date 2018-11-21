package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.SubjectBean;
import bean.TeachersBean;
import bean.UserBean;
import connectionmanager.SessionHelper;
import dao.TeachersDao;

public class TeacherService {

	TeachersBean teacher = new TeachersBean();
	String password="";
	
	public TeacherService(UserBean user) {
		super();
		if(user!=null)
		{
			teacher.setUserid(user.getUserid());
			password=user.getPassword();
		}
		
	}
	public TeachersBean readTeacher()
	{
		TeachersDao teacherdao = new TeachersDao(teacher) ;
		teacher= teacherdao.readTeacher();
		return teacher;
	}
	public TeachersBean updateTeacher(TeachersBean teach)
	{
		TeachersDao teacherdao = new TeachersDao(teach);
		teacherdao.updateTeacher(2);
		return teach;
	}
	public boolean loginValidation(Map<String,Object> map)
	{
		boolean flag = false;
		TeachersDao teacherdao = new TeachersDao(teacher) ;
		teacher = teacherdao.readTeacher();
		
		if(teacher!=null && password.equals(teacher.getPassword()))
			flag= true;
		if(flag)
			map.put("user", teacher);
		return flag;
	}
	public List<TeachersBean> getAllTeachers()
	{
		List<TeachersBean> allteachers=null;
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		allteachers = session.createCriteria(TeachersBean.class).list();
		transaction.commit();
		session.close();
		return allteachers;
	}
	
}
