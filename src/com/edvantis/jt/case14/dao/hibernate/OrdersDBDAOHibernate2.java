package com.edvantis.jt.case14.dao.hibernate;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.service.ServiceRegistry;

import com.edvantis.jt.case14.dao.OrdersDdDAOabstract;
import com.edvantis.jt.case14.model.data.Order;


public class OrdersDBDAOHibernate2 extends OrdersDdDAOabstract {

	private static   OrdersDBDAOHibernate2 singleton;
	
	private OrdersDBDAOHibernate2(){
		
	}
	
	public static synchronized OrdersDBDAOHibernate2 getReference(){
		if (singleton == null) {
			singleton = new OrdersDBDAOHibernate2();
        }
 		return singleton;
	}
	
	
	
	
	
	private static final Log log = LogFactory.getLog(OrdersDBDAOHibernate2.class);


	
	
//	 sessionFactory = new Configuration().configure(new File("hibernate.cfg.xml")).buildSessionFactory();
//	 
//	 Session session = HibernateUtil.getSessionFactory().openSession();
//	    Transaction transaction = null;
//	    try{
//	        transaction = session.beginTransaction();
//	        session.save(myData);
//	        transaction.commit();
//	        System.out.println("Data is Saved");
//	    }catch(Exception e){
//	        e.printStackTrace();
//	    }finally{
//	        session.close();
//	    }
	
	
	


//	private final SessionFactory sessionFactory = getSessionFactory();
//
//	protected SessionFactory getSessionFactory() {
//		try {
//			return (SessionFactory) new InitialContext().lookup("SessionFactory");           // ??????????????       returned null
//		
//		
//		
//		
//		} catch (Exception e) {
//			log.error("Could not locate SessionFactory in JNDI xXxXxXx", e);
//			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
//		}
//	}
	
	
	
	
	
	
	
//	static Configuration cfg = new Configuration().configure("hibernate.cfg.xml");;
//	
//	static ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
//		
//	
//	private static final SessionFactory sessionFactory = buildSessionFactory();
//
//	
//	private static SessionFactory buildSessionFactory() {
//        try {
//
//            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(serviceRegistry);
//
//            return sessionFactory;
//
//        } catch (Exception e) {
//
//            log.error("Initial SessionFactory creation failed." + e);
//            throw new IllegalStateException("Initial Session Factory creation failed.");
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
	
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	 
	   private static SessionFactory buildSessionFactory()
	   {
	      try
	      {
	         if (sessionFactory == null)
	         {
	            Configuration configuration = new Configuration().configure(OrdersDBDAOHibernate2.class.getResource("hibernate.cfg.xml"));
	            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
	            serviceRegistryBuilder.applySettings(configuration.getProperties());
	            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	         }
	         return sessionFactory;
	      } catch (Throwable ex)
	      {
	         System.err.println("Initial SessionFactory creation failed." + ex);
	         throw new ExceptionInInitializerError(ex);
	      }
	   }
	 
	   public static SessionFactory getSessionFactory()
	   {
	      return sessionFactory;
	   }
	 
	   public static void shutdown()
	   {
	      getSessionFactory().close();
	   }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void persist(Order transientInstance) {
		log.debug("persisting Order instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Order instance) {
		log.debug("attaching dirty Order instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Order instance) {
		log.debug("attaching clean Order instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Order persistentInstance) {
		log.debug("deleting Order instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Order merge(Order detachedInstance) {
		log.debug("merging Order instance");
		try {
			Order result = (Order) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Order findById(int id) {
		log.debug("getting Order instance with id: " + id);
		try {
			Order instance = (Order) sessionFactory.getCurrentSession().get(
					"com.edvantis.jt.case14.model.data.Order", id);
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

	
	public List<Order> findByExample(Order instance) {
		log.debug("finding Order instance by example");
		try {
			List<Order> results = sessionFactory.getCurrentSession().createCriteria("com.edvantis.jt.case14.model.data.Order").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	
	@Override
	public void readAllordersDB() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addToOrdersDB(Order o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateOrder(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delOrder(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}
}
