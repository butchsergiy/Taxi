package com.edvantis.jt.case14.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.edvantis.jt.case14.dao.OrdersDdDAOabstract;
import com.edvantis.jt.case14.exceptions.OrderException;
import com.edvantis.jt.case14.model.data.Order;
import com.edvantis.jt.case14.model.data.OrdersDB;
import com.edvantis.jt.case14.model.workers.OperatorSimple;
import com.edvantis.jt.case14.validator.OrderValidator;

public class OrdersDBDAOHibernate extends OrdersDdDAOabstract {
	
	Configuration cfg = new Configuration();
	{cfg.configure("com/edvantis/jt/case14/dao/hibernate/hibernate.cfg.xml");}
	
	
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
	SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
	
	
//	Session s = sf.openSession();
//	Transaction tx = s.beginTransaction();
//	
//	Order o = new Order();
//	o = OperatorSimple.orderCreateTemp();
//	try {OrderValidator.orderDataIsValid(o);} catch (OrderException e) {e.printStackTrace();}
//	
//	s.save(o);
//	s.flush();
//	tx.commit();
//	s.clear();
//	sf.close();
	
	
	private static final OrdersDBDAOHibernate singleton = new OrdersDBDAOHibernate();   		// Singleton
	private OrdersDBDAOHibernate(){}		// Private constructor for Singleton
	
	public static OrdersDBDAOHibernate getReference(){
		return singleton;
	}
	
	
	
	
	/* 
	 * Method to CREATE an order in the database 
	 */
	@Override
	public void addToOrdersDB(Order o) {
	      Session session = sf.openSession();
	      Transaction tx = null;
	      
	      try{
	         tx = session.beginTransaction();
	         
//	         ID = (Integer) session.save(o); 
	         session.save(o);
	         
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }

	
	
	   /* Method to  READ all orders from DB MySQL */
	@Override
	public void readAllordersDB() {
	      Session session = sf.openSession();
	      Transaction tx = null;
	      OrdersDB orderDB = OrdersDB.getReference();
	      
	      try{
	         tx = session.beginTransaction();
	         List list = session.createQuery("FROM ordersdb").list(); 
	         
	        
	         for (Iterator iterator = list.iterator(); iterator.hasNext();){
	            Order o = (Order) iterator.next(); 
	            
	            System.out.print("First Name: " + o.getOrderID()); 
	            System.out.print("  Last Name: " + o.get); 
	            System.out.println("  Salary: " + o.getSalary); 
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	   
	   
	   /* Method to UPDATE order */
	   @Override
		public void updateOrder(int id) {
	      Session session = sf.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = 
	                    (Employee)session.get(Employee.class, EmployeeID); 
	         employee.setSalary( salary );
			 session.update(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	   
	   
	   /* Method to DELETE an order from the records */
	   @Override
		public void delOrder(int id){
	      Session session = sf.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = 
	                   (Employee)session.get(Employee.class, EmployeeID); 
	         session.delete(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }




	



	

	
	
	
}

