package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bean.StudentAssignmentSolutionBean;
import bean.StudentBean;
import bean.SubjectBean;
import bean.UserBean;
import dao.StudentDao;

public class StudentService {
	StudentBean student = new StudentBean();
	String password="";
	public StudentService(UserBean user) {
		super();
		
		if(user!=null)
		{
			student.setUserid(user.getUserid());
			student.setDesignation(user.getDesignation());
			student.setPassword(user.getPassword());
			
			password=user.getPassword();
		}
		
	}
	public boolean loginValidation(Map<String, Object> map)
	{
		boolean flag = false;
		StudentDao studentdao = new StudentDao(student) ;
		student = studentdao.readStudent();
		if(student!=null && password.equals(student.getPassword()))
			flag= true;
		if(flag)
			map.put("user", student);
		return flag;
	}
	public void updateStudent(SubjectBean subject,String studentclass)
	{
		student.setStudentclass(studentclass);
		StudentDao studentdao = new StudentDao(student) ;
		System.out.println("in student service"+student.getStudentassignsolu().size());
		studentdao.updateStudent(subject);
		System.out.println("here5");
	}
	public List<StudentBean> getAllStudentofSubject(SubjectBean subject)
	{
		StudentDao studentdao = new StudentDao(null);
		List<StudentBean> allstudentsofsubject =new ArrayList<StudentBean>(); 
		Iterator itr = studentdao.getAllStudents().iterator();
		System.out.println("all students are "+allstudentsofsubject);
		while(itr.hasNext())
		{
			student =(StudentBean) itr.next();
			System.out.println("subject serached "+subject);
			System.out.println("student name and subjects "+student+"  "+student.getSubjects()+subject.getSubjectname()+student.getName());
			if(student.getSubjects().contains(subject))
			{
				allstudentsofsubject.add(student);
				System.out.println(student.getName()+"  added");
			}
			
			
				
		}
		return allstudentsofsubject;
	}
	public StudentBean readStudent(StudentBean student)
	{
		StudentDao studentdao = new StudentDao(student);
		student=studentdao.readStudent();
		return student;
	}
	public void setTrio(Set<StudentAssignmentSolutionBean> studentassignsolu) {
		// TODO Auto-generated method stub
		student.setStudentassignsolu(studentassignsolu);
	}
	public void updateMarks(StudentBean student) {
		// TODO Auto-generated method stub
		StudentDao studentdao = new StudentDao(student);
		studentdao.updateMarks();
	}
	
}
