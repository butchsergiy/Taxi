package com.edvantis.jt.case14.dao.hibernate;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import com.edvantis.jt.case14.dao.OrdersDdDAOabstract;
import com.edvantis.jt.case14.model.data.Order;


public class OrdersDBDAOHibernate2 extends OrdersDdDAOabstract {

	private static final OrdersDBDAOHibernate2 singleton = new OrdersDBDAOHibernate2(); 	// singleton
	private OrdersDBDAOHibernate2(){}
	
	public static  OrdersDBDAOHibernate2 getReference(){
		return singleton;
	}
	
	
	
	
	private static final Log log = LogFactory.getLog(OrdersDBDAOHibernate2.class);
//	private static final Log log = LogFactory.getLog(OrdersDBDAOHibernate2.getReference().getClass());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");           // ?????????????? returned null
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI xXxXxXx", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
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
