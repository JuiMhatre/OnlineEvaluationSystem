package action;

import java.awt.print.Printable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.AssignmentBean;
import bean.StudentAssignmentSolutionBean;
import bean.StudentBean;
import bean.SubjectBean;
import bean.TeachersBean;
import bean.UserBean;
import connectionmanager.SessionHelper;
import javassist.bytecode.Descriptor.Iterator;
import service.AdminService;
import service.StudentService;
import service.SubjectService;
import service.TeacherService;
import service.UploadDownload;

public class UserLoginAction extends ActionSupport implements ModelDriven<UserBean>, SessionAware{

	UserBean user =new UserBean();
	String subjectname="";
	SubjectBean subject = new SubjectBean();
	List<TeachersBean> teacherswithnosubj = new ArrayList<TeachersBean>();
	List<SubjectBean> subjectslist = new ArrayList<SubjectBean>();
	List<SubjectBean> subjectsliststudent = new ArrayList<SubjectBean>();
	List<AssignmentBean> assignmentslist=new ArrayList<AssignmentBean>();
	List<StudentBean> studentslist = new ArrayList<StudentBean>();
	String downloadlink="";
	String downloadname="";
	List<SubjectBean> notesavailable = new ArrayList<SubjectBean>();
	List<StudentAssignmentSolutionBean> results = new ArrayList<>();
	Map<String, Object> map;
	FileInputStream fileInputStream;
	String error="";
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
	
	
	public List<SubjectBean> getNotesavailable() {
		return notesavailable;
	}
	public void setNotesavailable(List<SubjectBean> notesavailable) {
		this.notesavailable = notesavailable;
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
	public FileInputStream getFileInputStream() {
		return fileInputStream;
	}
	public void setFileInputStream(FileInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
	public String getDownloadname() {
		return downloadname;
	}
	public void setDownloadname(String downloadname) {
		this.downloadname = downloadname;
	}
	public List<SubjectBean> getSubjectslist() {
		return subjectslist;
	}
	public void setSubjectslist(List<SubjectBean> subjectslist) {
		this.subjectslist = subjectslist;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public SubjectBean getSubject() {
		return subject;
	}
	public void setSubject(SubjectBean subject) {
		this.subject = subject;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<StudentAssignmentSolutionBean> getResults() {
		return results;
	}
	public void setResults(List<StudentAssignmentSolutionBean> results) {
		this.results = results;
	}
	public List<AssignmentBean> getAssignmentslist() {
		return assignmentslist;
	}
	public void setAssignmentslist(List<AssignmentBean> assignmentslist) {
		this.assignmentslist = assignmentslist;
	}
	public List<StudentBean> getStudentslist() {
		return studentslist;
	}
	public void setStudentslist(List<StudentBean> studentslist) {
		this.studentslist = studentslist;
	}
	
	public String loginValidation()
	{
		if(user.getUserid()==0)
		{
			error="Please Enter User Identification Number!!";
			return "failure";
		}
		if(user.getPassword().equals(""))
		{
			error="Please Enter Password!!";
			return "failure";
		}
		SessionHelper helper = new SessionHelper();
		boolean flag =true;
		String str="failure";
		try
		{
		ServletActionContext.getContext().getApplication().put("HELPER", helper);
		
		if(user.getDesignation().equals("ADMIN"))
		{
			AdminService adminservice = new AdminService(user);
			flag=adminservice.loginValidation(map);
			if(!flag)
			{
				error="Wrong Details Entered...Cannot Identify The User";
				helper.closeSessionfactory();
				
				return "failure";
			}
			teacherswithnosubj= adminservice.getUnassignedTeachers();
			subjectslist = adminservice.getAllSubjects();
			subjectsliststudent=adminservice.getAllSubjectStudents();
			
			str="ADMIN";
		}
		else
		{
			if(user.getDesignation().equals("TEACHER"))
			{
				TeacherService teacherservice = new TeacherService(user);
				flag=teacherservice.loginValidation(map);
				
				if(flag==false)
				{
					error="Wrong Details Entered...Cannot Identify The User";
					helper.closeSessionfactory();
					
					return "failure";
				}
				str="TEACHER";
				
				if(teacherservice.readTeacher().getSubject() == null)
				{
					error="No Subject Assigned To Teacher...Please Contact Admin!!";
					str= "NOASSIGNMENT";
					helper.closeSessionfactory();
					
					return str;
				}
				Set<AssignmentBean> temp = teacherservice.readTeacher().getSubject().getAssignments();
				for (AssignmentBean assignmentBean : temp) {
					assignmentslist.add(assignmentBean);
				
				}
				subjectname=teacherservice.readTeacher().getSubject().getSubjectname();
				StudentService studentservice = new StudentService(null);
				studentslist=studentservice.getAllStudentofSubject(teacherservice.readTeacher().getSubject());
				UploadDownload updwn = new UploadDownload();
				downloadname=updwn.downloadNotestemp(map,fileInputStream);
//				downloadname ="C:/Users/namemh/Desktop/Serverfiles/Notes/"+teacherservice.readTeacher().getSubject().getNotesname();
			}
			else
			{
				if(user.getDesignation().equals("STUDENT"))
				{
					StudentService studentservice = new StudentService(user);
					flag = studentservice.loginValidation(map);
					
					if(!flag)
					{
						error="Wrong Details Entered...Cannot Identify The User";
						helper.closeSessionfactory();
						
						return "failure";
					}
					if(flag)
					{
					AdminService adminservice = new AdminService(user);
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
					for (StudentAssignmentSolutionBean studentAssignmentSolutionBean : temp1) {
					{
						
						results.add(studentAssignmentSolutionBean);
					}
					}
					}
					str="STUDENT";
				}
			}
		}
		}
		catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
			error="Wrong Details Entered...Cannot Identify The User";
		}
		catch(Exception e)
		{
			error ="Some Unkown Exception Occured...Please Relogin";
			
			e.printStackTrace();
		}
		if(str.equals("failure")||str.equals("NOASSIGNMENT"))
		{
			helper.closeHibernateSession();
			helper.closeSessionfactory();
			
		}
		return str;
		
	}
	public String createNewSubject()
	{
		
		try
		{
			if(subjectname.equals(""))
			{
				error ="Enter Subject Name!!";
				AdminService adminservice = new AdminService(user);
				teacherswithnosubj= adminservice.getUnassignedTeachers();
				subjectslist = adminservice.getAllSubjects();
				subjectsliststudent=adminservice.getAllSubjectStudents();
				return "NOSUBJECT";
			}
		subject.setSubjectname(subjectname);
		
		SubjectService subjectservice = new SubjectService(subject);
		subjectservice.addSubject();
		AdminService adminservice = new AdminService(user);
		teacherswithnosubj= adminservice.getUnassignedTeachers();
		subjectslist = adminservice.getAllSubjects();
		subjectsliststudent=adminservice.getAllSubjectStudents();
		}
		catch(Exception e)
		{
			error ="Some Exception occured";
			return "SOMEERROR";
		}
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.map=arg0;
	}
	public List<TeachersBean> refreshAdminHometeachers()
	{
		AdminService adminservice = new AdminService(user);
		teacherswithnosubj= adminservice.getUnassignedTeachers();
		return teacherswithnosubj;
	}
	public List<SubjectBean> refreshSubjectsList()
	{
		AdminService adminservice = new AdminService(user);
		subjectslist = adminservice.getAllSubjects();
		return subjectslist;
	}
	public List<SubjectBean> refreshSubjectListStudent()
	{
		AdminService adminservice = new AdminService(user);
		subjectsliststudent = adminservice.getAllSubjectStudents();
		return subjectsliststudent;
	}
	
}
