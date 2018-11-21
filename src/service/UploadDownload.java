package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import bean.TeachersBean;

public class UploadDownload {

	public String downloadNotestemp(Map<String,Object> map, FileInputStream fileInputStream)
	{
		
		TeachersBean teacher = (TeachersBean) map.get("user");
		
		TeacherService teacherservice = new TeacherService(teacher);
		 File fileToDownload = new File("C:/Users/juimh/workspace/MIS_AssignmentEvaluationSystem/ServerFiles/Notes/"+teacher.getSubject().getNotesname());
		try {
			fileInputStream = new FileInputStream(fileToDownload);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//downloadname=fileToDownload.getName();
		System.out.println("------------------------"+fileToDownload.getName());
		System.out.println("------------------------"+fileToDownload.getAbsolutePath());
	
		String downloadname =fileToDownload.getAbsolutePath();
		return downloadname;
	}
}
