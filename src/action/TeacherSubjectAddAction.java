package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.SubjectBean;
import bean.TeachersBean;
import bean.UserBean;
import service.SubjectService;
import service.TeacherService;

public class TeacherSubjectAddAction extends ActionSupport implements ModelDriven<UserBean>{

	TeachersBean teacher = new TeachersBean();
	String subjectname="";
	List<TeachersBean> teacherswithnosubj = new ArrayList<TeachersBean>();
	List<SubjectBean> subjectslist = new ArrayList<SubjectBean>();
	List<SubjectBean> subjectsliststudent= new ArrayList<SubjectBean>();
	
	
	public TeachersBean getTeacher() {
		return teacher;
	}
	public void setTeacher(TeachersBean teacher) {
		this.teacher = teacher;
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
	public List<SubjectBean> getSubjectslist() {
		return subjectslist;
	}
	public void setSubjectslist(List<SubjectBean> subjectslist) {
		this.subjectslist = subjectslist;
	}
	
	public List<SubjectBean> getSubjectsliststudent() {
		return subjectsliststudent;
	}
	public void setSubjectsliststudent(List<SubjectBean> subjectsliststudent) {
		this.subjectsliststudent = subjectsliststudent;
	}
	@Override
	public TeachersBean getModel() {
		// TODO Auto-generated method stub
		return teacher;
	}
	public String mapTeacherSubject()
	{
		TeacherService teacherservice = new TeacherService(teacher) ;
		
		teacher = teacherservice.readTeacher();
		SubjectBean subject= new SubjectBean();
		subject.setSubjectname(subjectname);
		SubjectService subjectservice = new SubjectService(subject);
		subject =subjectservice.readSubject();
		
		teacher.setSubject(subject);
		teacherservice.updateTeacher(teacher);
		UserLoginAction userlogin = new UserLoginAction();
		teacherswithnosubj = userlogin.refreshAdminHometeachers();
		subjectslist = userlogin.refreshSubjectsList();
		subjectsliststudent=userlogin.refreshSubjectListStudent();
		return SUCCESS;
	}
}
