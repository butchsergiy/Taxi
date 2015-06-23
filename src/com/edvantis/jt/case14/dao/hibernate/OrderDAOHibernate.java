package com.edvantis.jt.case14.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import com.edvantis.jt.case14.dao.OrderDAOabstract;
import com.edvantis.jt.case14.exceptions.OrderException;
import com.edvantis.jt.case14.model.data.Order;
import com.edvantis.jt.case14.model.data.OrdersDB;





public class OrderDAOHibernate extends OrderDAOabstract {

	private static   OrderDAOHibernate singleton;
	
	private OrderDAOHibernate(){		
	}
	
	public static synchronized OrderDAOHibernate getReference(){
		if (singleton == null) {
			singleton = new OrderDAOHibernate();
        }
 		return singleton;
	}
	
		
	OrdersDB ordersDB0 = OrdersDB.getReference();
	
	private static final Log log = LogFactory.getLog(OrderDAOHibernate.class);


	private static SessionFactory sessionFactory = buildSessionFactory();
	 
	   private static SessionFactory buildSessionFactory() {
	      try {
	         if (sessionFactory == null){
				Configuration configuration = new Configuration().configure();
				StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
	        	return sessionFactory;
	         }
	         return sessionFactory;
	      } catch (Throwable ex){
	         System.err.println(" \nXxXXxxxxXXXxxx Initial SessionFactory creation failed." + ex);
	         throw new ExceptionInInitializerError(ex);
	      }
	   }
	 
	   public static SessionFactory getSessionFactory(){
	      return sessionFactory;
	   }
	 
	   public static void shutdown(){
	      getSessionFactory().close();
	   }


	   Session session = null;
	 
	   Transaction transaction = null;
	   

			
	
	//WORKS
	@Override
	public Order findById(int id) {
		log.debug("getting Order instance with id: " + id);
		try {
			session = sessionFactory.openSession();			
			transaction = session.beginTransaction();
			
			Order instance = (Order) session.get("com.edvantis.jt.case14.model.data.Order", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		}
	
	//WORKS
	@Override
	public void addToOrdersDB(Order o) {
		try {
			session = sessionFactory.openSession();			
			transaction = session.beginTransaction();
			session.save(o);
			session.flush();
			transaction.commit();
			System.out.println("Order is Saved");
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
		  finally{			  
	        session.close();        
	    }
	    }
		
		
	/*
	 * WORKS
	 */
	@Override
	public void readAllordersDB() {
			session = sessionFactory.openSession();			
			transaction = session.beginTransaction();
			Order o;
		try {
			List orderss = session.createQuery("FROM Order").list(); 	
			for (Iterator it=orderss.iterator(); it.hasNext();){
				o=(Order)it.next();
				ordersDB0.orderAdd(o);
				System.out.println("Order ("+o.getId()+") date: "+o.getDateAndTime());
				}
			transaction.commit();
		} 
		catch (RuntimeException | OrderException re) {
			log.error("attach failed", re);
//			throw re;
			System.out.println(re.getMessage());
		}
		finally{			  
	        session.close();        
	    }
		}
		
		
	/*
	 * WORKS
	 */
	@Override
	public void delOrder(int id) {
		try {
			session = sessionFactory.openSession();			
			transaction = session.beginTransaction();
			
			Order o = (Order) session.get(Order.class, id);

			System.out.print("Deleting Order #"+id+" ... ");
			
			if (o == null) {
				log.debug("get successful, no instance found");
				System.out.println("get successful, no instance found in DB");
			} else {
				session.delete(o);
				transaction.commit();
				log.debug("get successful, instance found and deleted");
				System.out.println("get successful, instance found and deleted from DB");
			}
		
		} catch (RuntimeException  re) {
			log.error("del failed", re);
			System.out.println("del failed"+ re.getMessage());
			throw re;
		}
		}
	
	@Override
	public void updateOrder(int id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
	}
	
	
	@Override
	public void closeSessionFactory() {
		sessionFactory.close();
	}
	
	
	
/*
 *  next method are just for testing
 *  	
 */
	
	public void attachDirty(Order o) {
		log.debug("attaching dirty Order instance");
		transaction = session.beginTransaction();
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(o);
			 transaction.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	
	
	public void attachClean(Order o) {
		log.debug("attaching clean Order instance");
		try {
			sessionFactory.getCurrentSession().lock(o, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	

	public void persist(Order o) {
		log.debug("persisting Order instance");
		try {
			sessionFactory.getCurrentSession().persist(o);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	

	public void delete(Order o) {
		log.debug("deleting Order instance");
		try {
			sessionFactory.getCurrentSession().delete(o);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Order merge(Order o) {
		log.debug("merging Order instance");
		try {
			Order result = (Order) sessionFactory.getCurrentSession().merge(o);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}



	
	public List<Order> findByExample(Order o) {
		log.debug("finding Order instance by example");
		try {
			List<Order> results = sessionFactory.getCurrentSession().createCriteria("com.edvantis.jt.case14.model.data.Order").add(Example.create(o)).list();
			log.debug("find by example successful, result size: "+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	
	
}
