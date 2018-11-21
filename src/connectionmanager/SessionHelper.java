package connectionmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionHelper {
	Configuration configuration;
	ServiceRegistryBuilder serviceregbuild;
	ServiceRegistry serviceregistry;
	SessionFactory sessionfactory;
	Session session;
	
	

	public SessionHelper()
	{
		configuration = new Configuration().configure();
		serviceregbuild = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		serviceregistry = serviceregbuild.buildServiceRegistry();
		sessionfactory =configuration.buildSessionFactory(serviceregistry);
		
	}
	public Session getHibernateSesion()
	{
		session =sessionfactory.openSession();
		return session;
	}
	public void closeHibernateSession()
	{
		session.close();
	}
	public void closeSessionfactory()
	{
		sessionfactory.close();
	}
}
