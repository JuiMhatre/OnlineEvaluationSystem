package service;

import java.util.Iterator;
import java.util.List;

import bean.AssignmentBean;
import bean.StudentAssignmentSolutionBean;
import bean.StudentBean;
import bean.SubjectBean;
import bean.UserBean;
import dao.StudentDao;
import dao.SubjectDao;

public class StudentHomePageService {
	StudentDao studentdao;

	public StudentHomePageService(UserBean user) {
		super();
		StudentBean student =new StudentBean();
		student.setUserid(user.getUserid());
		student.setName(user.getName());
		student.setDesignation(user.getDesignation());
		student.setPassword(user.getPassword());
		
		this.studentdao = new StudentDao(student);
		
	}
	public StudentBean getStudentDetails()
	{
		return studentdao.readStudent();		
	}
	public List<SubjectBean> getSubjects()
	{
		Iterator itr = studentdao.readStudent().getSubjects().iterator();
	    SubjectDao subjectdao = new SubjectDao((SubjectBean)itr.next()) ;
	    List<SubjectBean> allsubjects = subjectdao.getAllSubjects();
	    return allsubjects;
	}
	public List<SubjectBean> getAllUnenrolledSubjects()
	{
		Iterator itr = studentdao.readStudent().getSubjects().iterator();
		SubjectBean subject = (SubjectBean)itr.next();
	    SubjectDao subjectdao = new SubjectDao(subject) ;
	    List<SubjectBean> unenrolled = getSubjects();
	    do
	    {
	    	unenrolled.remove(subject);
	    	subject=null;
	    	subject = (SubjectBean)itr.next();
	    }
	    while(itr.hasNext());
	    return unenrolled;
	}
	public List<AssignmentBean> getUnsolvedAssignments()
	{
		List<AssignmentBean> solvedassignments = null;
		Iterator itr = studentdao.readStudent().getStudentassignsolu().iterator();
		while(itr.hasNext())
			solvedassignments.add(((StudentAssignmentSolutionBean)itr.next()).getAssignment());
		List<AssignmentBean> unsolvedassignments = null;
		itr = studentdao.readStudent().getSubjects().iterator();
		Iterator itr1=null;
		while(itr.hasNext())
		{
			itr1=((SubjectBean)itr.next()).getAssignments().iterator();
			while(itr1.hasNext())
				unsolvedassignments.add((AssignmentBean) itr.next());
		}
		itr=solvedassignments.iterator();
		while(itr.hasNext())
		{
			unsolvedassignments.remove((AssignmentBean)itr.next());
		}
		return unsolvedassignments;
	}
	

}
