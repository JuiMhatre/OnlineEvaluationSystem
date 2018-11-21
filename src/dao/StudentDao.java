package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.StudentBean;
import bean.SubjectBean;
import bean.TeachersBean;
import bean.StudentAssignmentSolutionBean;
import connectionmanager.SessionHelper;

public class StudentDao {
	StudentBean student;

	public StudentDao(StudentBean student) {
		super();
		this.student = student;
	}
	public boolean createStudent()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
		return true;
	}
	public StudentBean readStudent()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		student = (StudentBean) session.get(student.getClass(), student.getUserid());
		transaction.commit();
		session.close();
		return student;
	}
	public boolean updateStudent( SubjectBean subject)
	{
		/*
		 * 1.password
		 * 2.subjects add
		 * 3.studentclass 
		 * 4.studentassignsolu
		 * 
		 * */
		
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		StudentBean studenttemp = student;
		
		student = readStudent();
		if(student == null)
		{
			return false;
		}
			//student.setPassword(studenttemp.getPassword());
			if(subject !=null)
				student.getSubjects().add(subject);
			student.setStudentclass(studenttemp.getStudentclass());
			
			student.setStudentassignsolu(studenttemp.getStudentassignsolu());
			
			Set<StudentAssignmentSolutionBean> sotri = student.getStudentassignsolu() ;
			System.out.println(sotri.size());
			
		
			Iterator itr=student.getSubjects().iterator();
			
			while(itr.hasNext())
			{
				subject=(SubjectBean) itr.next();
			}
			
			session.update(student);
			
			transaction.commit();
			session.close();
		return true;
	}
	public boolean deleteStudent()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		student=readStudent();
		if(student == null)
		{
			return false;
		}
		session.delete(student);
		transaction.commit();
		session.close();
		return true;
	}
	public List<StudentBean> getAllStudents()
	{
		List<StudentBean> allstudents=new ArrayList<StudentBean>();
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		allstudents = session.createCriteria(StudentBean.class).list();
		
		Iterator itr = allstudents.iterator();
		
		transaction.commit();
		session.close();
		return allstudents;
	}
	public void  updateMarks() {
		// TODO Auto-generated method stub
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		
		Set<StudentAssignmentSolutionBean> sotri = student.getStudentassignsolu() ;
		
		session.update(student);
		transaction.commit();
		session.close();
		
	}
}
