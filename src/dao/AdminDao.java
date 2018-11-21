package dao;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.AdminBean;

import connectionmanager.SessionHelper;

public class AdminDao {
	private AdminBean admin;
	public AdminDao(AdminBean admin) {
		super();
		this.admin = admin;
	}
	public boolean createadmin()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		session.save(admin);
		transaction.commit();
		session.close();
		return true;
	}
	public AdminBean readAdmin()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		
		admin = (AdminBean) session.get(admin.getClass(), admin.getUserid());
		
		transaction.commit();
		session.close();
		return admin;
	}
	
	public boolean deleteadmin()
	{
		SessionHelper helper = (SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		Session session = helper.getHibernateSesion();
		Transaction transaction = session.beginTransaction();
		admin=readAdmin();
		if(admin == null)
		{
			return false;
		}
		session.delete(admin);
		transaction.commit();
		session.close();
		return true;
	}

}
