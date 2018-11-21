package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.StudentBean;
import bean.SubjectBean;
import bean.TeachersBean;
import bean.UserBean;
import dao.StudentDao;
import service.StudentService;
import service.SubjectService;

public class StudentSubjectClass extends ActionSupport implements ModelDriven<StudentBean>{

	StudentBean student = new StudentBean();
	String subjectname="";
	List<TeachersBean> teacherswithnosubj = new ArrayList<TeachersBean>();
	List<SubjectBean> subjectslist =new ArrayList<SubjectBean>();
	List<SubjectBean> subjectsliststudent =new ArrayList<SubjectBean>();
	String error="";
	@Override
	public StudentBean getModel() {
		// TODO Auto-generated method stub
		return student;
	}
	public StudentBean getStudent() {
		return student;
	}
	
	public List<SubjectBean> getSubjectslist() {
		return subjectslist;
	}
	public void setSubjectslist(List<SubjectBean> subjectslist) {
		this.subjectslist = subjectslist;
	}
	public void setStudent(StudentBean student) {
		this.student = student;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	
	public List<TeachersBean> getTeacherswithnosubj() {
		return teacherswithnosubj;
	}
	public void setTeacherswithnosubj(List<TeachersBean> teacherswithnosubj) {
		this.teacherswithnosubj = teacherswithnosubj;
	}
	
	
	public List<SubjectBean> getSubjectsliststudent() {
		return subjectsliststudent;
	}
	public void setSubjectsliststudent(List<SubjectBean> subjectsliststudent) {
		this.subjectsliststudent = subjectsliststudent;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String mapStudentSubjectClass()
	{
		if(student.getUserid()==0)
		{
			UserLoginAction userlogin = new UserLoginAction();
			teacherswithnosubj = userlogin.refreshAdminHometeachers();
			subjectslist = userlogin.refreshSubjectsList();
			subjectsliststudent=userlogin.getSubjectsliststudent();
			error="Student ID cannot be zero!!";
			return "failure";
		}
		try
		{
		String studentclas = student.getStudentclass();
		
		SubjectBean subject = new SubjectBean();
		subject.setSubjectname(subjectname);
		SubjectService subjectservice = new SubjectService(subject) ;
		subject=subjectservice.readSubject();
		
		StudentService studentservice = new StudentService(student);
		
		studentservice.updateStudent(subject,studentclas);
		
		UserLoginAction userlogin = new UserLoginAction();
		teacherswithnosubj = userlogin.refreshAdminHometeachers();
		subjectslist = userlogin.refreshSubjectsList();
		subjectsliststudent=userlogin.refreshSubjectListStudent();
		}
		catch(NullPointerException e)
		{
			UserLoginAction userlogin = new UserLoginAction();
			teacherswithnosubj = userlogin.refreshAdminHometeachers();
			subjectslist = userlogin.refreshSubjectsList();
			subjectsliststudent=userlogin.refreshSubjectListStudent();
			error ="Wrong details entered!!";
			return "failure";
		}
		return SUCCESS;
	}
	

}
