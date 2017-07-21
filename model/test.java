package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar; 
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class test {

	public static void main(String[] args)  
	{  
		 
        SessionFactory sessionFactory = null; 
        Configuration configuration = new Configuration(); 
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build(); 
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		

	}

}
