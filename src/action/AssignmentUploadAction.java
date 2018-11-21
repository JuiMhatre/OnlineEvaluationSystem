package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Hibernate;
import org.hibernate.Query;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import bean.TeachersBean;
import bean.AssignmentBean;
import bean.SolutionBean;
import bean.StudentAssignmentSolutionBean;
import bean.StudentBean;
import bean.SubjectBean;
import bean.UserBean;
import connectionmanager.SessionHelper;
import dao.AssignmentDao;
import dao.SolutionDao;
import dao.StudentAssignmentSolutionDao;
import dao.SubjectDao;
import javassist.bytecode.Descriptor.Iterator;
import oracle.jdbc.driver.DatabaseError;
import service.AdminService;
import service.StudentService;
import service.SubjectService;
import service.TeacherService;

public class AssignmentUploadAction extends ActionSupport implements ModelDriven<AssignmentBean>,SessionAware {

	AssignmentBean assignment = new AssignmentBean();
	File fileUpload ;
	String fileUploadContentType="";
	String fileUploadFileName="";
	String downloadlink="";
	String downloadname="";
	SubjectBean subject;
	String subjectname="";
	float marksobtained;
	Map<String,Object> map;
	private InputStream fileInputStream;
	String assID;
	List<AssignmentBean> assignmentslist=new ArrayList<AssignmentBean>();
	List<StudentBean> studentslist = new ArrayList<StudentBean>();
	List<SubjectBean> notesavailable = new ArrayList<SubjectBean>();
	List<StudentAssignmentSolutionBean> results = new ArrayList<>();
	List<SubjectBean> subjectslist = new ArrayList<SubjectBean>();
	int userid=0;
	String error="";
	
	@Override
	public AssignmentBean getModel() {
		// TODO Auto-generated method stub
		return assignment;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		map=arg0;
		
		
	}
	
	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public AssignmentBean getAssignment() {
		return assignment;
	}
	public void setAssignment(AssignmentBean assignment) {
		this.assignment = assignment;
	}
	
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	


	public String getAssID() {
		return assID;
	}

	public void setAssID(String assID) {
		this.assID = assID;
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
	
	public double getMarksobtained() {
		return marksobtained;
	}

	public void setMarksobtained(float marksobtained) {
		this.marksobtained = marksobtained;
	}

	public File getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
	
	
	public List<SubjectBean> getNotesavailable() {
		return notesavailable;
	}

	public void setNotesavailable(List<SubjectBean> notesavailable) {
		this.notesavailable = notesavailable;
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

	public String getDownloadlink() {
		return downloadlink;
	}
	public void setDownloadlink(String downloadlink) {
		this.downloadlink = downloadlink;
	}
	public String getDownloadname() {
		return downloadname;
	}
	public void setDownloadname(String downloadname) {
		this.downloadname = downloadname;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}
	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
	public String uploadNotes()
	{
		TeachersBean teacher = (TeachersBean) map.get("user");
		SubjectBean subject = teacher.getSubject();
		subject.setNotesname(fileUploadFileName);				
		//file copy
		String pathassignment="C:/Users/namemh/Desktop/Serverfiles/Notes/"+fileUploadFileName;
		File file = new File(fileUpload.getAbsolutePath());
		file.renameTo(new File(pathassignment));
		//set subject parameters
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Blob blob= Hibernate.getLobCreator(helper.getHibernateSesion()).createBlob(pathassignment.getBytes());
		
		subject.setNotespdf(blob);
		
		SubjectService subjectservice =new SubjectService(subject);
		subjectservice.updateSubjectNotes();
		refresh(teacher);
		return SUCCESS;
	}
	public String uploadNotestemp()
	{
		
		this.subject = ((TeachersBean)map.get("user")).getSubject();
		
		TeachersBean teacher = (TeachersBean) map.get("user");
		if(fileUpload==null)
		{
			error ="Please Select The File To Be Uploaded!!";
			refresh(teacher);
			return SUCCESS;
		}
		try{
		SubjectBean subject = teacher.getSubject();
		subject.setNotesname(fileUploadFileName);				
		//file copy
	
		String pathassignment="C:/Users/namemh/workspace/MIS_AssignmentEvaluationSystem/ServerFiles/Notes/";
		File file = new File(pathassignment,fileUploadFileName);		
		try {
			FileUtils.copyFile(fileUpload, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//set subject parameters
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Blob blob= Hibernate.getLobCreator(helper.getHibernateSesion()).createBlob(pathassignment.getBytes());
		subject.setNotespdf(blob);
		
		SubjectService subjectservice =new SubjectService(subject);
		subjectservice.updateSubjectNotes();
		refresh(teacher);
		}
		catch(Exception e)
		{
			error="Error occured";
			refresh(teacher);
			return SUCCESS;
		}
		return SUCCESS;
	}
	public String solutionUpload()
	{
		if(fileUpload==null)
		{
			error="File To Be Uploaded Not Selected!!";
			refreshStudent();
			return "failure";
		}
		assignment.setAssignmentid(assID);
		AssignmentDao assignmentdao = new AssignmentDao(assignment) ;
		assignment=assignmentdao.readAssignment();
		StudentBean student = (StudentBean) map.get("user");
		SolutionBean solution = new SolutionBean();
		long time = System.currentTimeMillis();
		java.sql.Date sqlDate = new java.sql.Date(time);
		solution.setDatesubmited(sqlDate);
		solution.setSolutionid("Solution_"+downloadlink+"_"+student.getUserid());
		solution.setSolutionname(fileUploadFileName);
		String pathassignment="C:/Users/namemh/workspace/MIS_AssignmentEvaluationSystem/ServerFiles/Solutions/";
		File file = new File(pathassignment,fileUploadFileName);
		try {
			FileUtils.copyFile(fileUpload, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//set subject parameters
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Blob blob= Hibernate.getLobCreator(helper.getHibernateSesion()).createBlob(pathassignment.getBytes());
		
		solution.setSolutionset(blob);
		SolutionDao solndao = new SolutionDao(solution);
		solndao.createSolution();
		
		StudentAssignmentSolutionBean triobean = new StudentAssignmentSolutionBean();
		triobean.setStudent(student);
		triobean.setSolution(solution);
		triobean.setAssignment(assignment);
		triobean.setMarksobtained(0);
		
		StudentAssignmentSolutionDao triodao = new StudentAssignmentSolutionDao(triobean);
		//triodao.createStudentAssignmentSolution();
		Set<StudentAssignmentSolutionBean> sotri =student.getStudentassignsolu();
		sotri.add(triobean);
		student.setStudentassignsolu(sotri);
		
		StudentService  studentservice = new StudentService(student);
		studentservice.setTrio(student.getStudentassignsolu());
		
		studentservice.updateStudent(null, student.getStudentclass());
		
		
		refreshStudent();
		return SUCCESS;
		
	}
	private void refresh(TeachersBean teacher) {
		// TODO Auto-generated method stub
		TeacherService teacherservice = new TeacherService(teacher);
		subjectname=teacher.getSubject().getSubjectname();
		Set<AssignmentBean> temp = teacherservice.readTeacher().getSubject().getAssignments();
		for (AssignmentBean assignmentBean : temp) {
			assignmentslist.add(assignmentBean);
			
		}
		
		StudentService studentservice = new StudentService(null);
		studentslist=studentservice.getAllStudentofSubject(teacherservice.readTeacher().getSubject());
	}
	public String uploadAssignmentTemp()
	{
		
		TeachersBean teacher = (TeachersBean) map.get("user");
		if(fileUpload == null)
		{
			error="Select The File To Be Uplaoded!!";
			refresh(teacher);
			return SUCCESS;
		}
		
		//file copy
		try{
		assignment.setQuestionarename(fileUploadFileName);
		String pathassignment="C:/Users/namemh/workspace/MIS_AssignmentEvaluationSystem/ServerFiles/Assignments/";
		File file = new File(pathassignment,fileUploadFileName);		
		try {
			FileUtils.copyFile(fileUpload, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Blob blob= Hibernate.getLobCreator(helper.getHibernateSesion()).createBlob(pathassignment.getBytes());
		assignment.setQuestionare(blob);
		long time = System.currentTimeMillis();
		java.sql.Date sqlDate = new java.sql.Date(time);
		int temp=sqlDate.getDate()+10;
		sqlDate.setDate(temp);
		
		assignment.setTotalmarks(100);
		assignment.setLastdateofsubmission(sqlDate);
		assignment.setAssignmentid(teacher.getSubject().getSubjectname()+"_"+assignment.getQuestionarename()+"_"+assignment.getLastdateofsubmission());
		AssignmentDao assignementdao = new AssignmentDao(assignment);
		assignementdao.createAssignment();
		//add assignment to subject
		SubjectBean subject= teacher.getSubject();
		subject.getAssignments().add(assignment);
		SubjectService subjectservice= new SubjectService(subject);
		subjectservice.updateSubjectAssignmentlist();
		
		refresh(teacher);
		}
		catch(Exception e)
		{
			error="Error Occured";
			refresh(teacher);
			return SUCCESS;
		}
		return SUCCESS;
	}
	public String uploadAssignment()
	{
		this.subject = ((TeachersBean)map.get("user")).getSubject();
		
		TeachersBean teacher = (TeachersBean) map.get("user");
		//file copy
		assignment.setQuestionarename(fileUploadFileName);
		String pathassignment="C:/Users/namemh/Desktop/Serverfiles/Assignments/"+fileUploadFileName;
		File file = new File(fileUpload.getAbsolutePath());
		file.renameTo(new File(pathassignment));
		//set assignment parameters
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Blob blob= Hibernate.getLobCreator(helper.getHibernateSesion()).createBlob(pathassignment.getBytes());
		assignment.setQuestionare(blob);
		long time = System.currentTimeMillis();
		java.sql.Date sqlDate = new java.sql.Date(time);
		int temp=sqlDate.getDate()+10;
		sqlDate.setDate(temp);
		
		assignment.setTotalmarks(100);
		assignment.setLastdateofsubmission(sqlDate);
		assignment.setAssignmentid(teacher.getSubject().getSubjectname()+"_"+assignment.getQuestionarename()+"_"+assignment.getLastdateofsubmission());
		AssignmentDao assignementdao = new AssignmentDao(assignment);
		assignementdao.createAssignment();
		//add assignment to subject
		SubjectBean subject= teacher.getSubject();
		subject.getAssignments().add(assignment);
		SubjectService subjectservice= new SubjectService(subject);
		subjectservice.updateSubjectAssignmentlist();
		refresh(teacher);
		
		return SUCCESS;
	}
	public String checkAssignment()
	{
		try{
		
		StudentBean student =new StudentBean();
		student.setUserid(userid);
		StudentService  studentservice = new StudentService(student);
		student = studentservice.readStudent(student);
		
		Set<StudentAssignmentSolutionBean> stuasssol = student.getStudentassignsolu();
		AssignmentBean assigntemp;
		StudentAssignmentSolutionBean mapsol=null;
		
		for (StudentAssignmentSolutionBean studentAssignmentSolutionBean : stuasssol) {
			assigntemp=studentAssignmentSolutionBean.getAssignment();
			if(assignment.getAssignmentid().equals(assigntemp.getAssignmentid()))
			{
				mapsol=studentAssignmentSolutionBean;
			}
		}
		if(mapsol==null)
		{
			
			error="Solution Has Not Been Uploaded";
			TeachersBean teacher = (TeachersBean) map.get("user");
			refresh(teacher);
			return ERROR;
		}
		
		downloadlink=mapsol.getSolution().getSolutionname();
		
		downloadname=downloadNotestemp("Solutions");
		
		assID=assignment.getAssignmentid();
		TeachersBean teacher = (TeachersBean) map.get("user");
		refresh(teacher);
		
		return SUCCESS;
		}
		catch(NullPointerException e)
		{
			TeachersBean teacher = (TeachersBean) map.get("user");
			refresh(teacher);
			error="Student Has Not Submitted The Solution!!";
			return SUCCESS;
		}
		catch (Exception e) {
			// TODO: handle exception
			TeachersBean teacher = (TeachersBean) map.get("user");
			refresh(teacher);
			error="Error Occured In Downloading The Solution!!";
			return SUCCESS;
		}
	}
	public String giveStudentsList()
	{
		
		return SUCCESS;
	}
	
	public String submitMarks()
	{
		if(marksobtained >100)
		{
			error="Marks should not be greater than 100...Please enter valid marks";
			TeachersBean teacher = (TeachersBean) map.get("user");
			refresh(teacher);
			return ERROR;
		}
		try{
		StudentBean student =new StudentBean();
		student.setUserid(userid);
		StudentService  studentservice = new StudentService(student);
		student = studentservice.readStudent(student);
		Set<StudentAssignmentSolutionBean> stuasssol = student.getStudentassignsolu();
		AssignmentBean assigntemp;
		StudentAssignmentSolutionBean mapsol=null;
		for (StudentAssignmentSolutionBean studentAssignmentSolutionBean : stuasssol) {
			assigntemp=studentAssignmentSolutionBean.getAssignment();
			if(assignment.getAssignmentid().equals(assigntemp.getAssignmentid()))
			{
				mapsol=studentAssignmentSolutionBean;
			}
		}
		if(mapsol==null)
		{
		
			error="Solution Has Not Been Uploaded";
			TeachersBean teacher = (TeachersBean) map.get("user");
			refresh(teacher);
			return ERROR;
		}
		
		mapsol.setMarksobtained(marksobtained);
		studentservice.updateMarks(student);
		TeachersBean teacher = (TeachersBean) map.get("user");
		refresh(teacher);
		return SUCCESS;
		}
		catch (Exception e) {
			// TODO: handle exception
			TeachersBean teacher = (TeachersBean) map.get("user");
			refresh(teacher);
			error="Error Occured In Updating Marks!!";
			return SUCCESS;
		}
	}
	public String downloadNotes()
	{
		TeachersBean teacher = (TeachersBean) map.get("user");
		downloadlink=teacher.getSubject().getNotesname();
		TeacherService teacherservice = new TeacherService(teacher);
		downloadname=downloadNotestemp("Notes");
		return SUCCESS;
	}
	public String downloadNotesSt()
	{
		subject= new SubjectBean();
		subject.setSubjectname(downloadlink);
		SubjectService subjectservice =new SubjectService(subject);
		subject=subjectservice.readSubject();
		downloadlink=subject.getNotesname();
		
		downloadname=downloadNotestemp("Notes");
		return SUCCESS;
	}
	public String downloadAssignSt()
	{
		downloadlink=ServletActionContext.getRequest().getParameter("downloadlink");
		
		downloadname=downloadNotestemp("Assignments");
		return SUCCESS;
	}
	public String downloadNotestemp(String folder)
	{
		
		
		 File fileToDownload = new File("C:/Users/namemh/workspace/MIS_AssignmentEvaluationSystem/ServerFiles/"+folder+"/"+downloadlink);
		try {
			fileInputStream=new FileInputStream(fileToDownload);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//downloadname=fileToDownload.getName();
		
		downloadname =fileToDownload.getAbsolutePath();
		downloadlink=fileToDownload.getName();
		
		return downloadname;
	}
	public void refreshStudent()
	{
		
		SubjectDao subjectdao = new SubjectDao(null);
		List<SubjectBean> subjects = new ArrayList<SubjectBean>();
		subjectslist = subjectdao.getAllSubjects();
		
		
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
			results.add(studentAssignmentSolutionBean);
		}
		
	}
}
