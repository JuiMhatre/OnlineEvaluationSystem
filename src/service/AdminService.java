package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bean.AdminBean;
import bean.SubjectBean;
import bean.TeachersBean;
import bean.UserBean;
import dao.AdminDao;
import dao.SubjectDao;
import dao.TeachersDao;

public class AdminService {

	AdminBean admin =new AdminBean();
	String password ="";

	public AdminService(UserBean user) {
		super();
		admin.setUserid(user.getUserid());
		password = user.getPassword();
		this.admin = admin;
	}
	public boolean loginValidation(Map<String,Object> map)
	{
		boolean flag =false;
		AdminDao admindao = new AdminDao(admin);
		admin=admindao.readAdmin();
		//System.out.println("admin details "+admin.getName() + admin.getSalary());
		if(admin !=null && admin.getPassword().equals(password))
			flag=true;
		if(flag)
			map.put("user", admin);
		return flag;
	}
	public List<TeachersBean> getUnassignedTeachers()
	{
		TeachersDao teachersdao =new TeachersDao(null) ;
		List<TeachersBean> unassignedteachers = new ArrayList<TeachersBean>() ;
		Iterator itr = teachersdao.getAllTeachers().iterator();
		TeachersBean teacher = null;
		while(itr.hasNext())
		{
			teacher =(TeachersBean) itr.next();
			if(teacher.getSubject()==null)
			{
				unassignedteachers.add(teacher);
				System.out.println(teacher.getName());
			}
		}
		
		return unassignedteachers;
	}
	
	public List<SubjectBean> getAllSubjects()
	{
		SubjectDao subjectdao = new SubjectDao(null);
		List<SubjectBean> subjects = new ArrayList<SubjectBean>();
		subjects = subjectdao.getAllSubjects();
		TeacherService teacherservice = new TeacherService(null);
		List<TeachersBean> teacherslist = teacherservice.getAllTeachers();
		for (TeachersBean teachersBean : teacherslist) {
			if(teachersBean.getSubject()!=null)
			{
				if(subjects.contains(teachersBean.getSubject()))
				{
					subjects.remove(teachersBean.getSubject());
				}
			}
		}
		return subjects;
	}
	public List<SubjectBean> getAllSubjectStudents()
	{
		SubjectDao subjectdao = new SubjectDao(null);
		List<SubjectBean> subjects = new ArrayList<SubjectBean>();
		subjects = subjectdao.getAllSubjects();
		return subjects;
	}
	
}
