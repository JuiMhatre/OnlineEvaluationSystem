package service;

import bean.AdminBean;
import bean.StudentBean;
import bean.TeachersBean;
import bean.UserBean;
import dao.AdminDao;
import dao.StudentDao;
import dao.TeachersDao;

public class LoginService {
	public boolean register(UserBean user)
	{
		boolean flag =false;
		switch(user.getDesignation())
		{
			case("ADMIN"):{
				try{
				AdminBean admin = new AdminBean();
				admin.setDesignation(user.getDesignation());
				admin.setName(user.getName());
				admin.setPassword(user.getPassword());
				admin.setUserid(admin.getUserid());
				admin.setSalary(2000);
				AdminDao admindao = new AdminDao(admin);
				admindao.createadmin();
				flag =true;
				break;			
				}
				catch(Exception e)
				{
					
				}
			}
			case("TEACHER"):{
				try
				{
				TeachersBean teacher = new TeachersBean();
				teacher.setDesignation(user.getDesignation());
				teacher.setName(user.getName());
				teacher.setPassword(user.getPassword());
				teacher.setUserid(user.getUserid());
				TeachersDao teacherdao = new TeachersDao(teacher);
				teacherdao.createTeacher();
				flag =true;
				break;
				}
				catch(Exception e)
				{}
			}
			case("STUDENT"):{
				try{
				StudentBean student = new  StudentBean();
				student.setDesignation(user.getDesignation());
				student.setName(user.getName());
				student.setPassword(user.getPassword());
				System.out.println("student password is "+student.getPassword()+"  "+user.getPassword());
				StudentDao studentdao = new StudentDao(student);
				studentdao.createStudent();
				flag =true;
				break;
				}
				catch(Exception e)
				{}
			}
		}
		return flag;
	}


}
