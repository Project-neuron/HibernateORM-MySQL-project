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
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;

public class test {
	private static SessionFactory sessionfactory;
	public static void main(String[] args)  
	{  
		 
		
        Configuration configuration = new Configuration(); 
        configuration.configure("hibernate.cfg.xml");  
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build(); 
        sessionfactory = configuration.buildSessionFactory(serviceRegistry); 
       
		
        
        test testcase = new test();
		
        Integer empID1 = testcase.addUser("Zara", "Ali");
       
	}  
	
	
	
	 /* Method to CREATE an employee in the database */
	   public static Integer addUser(String userName, String password){
	      Session session = sessionfactory.openSession();
	      Transaction tx = null;
	      Integer userID = null;
	      try{
	         tx = session.beginTransaction();
	         UserProfile user = new UserProfile(userName, password);
	         userID = (Integer) session.save(user); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return userID;
	   }
	   
}
