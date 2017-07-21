package model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class dataBaseTest {

	
	
	
	
	
	public static void main(String[] args)  
	{ 
		SessionFactory sessionFactory  = null; 
		 Configuration configuration = new Configuration();  
		 configuration.configure(); 
		 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build(); 
		 configuration.buildSessionFactory(serviceRegistry);

	}

}
