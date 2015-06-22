package com.edvantis.jt.case14.dao.factory;

import com.edvantis.jt.case14.dao.OrderDAOabstract;
import com.edvantis.jt.case14.dao.hibernate.OrderDAOHibernate;
import com.edvantis.jt.case14.dao.hibernate.OrderDAOHibernate2;
import com.edvantis.jt.case14.dao.mysql.OrdersDBDAOJBDC;

public class OrderDAOFactory {

	public static OrderDAOabstract getOrdersDbDAO(String ormType, String dbType){
		
		if(ormType.equalsIgnoreCase("jdbc"))	 return OrdersDBDAOJBDC.getReference();
		
		if(ormType.equalsIgnoreCase("hibernate")) return OrderDAOHibernate.getReference();	
		
		if(ormType.equalsIgnoreCase("hibernate2")) return OrderDAOHibernate2.getReference();
		
		return null;
	}
	
}
