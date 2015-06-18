package com.edvantis.jt.case14.dao.factory;

import com.edvantis.jt.case14.dao.OrdersDdDAOabstract;
import com.edvantis.jt.case14.dao.hibernate.OrdersDBDAOHibernate;
import com.edvantis.jt.case14.dao.hibernate.OrdersDBDAOHibernate2;
import com.edvantis.jt.case14.dao.mysql.OrdersDBDAOJBDC;

public class OrdersDbDAOFactory {

	public static OrdersDdDAOabstract getOrdersDbDAO(String ormType, String dbType){
		
		if(ormType.equalsIgnoreCase("jdbc"))	 return OrdersDBDAOJBDC.getReference();
		
		if(ormType.equalsIgnoreCase("hibernate")) return OrdersDBDAOHibernate.getReference();	
		
		if(ormType.equalsIgnoreCase("hibernate2")) return OrdersDBDAOHibernate2.getReference();
		
		return null;
	}
	
}
