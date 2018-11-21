package action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.AssignmentBean;
import bean.StudentAssignmentSolutionBean;
import bean.StudentBean;
import bean.SubjectBean;
import bean.UserBean;
import service.AdminService;
import service.StudentHomePageService;
import service.StudentService;
import service.SubjectService;

public class StudentHomeAction extends ActionSupport implements ModelDriven<UserBean>, SessionAware {

	UserBean user = new UserBean();
	Set<StudentAssignmentSolutionBean> studentsols;
	List<SubjectBean> unenrolledsubjects;
	StudentHomePageService studenthomepageservice ;
	Set<SubjectBean> subjects;
	StudentBean student;
	String subjectname="";
	List<AssignmentBean> unsolvedassignments;
	List<SubjectBean> subjectslist = new ArrayList<SubjectBean>();
	Map<String,Object> map;
	List<SubjectBean> notesavailable = new ArrayList<SubjectBean>();
	List<AssignmentBean> assignmentslist=new ArrayList<AssignmentBean>();
	List<StudentAssignmentSolutionBean> results = new ArrayList<>();
	@Override
	public UserBean getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	public void initializeStudentHomePage()
	{
		studenthomepageservice = new   StudentHomePageService(user) ;
		student= studenthomepageservice.getStudentDetails();
	}
	public void viewResult()
	{		
		studentsols = student.getStudentassignsolu();
	}
	public void unenrolledSubjectsListing()
	{
		unenrolledsubjects = studenthomepageservice.getAllUnenrolledSubjects();
	}
	public void getNotes()
	{
		subjects =student.getSubjects();
	}
	
	

	public List<SubjectBean> getNotesavailable() {
		return notesavailable;
	}

	public void setNotesavailable(List<SubjectBean> notesavailable) {
		this.notesavailable = notesavailable;
	}

	public List<AssignmentBean> getAssignmentslist() {
		return assignmentslist;
	}

	public void setAssignmentslist(List<AssignmentBean> assignmentslist) {
		this.assignmentslist = assignmentslist;
	}

	public List<StudentAssignmentSolutionBean> getResults() {
		return results;
	}

	public void setResults(List<StudentAssignmentSolutionBean> results) {
		this.results = results;
	}

	public List<SubjectBean> getSubjectslist() {
		return subjectslist;
	}

	public void setSubjectslist(List<SubjectBean> subjectslist) {
		this.subjectslist = subjectslist;
	}

	public void getAssignments()
	{
		unsolvedassignments = studenthomepageservice.getUnsolvedAssignments();
	}
	
	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String studentSubjectSelect()
	{
		student = (StudentBean) map.get("user");
		
		AdminService adminservice = new AdminService(user);
		SubjectBean subject = new SubjectBean();
		subject.setSubjectname(subjectname);
		SubjectService subjectservice = new SubjectService(subject);
		subject = subjectservice.readSubject();
		
		Set<StudentAssignmentSolutionBean> trio= student.getStudentassignsolu();
		StudentService studentservice = new StudentService(student);
		studentservice.setTrio(trio);
		studentservice.updateStudent(subject, student.getStudentclass());
		subjectslist = adminservice.getAllSubjectStudents();
		
		Set<SubjectBean> subjtemp=((StudentBean)map.get("user")).getSubjects();
		Set<AssignmentBean> temp;
		for (SubjectBean subjectBean : subjtemp) {
			if(subjectBean.getNotesname()!=null)
				notesavailable.add(subjectBean);
			temp=subjectBean.getAssignments();
			for (AssignmentBean assignmentBean : temp) {
				assignmentslist.add(assignmentBean);
				
			}
		}
		Set<StudentAssignmentSolutionBean> temp1=((StudentBean)map.get("user")).getStudentassignsolu();
		for (StudentAssignmentSolutionBean studentAssignmentSolutionBean : temp1) 
		{
			
			results.add(studentAssignmentSolutionBean);
		}
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		map=arg0;
	}
}
