package action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import bean.UserBean;
import connectionmanager.SessionHelper;
import service.LoginService;

public class LoginPageAction extends ActionSupport implements ModelDriven<UserBean>{

	UserBean user = new UserBean();
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
	public String goRegistration()
	{
		return SUCCESS;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String register()
	{
		String str=ERROR;
		SessionHelper helper = new SessionHelper();
		try{
		
			if(user.getName().equals(""))
			{
				error ="Please Enter your name!!";
				return str;
			}
			if(user.getPassword().equals(""))
			{
				error ="Please Enter the password";
				return str;
			}
				
			if(user.getDesignation()==null)
			{
				error="Please Enter your Designation";
				return str;
			}
			
		ServletActionContext.getContext().getApplication().put("HELPER", helper);
		LoginService loginservice = new LoginService();
		user.setUserid(0);
		boolean flag =loginservice.register(user);
		if(flag)
		{
			str= SUCCESS;
		
		}
		else
			str= ERROR;
		
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			helper.closeSessionfactory();
			ServletActionContext.getContext().getApplication().remove("HELPER");
			
			return str;
		}
		
	}
	
	public String Logout()
	{
		SessionHelper helper =(SessionHelper) ServletActionContext.getContext().getApplication().get("HELPER");
		if(helper==null)
		{
			error ="Session Already Expired";
			return SUCCESS;
		}
		ServletActionContext.getContext().getApplication().remove("HELPER");
		helper.closeSessionfactory();
		
		return SUCCESS;
	}
}
