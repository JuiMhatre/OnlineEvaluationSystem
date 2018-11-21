package service;

import java.util.ArrayList;
import java.util.List;

import bean.AssignmentBean;
import bean.SubjectBean;
import dao.AssignmentDao;
import dao.SubjectDao;

public class SubjectService {
	SubjectBean subject;
	
	public SubjectService(SubjectBean subject) {
		super();
		this.subject = subject;
	}

	public boolean addSubject()
	{
		boolean flag =true;
		SubjectDao subjectdao = new SubjectDao(subject);
		subjectdao.createSubject();
		return flag;
	}
	public SubjectBean readSubject()
	{
		SubjectDao subjectdao = new SubjectDao(subject);
		subject=subjectdao.readSubject();
		return subject;
	}
	public void updateSubjectAssignmentlist()
	{
		SubjectDao subjectdao = new SubjectDao(subject);
		subjectdao.updateSubject(3);
	}
	public void updateSubjectNotes()
	{
		SubjectDao subjectdao = new SubjectDao(subject);
		subjectdao.updateSubject(1);
		subjectdao.updateSubject(2);
	}
}
